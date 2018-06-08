package domain.organ.dao;

import domain.organ.entity.OrganEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganDao {
    /**
     * 机关进校园新增
     * @param organEntity 新增实体
     * @return Integer
     */
    Integer organComment(OrganEntity organEntity);
}
