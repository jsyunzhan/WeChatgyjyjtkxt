package domain.user.controller;

import domain.base.controller.AbstractActionController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static domain.user.UserWebForward.TO_PERSONAL_PAGE;
import static domain.user.UserWebURLMapping.PERSONAL_PAGE;

/**
 * 个人中心Controller
 */
@Controller
public class PersonalController extends AbstractActionController{

    @RequestMapping(value = PERSONAL_PAGE)
    public ModelAndView index(){
        return new ModelAndView(TO_PERSONAL_PAGE);
    }
}
