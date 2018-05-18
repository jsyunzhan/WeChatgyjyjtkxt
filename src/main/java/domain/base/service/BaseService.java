package domain.base.service;

import domain.base.entity.ParamEntity;

import java.util.List;

public interface BaseService {

    /**
     * 获取参数表信息
     * @param paramType 参数表类型
     * @return List<ParamEntity>
     */
    List<ParamEntity> getParams(String paramType);
}
