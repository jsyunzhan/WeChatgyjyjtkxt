package domain.listen.dao;

import domain.listen.entity.NoteEntity;
import domain.user.entity.PhoneEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 笔记
 */
@Repository
public interface NoteDao {
    /**
     * 笔记提交
     * @param noteEntity 提交实体
     * @return Boolean
     */
    Integer noteComment(NoteEntity noteEntity);

    /**
     * 获取自己的笔记
     * @param noteEntity 查询实体
     * @return List<NoteEntity>
     */
    List<NoteEntity> getOwnNote(NoteEntity noteEntity);

    /**
     * 查询分享的笔记
     * @param noteEntity 查询实体
     * @return List<NoteEntity>
     */
    List<NoteEntity> getShareNote(NoteEntity noteEntity);

    /**
     * 获取所有的笔记
     * @param noteEntity 查询实体
     * @return List<NoteEntity>
     */
    List<NoteEntity> getAllNote(NoteEntity noteEntity);

    /**
     * 获取当前登录人，本月听课节数
     * @param listenerId 当然登录人id
     * @return Integer
     */
    Integer getThisMonthCount(Long listenerId);

    /**
     * 获取当前登录人,累计听课节数
     * @param listnerId 当前登录人id
     * @return Integer
     */
    Integer getAllCount(Long listnerId);

    /**
     * 获取手机端消息
     * @return List<PhoneEntity>
     */
    List<PhoneEntity> getPhoneMessage();
}
