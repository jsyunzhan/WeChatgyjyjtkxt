package domain.organ.controller;

import domain.base.controller.AbstractActionController;
import domain.organ.entity.OrganEntity;
import domain.organ.service.OrganHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static domain.organ.OrganWebForward.TO_ORGAN_HISTORY_PAGE;
import static domain.organ.OrganWebURLMapping.ORGAN_HISTORY_LIST;
import static domain.organ.OrganWebURLMapping.ORGAN_HISTORY_PAGE;

/**
 * 机关进行校园历史
 */
@Controller
public class OrganHistoryController extends AbstractActionController{

    final private OrganHistoryService organHistoryService;

    @Autowired
    public OrganHistoryController(OrganHistoryService organHistoryService){
        this.organHistoryService = organHistoryService;
    }


    /**
     * 去机关进校园历史
     * @return ModelAndView
     */
    @RequestMapping(value = ORGAN_HISTORY_PAGE)
    public ModelAndView index(){
        return new ModelAndView(TO_ORGAN_HISTORY_PAGE);
    }

    /**
     * 机关进校园历史记录
     * @return List<OrganEntity>
     */
    @RequestMapping(value = ORGAN_HISTORY_LIST)
    @ResponseBody
    public List<OrganEntity> organHistory(@RequestParam("yearString") String yearString,
                                          @RequestParam("monthString") String monthString,
                                          @RequestParam("schoolName") String schoolName){

        final OrganEntity organEntity = new OrganEntity();
        organEntity.setSchoolName(schoolName);
        organEntity.setYearString(yearString);
        organEntity.setMonthString(monthString);
        return organHistoryService.organHistory(organEntity);
    }
}
