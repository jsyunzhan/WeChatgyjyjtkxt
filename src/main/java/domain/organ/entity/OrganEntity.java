package domain.organ.entity;

import domain.base.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 机关进校园实体
 */
public class OrganEntity extends AbstractEntity{

    //检查标题
    private String checkTitle;

    //检查内容
    private String checkContent;

    @Override
    public String toString() {
        return "OrganEntity{" +
                "checkTitle='" + checkTitle + '\'' +
                ", checkContent='" + checkContent + '\'' +
                '}';
    }
}
