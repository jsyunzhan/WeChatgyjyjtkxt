package domain.base.dao;

import domain.base.entity.ListenerEntity;
import domain.base.entity.ParamEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDao {
    /**
     * 获取参数表信息
     * @param paramType 参数表类型
     * @return List<ParamEntity>
     */
    List<ParamEntity> getParams(String paramType);

    /**
     * 根据openId 获取听课用户信息
     * @param openid openId
     * @return ListenerEntity
     */
    ListenerEntity getListenerByOpenId(String openid);
}
