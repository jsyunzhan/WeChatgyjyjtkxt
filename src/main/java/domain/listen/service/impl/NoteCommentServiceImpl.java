package domain.listen.service.impl;

import domain.listen.dao.SchoolDao;
import domain.listen.entity.SchoolEntity;
import domain.listen.service.NoteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteCommentServiceImpl implements NoteCommentService{

    final private SchoolDao schoolDao;

    @Autowired
    public NoteCommentServiceImpl(SchoolDao schoolDao){
        this.schoolDao = schoolDao;
    }

    @Override
    public List<SchoolEntity> getSchoolType(Long id) {
        return schoolDao.getSchoolType(id);
    }

    @Override
    public List<SchoolEntity> getSchool(Long streetId, Long schoolTypeId) {
        return schoolDao.getSchool(streetId,schoolTypeId);
    }
}
