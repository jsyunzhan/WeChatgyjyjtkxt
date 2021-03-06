package domain.base.controller;

import com.alibaba.fastjson.JSONObject;
import domain.base.AuthUtil;
import domain.base.entity.ListenerEntity;
import domain.base.entity.ParamEntity;
import domain.base.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;

import static domain.base.BaseWebURLMapping.PARAM_URL;
import static domain.base.entity.SystemConfig.LOGIN_SESSION;

@Controller
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    final private BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService){
        this.baseService = baseService;
    }

    @RequestMapping(value = PARAM_URL)
    @ResponseBody
    public List<ParamEntity> getParams(@PathVariable("paramType") String paramType){
        return baseService.getParams(paramType);
    }

    //去登陆页面
    @RequestMapping(value = "/security/movetologin")
    @ResponseBody
    public void doget(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("微信登录认证");
        }

        //开发
//        String backUrl = "http://192.168.0.171:80"+request.getContextPath()+"/security/backUrl";

        //测试
        String backUrl = "http://jy.gylzzx.cn:8888"+request.getContextPath()+"/security/backUrl";

        String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID
                + "&redirect_uri=" +URLEncoder.encode(backUrl)
                +"&response_type=code" +
                "&scope=snsapi_userinfo&state=STATE#wechat_redirect";

        response.sendRedirect(url);
    }

    //微信接口返回地址
    @RequestMapping(value = "/security/backUrl")
    public void doBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID +
                "&secret=" + AuthUtil.APPSECTE +
                "&code=" + code +
                "&grant_type=authorization_code";

        JSONObject jsonObject = AuthUtil.doGetJson(url);

        String openid = jsonObject.getString("openid");
        String token = jsonObject.getString("access_token");

        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token +
                "&openid=" + openid +
                "&lang=zh_CN";

        JSONObject userInfo = AuthUtil.doGetJson(infoUrl);

        final String imgUrl = userInfo.getString("headimgurl");

        login(imgUrl,openid,request,response);

    }

    //登录
    private void login(String imgUrl,String openid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        final ListenerEntity listenerEntity = baseService.getListenerByOpenId(openid);

        final String path = request.getContextPath();

        if (Objects.isNull(listenerEntity)){
            request.getSession().setAttribute("openid",openid);

            response.sendRedirect(path+"/base/register");
        }else {

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("登录成功，listener:{}",listenerEntity.getListenerName());
            }
            request.getSession().setAttribute(LOGIN_SESSION,listenerEntity);
            request.getSession().setAttribute("imgUrl",imgUrl);
            response.sendRedirect( path+"/user/personal");

        }

    }
}
