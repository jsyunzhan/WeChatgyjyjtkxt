package domain.base.controller;

import domain.base.entity.JsonResponseVO;
import domain.base.entity.ListenerEntity;
import domain.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册Controller
 */
@Controller
public class RegisterController extends AbstractActionController{
    final BaseService baseService;

    @Autowired
    public RegisterController(BaseService baseService){
        this.baseService = baseService;
    }

    /**
     * 去注册页面
     * @return ModelAndView
     */
    @RequestMapping(value = "/base/register")
    public ModelAndView index(){
        return new ModelAndView("register");
    }


    @RequestMapping(value = "/base/registerSub")
    @ResponseBody
    public JsonResponseVO register(@RequestBody ListenerEntity listenerEntity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String openid = request.getSession().getAttribute("openid").toString();
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        listenerEntity.setOpenId(openid);
        final Boolean flag = baseService.register(listenerEntity);
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }

}
