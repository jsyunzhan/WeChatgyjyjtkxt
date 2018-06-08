package domain.organ.controller;

import domain.base.controller.AbstractActionController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static domain.organ.OrganWebForward.TO_ORGAN_COMMENT_PAGE;
import static domain.organ.OrganWebURLMapping.ORGAN_COMMENT_PAGE;

/**
 * 机关进校园提交
 */

@Controller
public class OrganCommentController extends AbstractActionController{

    /**
     * 去机关进校园页面
     * @return ModelAndView
     */
    @RequestMapping(value = ORGAN_COMMENT_PAGE)
    public ModelAndView index(){
        return new ModelAndView(TO_ORGAN_COMMENT_PAGE);
    }
}
