package domain.organ.service;

import domain.organ.entity.OrganEntity;

import java.util.List;

public interface OrganHistoryService {

    /**
     * 机关进校园历史记录
     * @return List<OrganEntity>
     */
    List<OrganEntity> organHistory(OrganEntity organEntity);
}
