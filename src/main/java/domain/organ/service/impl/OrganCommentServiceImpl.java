package domain.organ.service.impl;

import domain.organ.dao.OrganDao;
import domain.organ.entity.OrganEntity;
import domain.organ.service.OrganCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 机关进校园Service
 */
@Service
public class OrganCommentServiceImpl implements OrganCommentService{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganCommentServiceImpl.class);

    final private OrganDao organDao;

    @Autowired
    public OrganCommentServiceImpl(OrganDao organDao){
        this.organDao = organDao;
    }


    @Override
    public Boolean organComment(OrganEntity organEntity) {

        final Boolean flag = organDao.organComment(organEntity) > 0;

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("机关进校园新增结果:{}",flag);
        }

        return flag;
    }
}
