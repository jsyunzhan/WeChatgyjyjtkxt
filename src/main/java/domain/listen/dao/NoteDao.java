package domain.listen.dao;

import domain.listen.entity.NoteEntity;
import org.springframework.stereotype.Repository;

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
}
