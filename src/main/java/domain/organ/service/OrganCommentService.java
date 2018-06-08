package domain.organ.service;

import domain.organ.entity.OrganEntity; /**
 * 机关进校园Service
 */
public interface OrganCommentService {

    /**
     * 机关进校园新增
     * @param organEntity 新增实体
     * @return Boolean
     */
    Boolean organComment(OrganEntity organEntity);

    /**
     * 机关进校园修改
     * @param organEntity 修改实体
     * @return Boolean
     */
    Boolean organEdit(OrganEntity organEntity);
}
