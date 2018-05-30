package domain.listen.controller;

import domain.base.controller.AbstractActionController;
import domain.base.entity.JsonResponseVO;
import domain.listen.entity.NoteEntity;
import domain.listen.entity.SchoolEntity;
import domain.listen.service.NoteCommentService;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import static domain.listen.ListenWebURLMapping.GET_SCHOOL_NAME;
import static domain.listen.ListenWebURLMapping.GET_SCHOOL_TYPE;


/**
 * 听课笔记提交
 */
@Controller
public class NoteCommentController extends AbstractActionController{

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteCommentController.class);

    final private NoteCommentService noteCommentService;

    @Autowired
    public NoteCommentController(NoteCommentService noteCommentService){
        this.noteCommentService = noteCommentService;
    }

    /**
     * 去笔记提交页面
     * @return ModelAndView
     */
    @RequestMapping(value = "/listen/note")
    public ModelAndView index(){
        return new ModelAndView("listen/notes");
    }

    /**
     * 根据 街道id 获取学校类型id
     * @param id 街道id
     * @return List<SchoolEntity>
     */
    @RequestMapping(value = GET_SCHOOL_TYPE)
    @ResponseBody
    public List<SchoolEntity> getSchoolType(@PathVariable("id") Long id){

        return noteCommentService.getSchoolType(id);
    }

    /**
     * 通过 街道id和学校类型id，获取学校名称
     * @param schoolEntity 查询实体
     * @return List<SchoolEntity>
     */
    @RequestMapping(value = GET_SCHOOL_NAME)
    @ResponseBody
    public List<SchoolEntity> getSchool(@RequestBody SchoolEntity schoolEntity){
        return noteCommentService.getSchool(schoolEntity);
    }


    /**
     * 图片上传
     * @param fileArray 文件
     * @return String
     * @throws IOException io异常
     */
    @RequestMapping(value = "/listen/picturecomment",produces="text/html; charset=UTF-8")
    @ResponseBody
    public String pictureComment(@RequestParam("singleFile1") MultipartFile[] fileArray) throws IOException {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH )+1;
        int data = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        //听课人员名称
        final String litenerName = getListenerName();

        String picturePath = "";

        for (int i=0;i<fileArray.length;i++){
            MultipartFile file = fileArray[i];

            if(!file.isEmpty()) {



                //文件存放路径
                String dirPath = "D:/image/" + litenerName + "/" + year + "/" + month + "/" +data;
                //创建文件夹
                File dir = new File(dirPath);
                if (!dir.exists()){
                    dir.mkdirs();
                }

                //获取上传文件的文件名
                String oFileName=file.getOriginalFilename();
                //截取文件后缀名
                String suffix = oFileName.substring(oFileName.indexOf("."),oFileName.length());

                //文件名
                String newFileName = year + "" + month + "" + data + "" + hour + "" + minute + "" + second + "" + i +suffix;

                //文件的绝对路径
                String realPath = dirPath+"/"+newFileName;
                picturePath += realPath;
                picturePath += ",";
                //创建文件
                File tempFile = new File(realPath);

                try {
                    // 先尝试压缩并保存图片
                    Thumbnails.of(file.getInputStream()).scale(1f).outputQuality(0.25f).toFile(tempFile);
                } catch (IOException e) {
                    //文件转换
                    file.transferTo(tempFile);
                }


            }
        }

        return picturePath;
    }

    /**
     * 笔记提交
     * @param noteEntity 提交实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = "/listen/notecomment")
    @ResponseBody
    public JsonResponseVO noteComment(@RequestBody NoteEntity noteEntity){

        final Long loginId = getListenerId();
        noteEntity.setListenerId(loginId);
        noteEntity.setCreateUserId(loginId);
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        try {
            final Boolean flag = noteCommentService.noteComment(noteEntity);
            jsonResponseVO.setSuccess(flag);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("笔记上传，listenerId:{}",noteEntity.getListenerId());
            }
        }catch (Exception e){
            LOGGER.error("业务异常",e);
        }


        return jsonResponseVO;
    }

    @RequestMapping(value = "/listen/noteedit")
    @ResponseBody
    public JsonResponseVO noteEdit(@RequestBody NoteEntity noteEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        noteEntity.setUpdateUserId(getListenerId());
        try {
            final Boolean flag = noteCommentService.noteEdit(noteEntity);
            jsonResponseVO.setSuccess(flag);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("笔记修改，subject:{}",noteEntity.getSubject());
            }
        }catch (Exception e){
            LOGGER.error("业务异常",e);
        }
        return jsonResponseVO;
    }
}
