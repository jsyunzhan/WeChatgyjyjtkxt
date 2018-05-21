package domain.base.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListenerEntity extends AbstractEntity {

    //听课人员姓名
    private String listenerName;

    //听课人员身份证
    private Long listenerNumb;

    //学校名称
    private String schoolName;

    //查看私有笔记权限(0为没有权限,1为有权限)
    private Long permissionFlag;

    //记录open_id(空:未注册)
    private String openId;

    //年份
    private String yearString;

    //听课总数
    private String listenCount;

    //三月听课数量
    private Long threeCount;

    //四月听课数量
    private Long fourCount;

    //五月听课数量
    private Long fiveCount;

    //六月听课数量
    private Long sixCount;

    //九月听课数量
    private Long nineCount;

    //十月听课数量
    private Long tenCount;

    //十一月听课数量
    private Long elevenCount;

    //十二月听课数量
    private Long twelveCount;

    @Override
    public String toString() {
        return "ListenerEntity{" +
                "listenerName='" + listenerName + '\'' +
                ", listenerNumb=" + listenerNumb +
                ", schoolName='" + schoolName + '\'' +
                ", permissionFlag=" + permissionFlag +
                ", openId=" + openId +
                '}';
    }
}
