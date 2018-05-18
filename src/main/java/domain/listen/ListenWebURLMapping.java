package domain.listen;

/**
 * 听课查询请求地址
 */
public class ListenWebURLMapping {

    private ListenWebURLMapping(){

    }

    public static final String LISTEN_ROOT = "/listen/";

    public static final String GET_SCHOOL_TYPE = LISTEN_ROOT + "getSchoolType/{id}";

}
