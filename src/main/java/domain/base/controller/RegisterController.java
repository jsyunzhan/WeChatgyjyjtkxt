package domain.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注册Controller
 */
@Controller
public class RegisterController extends AbstractActionController{

    /**
     * 去注册页面
     * @return ModelAndView
     */
    @RequestMapping(value = "/base/register")
    public ModelAndView index(){
        return new ModelAndView("register");
    }
}
