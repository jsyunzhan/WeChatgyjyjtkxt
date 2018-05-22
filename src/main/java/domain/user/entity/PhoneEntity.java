package domain.user.entity;

import domain.base.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 手机端消息实体
 */
@Getter
@Setter
public class PhoneEntity extends AbstractEntity {

    //标题
    private String title;

    //内容
    private String message;

    @Override
    public String toString() {
        return "PhoneEntity{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
