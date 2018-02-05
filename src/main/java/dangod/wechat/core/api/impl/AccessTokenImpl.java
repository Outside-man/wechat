package dangod.wechat.core.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import dangod.wechat.core.api.AccessToken;
import dangod.wechat.core.util.DRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccessTokenImpl implements AccessToken {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${AppID}")
    private String appid;
    @Value("${AppSecret}")
    private String secret;
    private final String grant_type = "client_credential";
    private final String urlTemp = "https://api.weixin.qq.com/cgi-bin/token?grant_type=%s&appid=%s&secret=%s";
    private static String accessToken;
    private static int expires_in;//accessToken有效时间
    @Override
    public String get() {
        if(accessToken!=null)
            return accessToken;

        String resultStr = null;
        String url = String.format(urlTemp, grant_type, appid, secret);
        resultStr = DRequest.sendGet(url);
        try{
            Map resultmap = (Map)JSON.parse(resultStr);
            if(resultmap.containsKey("errcode")){
                throw new Exception("errcode:"+resultmap.get("errcode")+" errmsg:"+resultmap.get("errmsg"));
            }
            if(resultmap.containsKey("access_token")){
                accessToken = resultmap.get("access_token").toString();
                System.out.println(accessToken);
            }
            if(resultmap.containsKey("expires_in")){
                expires_in = (int)resultmap.get("expires_in");
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        accessToken = null;
                        System.out.println("accessToken已过期");
                        timer.cancel();
                    }
                }, (expires_in-5)*1000);
            }
        } catch (JSONException e){
            logger.error("请求AccessToken 返回格式错误");
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return accessToken;
    }
}
