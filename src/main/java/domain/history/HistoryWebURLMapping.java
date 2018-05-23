package domain.history;

/**
 * 听课历史请求地址
 */
public class HistoryWebURLMapping {

    private HistoryWebURLMapping(){

    }

    //历史记录根目录
    public static final String HISTORY_ROOT = "/history/";

    //历史记录页面
    public static final String HISTORY_PAGE = HISTORY_ROOT + "history";

    //分享记录页面
    public static final String SHARE_PAGE = HISTORY_ROOT + "share";

    public static final String ALL_NOTE_PAGE_REQUEST = HISTORY_ROOT + "allNote";

    /*****************************************************/

    //查看自己的笔记
    public static final String OWN_NOTE = HISTORY_PAGE + "/ownnote";

    //查看自己的笔记
    public static final String SHARE_NOTE = HISTORY_PAGE + "/sharenote";

    //查看所有的笔记
    public static final String ALL_NOTE = HISTORY_PAGE + "/allnote";

}
