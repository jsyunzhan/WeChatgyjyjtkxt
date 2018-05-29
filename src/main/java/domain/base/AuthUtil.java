package domain.base;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class AuthUtil {

    //开发
//    public static final String APPID = "wx4145f1f6b4855b05";
//    public static final String APPSECTE = "8f8d11172d83eca0db4c7df47e65acb9";

    //测试
    public static final String APPID = "wx0fb6f354d2df9769";
    public static final String APPSECTE = "ec2de67c0a9d1221b49a339182407509";

    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = client.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        if (entity !=null){
            String result = EntityUtils.toString(entity,"UTF-8");
            jsonObject = JSONObject.parseObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }
}
