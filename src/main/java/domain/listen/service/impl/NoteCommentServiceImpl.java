package domain.listen.service.impl;

import domain.listen.dao.NoteDao;
import domain.listen.dao.SchoolDao;
import domain.listen.entity.NoteEntity;
import domain.listen.entity.SchoolEntity;
import domain.listen.service.NoteCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteCommentServiceImpl implements NoteCommentService{

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteCommentServiceImpl.class);

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
        final Boolean flag = noteDao.noteComment(noteEntity) > 0;
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("笔记提交结果:{}",flag);
        }
        return flag;
    }

    @Override
    public Boolean noteEdit(NoteEntity noteEntity) {
        final Boolean flag = noteDao.noteEdit(noteEntity) > 0;

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("笔记修改结果:{}",flag);
        }
        return flag;
    }
}
