package domain.listen.controller;

import domain.listen.entity.SchoolEntity;
import domain.listen.service.NoteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static domain.listen.ListenWebURLMapping.GET_SCHOOL_TYPE;


/**
 * 听课笔记提交
 */
@Controller
public class NoteCommentController {

    final private NoteCommentService noteCommentService;

    @Autowired
    public NoteCommentController(NoteCommentService noteCommentService){
        this.noteCommentService = noteCommentService;
    }

    @RequestMapping(value = "/security/movetologin")
    public ModelAndView index(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = GET_SCHOOL_TYPE)
    @ResponseBody
    public List<SchoolEntity> getSchoolType(@PathVariable("id") Long id){

        return noteCommentService.getSchoolType(id);
    }

}