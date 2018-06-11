package domain.organ.controller;

import domain.base.controller.AbstractActionController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static domain.organ.OrganWebForward.TO_ORGAN_HISTORY_PAGE;
import static domain.organ.OrganWebURLMapping.ORGAN_HISTORY_PAGE;

/**
 * 机关进行校园历史
 */
@Controller
public class OrganHistoryController extends AbstractActionController{

    /**
     * 去机关进校园历史
     * @return ModelAndView
     */
    @RequestMapping(value = ORGAN_HISTORY_PAGE)
    public ModelAndView index(){
        return new ModelAndView(TO_ORGAN_HISTORY_PAGE);
    }
}
