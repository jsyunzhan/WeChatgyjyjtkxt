package domain.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户认证
 */
@Controller
@RequestMapping(value = "/security")
public class UserSecurityController {

    /**
     * 去登录页面
     * @return ModelAndView
     */
    @RequestMapping(value = "/movetologin")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }
}
