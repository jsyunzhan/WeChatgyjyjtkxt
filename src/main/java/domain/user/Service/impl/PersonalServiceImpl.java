package domain.user.Service.impl;

import domain.listen.dao.NoteDao;
import domain.user.Service.PersonalService;
import domain.user.entity.PhoneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<PhoneEntity> getPhoneMessage() {
        return noteDao.getPhoneMessage();
    }
}
