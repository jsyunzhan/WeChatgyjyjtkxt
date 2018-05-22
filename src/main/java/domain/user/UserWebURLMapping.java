package domain.user;

public class UserWebURLMapping {

    private UserWebURLMapping(){

    }

    //个人中心根目录
    public static final String USER_ROOT = "/user/";

    //去个人中心页面
    public static final String PERSONAL_PAGE = USER_ROOT + "personal";

    //手机端消息公告
    public static final String PHONE_MESSAGE = PERSONAL_PAGE + "/message";
}
