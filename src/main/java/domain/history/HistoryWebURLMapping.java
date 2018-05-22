package domain.history;

/**
 * 听课历史请求地址
 */
public class HistoryWebURLMapping {

    private HistoryWebURLMapping(){

    }

    //听课笔记提交根目录
    public static final String LISTEN_ROOT = "/listen/";

    //根据选择的乡镇id，获取学校类型下拉框
    public static final String GET_SCHOOL_TYPE = LISTEN_ROOT + "getSchoolType/{id}";

    //获取学校名称下拉框
    public static final String GET_SCHOOL_NAME = LISTEN_ROOT + "getschoolname";

}
