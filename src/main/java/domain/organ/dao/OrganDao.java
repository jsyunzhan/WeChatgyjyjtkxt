package domain.organ.dao;

import domain.organ.entity.OrganEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganDao {
    /**
     * 机关进校园新增
     * @param organEntity 新增实体
     * @return Integer
     */
    Integer organComment(OrganEntity organEntity);

    /**
     * 机关进校园修改
     * @param organEntity 修改实体
     * @return Integer
     */
    Integer organEdit(OrganEntity organEntity);

    /**
     * 机关进校园历史记录
     * @return List<OrganEntity>
     */
    List<OrganEntity> organHistory(OrganEntity organEntity);
}
