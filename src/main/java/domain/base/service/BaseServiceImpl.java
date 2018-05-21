package domain.base.service;

import domain.base.dao.BaseDao;
import domain.base.entity.ListenerEntity;
import domain.base.entity.ParamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseServiceImpl implements BaseService{

    final private BaseDao baseDao;

    @Autowired
    public BaseServiceImpl(BaseDao baseDao){
        this.baseDao = baseDao;
    }


    @Override
    public List<ParamEntity> getParams(String paramType) {
        return baseDao.getParams(paramType);
    }

    @Override
    public ListenerEntity getListenerByOpenId(String openid) {
        return baseDao.getListenerByOpenId(openid);
    }
}
