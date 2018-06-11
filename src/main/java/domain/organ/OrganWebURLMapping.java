package domain.organ;

public class OrganWebURLMapping {

    private OrganWebURLMapping(){

    }

    //机关进校园
    public final static String ORGAN = "/organ/";

    //机关进校园页面
    public final static String ORGAN_COMMENT_PAGE = ORGAN + "commentpage";

    //机关进校园新增
    public final static String ORGAN_COMMENT_ADD = ORGAN_COMMENT_PAGE + "/add";

    //机关进校园修改
    public final static String ORGAN_COMMENT_EDIT = ORGAN_COMMENT_PAGE + "/edit";
}
