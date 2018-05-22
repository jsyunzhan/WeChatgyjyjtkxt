package domain.history.service;

import domain.listen.entity.NoteEntity;

import java.util.List;

/**
 * 历史评课HistoryService
 */
public interface HistoryService {
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
