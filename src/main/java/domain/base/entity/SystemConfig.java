package domain.base.entity;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
//公共文件
public final class SystemConfig {

    //登录Session
    public static final String LOGIN_SESSION= "loginSession";


}
