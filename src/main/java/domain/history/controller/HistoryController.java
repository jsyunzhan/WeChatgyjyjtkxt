package domain.history.controller;

import domain.base.controller.AbstractActionController;
import domain.history.service.HistoryService;
import domain.listen.entity.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import static domain.history.HistoryWebForward.*;
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
    public ModelAndView history(){
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
     * 去分享笔记页面
     * @return ModelAndView
     */
    @RequestMapping(value = SHARE_PAGE)
    public ModelAndView share(){
        final  Long permissionFlag = getPermissionFlag();
        final ModelAndView mv = new ModelAndView(SHARE_NOTE_PAGE);
        if (1 == permissionFlag){
            mv.addObject("allNoteUrl","/history/allNote");
        }else {
            mv.addObject("allNoteUrl","");
        }
        return mv;
    }

    /**
     * 去所有笔记页面
     * @return ModelAndView
     */
    @RequestMapping(value = ALL_NOTE_PAGE_REQUEST)
    public ModelAndView allNote(){
        final  Long permissionFlag = getPermissionFlag();
        final ModelAndView mv = new ModelAndView(ALL_NOTE_PAGE);

        if (1 == permissionFlag){
            mv.addObject("allNoteUrl","/history/allNote");
        }else {
            mv.addObject("allNoteUrl","");
        }

        return mv;
    }


    /**
     * 查看自己的笔记
     * @param
     * @return List<NoteEntity>
     */
    @RequestMapping(value = OWN_NOTE)
    @ResponseBody
    public List<NoteEntity> getOwnNote(@RequestParam("yearString") String yearString,
                                       @RequestParam("monthString") String monthString,
                                       @RequestParam("subject") String subject){
        final NoteEntity noteEntity = new NoteEntity();
        noteEntity.setYearString(yearString);
        noteEntity.setMonthString(monthString);
        noteEntity.setSubject(subject);
        noteEntity.setListenerId(getListenerId());
        return historyService.getOwnNote(noteEntity);
    }

    /**
     * 获取分享的笔记
     * @return List<NoteEntity>
     */
    @RequestMapping(value = SHARE_NOTE)
    @ResponseBody
    public List<NoteEntity> getShareNote(@RequestParam("yearString") String yearString,
                                         @RequestParam("monthString") String monthString,
                                         @RequestParam("subject") String subject){
        final NoteEntity noteEntity = new NoteEntity();
        noteEntity.setYearString(yearString);
        noteEntity.setMonthString(monthString);
        noteEntity.setSubject(subject);
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

    /**
     * 获取图片，并解码
     * @param noteEntity
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/listen/getPictureByte")
    @ResponseBody
    public String[] getPictureByte(@RequestBody NoteEntity noteEntity) throws IOException {

        //获取图片路径
        final String path = noteEntity.getPicturePath();
        //获取图片路径地址
        final String[] pathArr=path.split(",");
        //需要返回的base64数组
        String[] base64Array = new String[pathArr.length];

        for (int i=0;i<pathArr.length;i++){
            //图片地址
            String pahtStr = pathArr[i];
            //获取数组
            byte[] imageByte = Files.readAllBytes(Paths.get(pahtStr));
            //转码
            String base64String= Base64.getEncoder().encodeToString(imageByte);
            //添加到64数组
            base64Array[i] = base64String;
        }
        return base64Array;
    }

}
