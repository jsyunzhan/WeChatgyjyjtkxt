package domain.listen.dao;

import domain.listen.entity.SchoolEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolDao {
    /**
     * 根据街道类型id,获取学校类型
     * @param id 街道类型id
     * @return List<SchoolEntity>
     */
    List<SchoolEntity> getSchoolType(Long id);

    /**
     * 根据街道id，学校类id，获取学校
     * @param schoolEntity schoolEntity
     * @return List<SchoolEntity>
     */
    List<SchoolEntity> getSchool(SchoolEntity schoolEntity);
}
