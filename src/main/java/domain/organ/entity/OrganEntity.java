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

    //检查学校id
    private Long schoolId;

    //检查学校name
    private String schoolName;

    //检查内容
    private String checkContent;

    //图片路径
    private String picturePath;

    @Override
    public String toString() {
        return "OrganEntity{" +
                "schoolId=" + schoolId +
                ", checkContent='" + checkContent + '\'' +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
