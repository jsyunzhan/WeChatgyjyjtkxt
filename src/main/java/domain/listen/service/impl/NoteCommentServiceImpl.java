package domain.listen.service.impl;

import domain.listen.dao.NoteDao;
import domain.listen.dao.SchoolDao;
import domain.listen.entity.NoteEntity;
import domain.listen.entity.SchoolEntity;
import domain.listen.service.NoteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteCommentServiceImpl implements NoteCommentService{

    final private SchoolDao schoolDao;
    final private NoteDao noteDao;

    @Autowired
    public NoteCommentServiceImpl(SchoolDao schoolDao,NoteDao noteDao){
        this.schoolDao = schoolDao;
        this.noteDao = noteDao;
    }

    @Override
    public List<SchoolEntity> getSchoolType(Long id) {
        return schoolDao.getSchoolType(id);
    }

    @Override
    public List<SchoolEntity> getSchool(SchoolEntity schoolEntity) {
        return schoolDao.getSchool(schoolEntity);
    }

    @Override
    public Boolean noteComment(NoteEntity noteEntity) {
        return noteDao.noteComment(noteEntity);
    }
}
