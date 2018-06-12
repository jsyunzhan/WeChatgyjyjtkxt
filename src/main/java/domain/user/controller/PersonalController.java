package domain.user.controller;

import domain.base.controller.AbstractActionController;
import domain.user.Service.PersonalService;
import domain.user.entity.PhoneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static domain.user.UserWebForward.TO_PERSONAL_PAGE;
import static domain.user.UserWebURLMapping.PERSONAL_PAGE;
import static domain.user.UserWebURLMapping.PHONE_MESSAGE;

/**
 * 个人中心Controller
 */
@Controller
public class PersonalController extends AbstractActionController{

    final private PersonalService personalService;

    @Autowired
    public PersonalController(PersonalService personalService){
        this.personalService = personalService;
    }

    //去个人中心页面
    @RequestMapping(value = PERSONAL_PAGE)
    public ModelAndView index(HttpServletRequest request){
        //头像地址
        final String imgUrl = request.getSession().getAttribute("imgUrl").toString();

        //听课用户id
        final Long listnerId = getListenerId();
        final ModelAndView mv = new ModelAndView(TO_PERSONAL_PAGE);
        // 当前月听课节数
        final Integer thisMonthCount = personalService.getThisMonthCount(listnerId);
        //累计听课节数
        final Integer allCount = personalService.getAllCount(listnerId);
        mv.addObject("imgUrl",imgUrl);
        mv.addObject("listenerName",getListenerName());
        mv.addObject("thisMonthCount",thisMonthCount);
        mv.addObject("allCount",allCount);
        mv.addObject("orgFlag",getOrganFlag());
        return mv;
    }

    /**
     * 获取手机端消息公告
     * @return List<PhoneEntity>
     */
    @RequestMapping(value = PHONE_MESSAGE)
    @ResponseBody
    public List<PhoneEntity> getPhoneMessage(){
        return personalService.getPhoneMessage();
    }
}
