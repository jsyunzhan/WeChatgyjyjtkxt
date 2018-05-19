package domain.listen.entity;

import domain.base.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 学校实体类
 */
@Getter
@Setter
public class SchoolEntity extends AbstractEntity{

    //学校类型ID
    private Long schoolTypeId;

    //学校类型名称
    private String schoolTypeName;

    //街道ID
    private Long StreetId;

    //街道名称
    private String StreetName;

    //学校名称
    private String SchoolName;



}
