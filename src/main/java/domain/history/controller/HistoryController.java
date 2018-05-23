package domain.history.controller;

import domain.base.controller.AbstractActionController;
import domain.history.service.HistoryService;
import domain.listen.entity.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static domain.history.HistoryWebForward.HISTORY_NOTE;
import static domain.history.HistoryWebURLMapping.*;

/**
 * 历史评课Controller
 */
@Controller
public class HistoryController extends AbstractActionController{

    final private HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService){
        this.historyService = historyService;
    }

    //去历史记录页面
    @RequestMapping(value = HISTORY_PAGE)
    public ModelAndView index(){
        final  Long permissionFlag = getPermissionFlag();
        final ModelAndView mv = new ModelAndView(HISTORY_NOTE);

        if (1 == permissionFlag){
            mv.addObject("allNoteUrl","/history/allNote");
        }else {
            mv.addObject("allNoteUrl","");
        }
        return mv;
    }

    /**
     * 查看自己的笔记
     * @param noteEntity 查询实体
     * @return List<NoteEntity>
     */
    @RequestMapping(value = OWN_NOTE)
    @ResponseBody
    public List<NoteEntity> getOwnNote(NoteEntity noteEntity){
        noteEntity.setListenerId(getListenerId());
        return historyService.getOwnNote(noteEntity);
    }

    /**
     * 获取分享的笔记
     * @param noteEntity 查询实体
     * @return List<NoteEntity>
     */
    @RequestMapping(value = SHARE_NOTE)
    @ResponseBody
    public List<NoteEntity> getShareNote(NoteEntity noteEntity){
        return historyService.getShareNote(noteEntity);
    }

    /**
     * 获取所有的笔记
     * @param noteEntity 查询实体
     * @return List<NoteEntity>
     */
    @RequestMapping(value = ALL_NOTE)
    @ResponseBody
    public List<NoteEntity> getAllNote(NoteEntity noteEntity){
        return historyService.getAllNote(noteEntity);
    }

}
