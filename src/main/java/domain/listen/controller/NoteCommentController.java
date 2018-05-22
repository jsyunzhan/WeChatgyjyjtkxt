package domain.listen.controller;

import domain.base.controller.AbstractActionController;
import domain.base.entity.JsonResponseVO;
import domain.listen.entity.NoteEntity;
import domain.listen.entity.SchoolEntity;
import domain.listen.service.NoteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static domain.listen.ListenWebURLMapping.GET_SCHOOL_NAME;
import static domain.listen.ListenWebURLMapping.GET_SCHOOL_TYPE;


/**
 * 听课笔记提交
 */
@Controller
public class NoteCommentController extends AbstractActionController{

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


    @RequestMapping(value = "/listen/picturecomment")
    @ResponseBody
    public String pictureComment(@RequestParam("singleFile1") MultipartFile[] file,
                               HttpServletRequest request) throws IOException {

        System.out.println("1");

//        if(!file.isEmpty()) {
//            //获取服务器里的文件路径
//            String realPath=request.getSession().getServletContext().getRealPath("upload");
//            System.out.println(realPath);
//            //获取上传文件的文件名
//            String oFileName=file.getOriginalFilename();
//            //截取文件后缀名
//            String suffix = oFileName.substring(oFileName.indexOf("."),oFileName.length());
//            System.out.println(suffix);
//            //uuid + suffix  ;
//            String newFileName = UUID.randomUUID().toString()+suffix;
//            //创建文件
//            File tempFile = new File(realPath+"/"+newFileName);
//            //文件转换
//            file.transferTo(tempFile);
//            return "success";
//        }else {
//            return "fail";
//        }
        return "";
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
        final Boolean flag = noteCommentService.noteComment(noteEntity);
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }
}
