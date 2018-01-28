package dangod.wechat.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DRequest {
    public static String sendGet(String url) {
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
        HttpClient httpClient = new DefaultHttpClient();

        //創建一個httpGet方法

        HttpGet httpGet = new HttpGet(url);


        //設置httpGet的參數信息
        httpGet.setHeader("accept", "*/*");
        httpGet.setHeader("connection", "Keep-Alive");
        httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");


        HttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = null;
        //输出响应的所有头信息

        if (response != null) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                try {
                    HttpEntity entity = response.getEntity();
                    result = EntityUtils.toString(entity, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }else{
            System.err.println("请求失败-返回空");
        }

        //關閉聯接

        httpClient.getConnectionManager().shutdown();

        return result;
    }
}
