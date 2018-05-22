package domain.user.Service.impl;

import domain.listen.dao.NoteDao;
import domain.user.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonalServiceImpl implements PersonalService {

    final private NoteDao noteDao;

    @Autowired
    public PersonalServiceImpl(NoteDao noteDao){
        this.noteDao = noteDao;
    }
    @Override
    public Integer getThisMonthCount(Long listenerId) {
        return noteDao.getThisMonthCount(listenerId);
    }

    @Override
    public Integer getAllCount(Long listnerId) {
        return noteDao.getAllCount(listnerId);
    }
}
