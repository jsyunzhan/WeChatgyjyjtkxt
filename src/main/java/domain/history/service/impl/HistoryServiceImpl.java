package domain.history.service.impl;

import domain.history.service.HistoryService;
import domain.listen.dao.NoteDao;
import domain.listen.entity.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService{
    final private NoteDao noteDao;

    @Autowired
    public HistoryServiceImpl(NoteDao noteDao){
        this.noteDao = noteDao;
    }

    @Override
    public List<NoteEntity> getOwnNote(NoteEntity noteEntity) {
        return noteDao.getOwnNote(noteEntity);
    }

    @Override
    public List<NoteEntity> getShareNote(NoteEntity noteEntity) {
        return noteDao.getShareNote(noteEntity);
    }

    @Override
    public List<NoteEntity> getAllNote(NoteEntity noteEntity) {
        return noteDao.getAllNote(noteEntity);
    }
}
