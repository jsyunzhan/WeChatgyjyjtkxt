package domain.listen.dao;

import domain.listen.entity.NoteEntity;
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
    Boolean noteComment(NoteEntity noteEntity);

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
}
