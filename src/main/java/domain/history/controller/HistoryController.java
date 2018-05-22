package domain.history.controller;

import domain.base.controller.AbstractActionController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import static domain.history.HistoryWebForward.HISTORY_NOTE;

@Controller
public class HistoryController extends AbstractActionController{

    //去历史记录页面
    public ModelAndView index(){
        return new ModelAndView(HISTORY_NOTE);
    }
}
