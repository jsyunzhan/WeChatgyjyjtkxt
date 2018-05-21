package domain.listen.controller;

import domain.base.controller.AbstractActionController;
import domain.base.entity.JsonResponseVO;
import domain.listen.entity.NoteEntity;
import domain.listen.entity.SchoolEntity;
import domain.listen.service.NoteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
