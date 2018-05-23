package domain.history;

/**
 * 听课历史返回jsp
 */

public class HistoryWebForward {

    private HistoryWebForward(){

    }

    //去自己提交的页面
    public final static String HISTORY_NOTE = "history/history";

    //去分享的记录页面
    public final static String SHARE_NOTE_PAGE = "history/share";

    //去所有笔记的记录页面
    public final static String ALL_NOTE_PAGE = "history/allnote";
}
