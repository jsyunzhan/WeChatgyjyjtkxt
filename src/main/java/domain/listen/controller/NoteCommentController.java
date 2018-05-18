package domain.listen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 听课笔记提交
 */
@Controller
public class NoteCommentController {

    @RequestMapping(value = "/security/movetologin")
    public ModelAndView index(){
        return new ModelAndView("login");
    }


}
