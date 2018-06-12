package domain.organ.controller;

import domain.base.controller.AbstractActionController;
import domain.base.entity.JsonResponseVO;
import domain.organ.entity.OrganEntity;
import domain.organ.service.OrganCommentService;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static domain.organ.OrganWebForward.TO_ORGAN_COMMENT_PAGE;
import static domain.organ.OrganWebURLMapping.*;

/**
 * 机关进校园提交
 */

@Controller
public class OrganCommentController extends AbstractActionController{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganCommentController.class);

    final private OrganCommentService organCommentService;

    @Autowired
    public OrganCommentController(OrganCommentService organCommentService){
        this.organCommentService = organCommentService;
    }

    /**
     * 去机关进校园页面
     * @return ModelAndView
     */
    @RequestMapping(value = ORGAN_COMMENT_PAGE)
    public ModelAndView index(){
        final ModelAndView mv = new ModelAndView(TO_ORGAN_COMMENT_PAGE);
        mv.addObject("orgFlag",getOrganFlag());
        return mv;
    }

    /**
     * 机关进校园图片上传
     * @param fileArray 文件
     * @return String
     * @throws IOException io异常
     */
    @RequestMapping(value = "/organ/picturecomment",produces="text/html; charset=UTF-8")
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
                String dirPath = "D:/image/机关进校园/" + litenerName + "/" + year + "/" + month + "/" +data;
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
     * 机关进校园新增
     * @param organEntity 新增实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = ORGAN_COMMENT_ADD)
    @ResponseBody
    public JsonResponseVO organComment(@RequestBody OrganEntity organEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        try {
            organEntity.setCreateUserId(getListenerId());
            final Boolean flag = organCommentService.organComment(organEntity);
            jsonResponseVO.setSuccess(flag);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("机关进校园提交，schoolId:{}",organEntity.getSchoolId());
            }
        }catch (Exception e){
            LOGGER.error("业务异常",e);
        }
        return jsonResponseVO;
    }

    /**
     * 机关进校园修改
     * @param organEntity 修改实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = ORGAN_COMMENT_EDIT)
    @ResponseBody
    public JsonResponseVO organEdit(@RequestBody OrganEntity organEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        try {
            organEntity.setUpdateUserId(getListenerId());
            final Boolean flag = organCommentService.organEdit(organEntity);
            jsonResponseVO.setSuccess(flag);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("机关进校园修改，schoolId:{}",organEntity.getSchoolId());
            }
        }catch (Exception e){
            LOGGER.error("业务异常",e);
        }
        return jsonResponseVO;
    }
}
