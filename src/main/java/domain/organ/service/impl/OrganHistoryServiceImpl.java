package domain.organ.service.impl;

import domain.organ.dao.OrganDao;
import domain.organ.entity.OrganEntity;
import domain.organ.service.OrganHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganHistoryServiceImpl implements OrganHistoryService{

    final private OrganDao organDao;

    @Autowired
    public OrganHistoryServiceImpl(OrganDao organDao){
        this.organDao = organDao;
    }

    @Override
    public List<OrganEntity> organHistory(OrganEntity organEntity) {
        return organDao.organHistory(organEntity);
    }
}
