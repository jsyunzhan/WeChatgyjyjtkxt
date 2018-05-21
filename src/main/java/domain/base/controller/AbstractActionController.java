package domain.base.controller;

import domain.base.entity.ListenerEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static domain.base.entity.SystemConfig.LOGIN_SESSION;

/**
 * 公共抽象类
 */
public abstract class AbstractActionController {

    //获取登录Session
    private ListenerEntity getLoginSession(){
//
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();


        return (ListenerEntity) request.getSession().getAttribute(LOGIN_SESSION);
    }

    //获取当前登录id
    protected final Long getListenerId(){
        return getLoginSession().getId();
    }

    //获取登录听课人名称
    protected final String getListenerName(){
        return getLoginSession().getListenerName();
    }

    //获取登录听课人身份证号码
    protected final Long getListenerNumb(){
        return getLoginSession().getListenerNumb();
    }

    //获取登录听课人单位
    protected final String getSchoolName(){
        return getLoginSession().getSchoolName();
    }

    //获取登录听课人是否有权限查看私有笔记
    protected final Long getPermissionFlag(){
        return getLoginSession().getPermissionFlag();
    }

}
