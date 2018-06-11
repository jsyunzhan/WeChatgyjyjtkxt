package domain.organ;

public class OrganWebURLMapping {

    private OrganWebURLMapping(){

    }

    //机关进校园
    public final static String ORGAN = "/organ/";

    //去机关进校园提交页面
    public final static String ORGAN_COMMENT_PAGE = ORGAN + "commentpage";

    //机关进校园新增
    public final static String ORGAN_COMMENT_ADD = ORGAN_COMMENT_PAGE + "/add";

    //机关进校园修改
    public final static String ORGAN_COMMENT_EDIT = ORGAN_COMMENT_PAGE + "/edit";

    //去机关进校园历史页面
    public final static String ORGAN_HISTORY_PAGE = ORGAN + "historypage";

    //机关进校园历史记录
    public final static String ORGAN_HISTORY_LIST = ORGAN_HISTORY_PAGE + "/history";


}
