package dangod.wechat.core.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import dangod.wechat.core.service.AccessToken;
import dangod.wechat.core.util.DRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class Follower {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccessToken accessToken;
    @Value("${AppID}")
    private String appid;
    @Value("${AppSecret}")
    private String secret;

    public String getFollower(String openId) {
        return getFollower(openId, "zh_CN");
    }

    public String getFollower(String openId, String lang){
        final String urlTemp = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=%s";
        String acc = accessToken.get();
        String url = String.format(urlTemp, acc, openId, lang);
        String resultStr = null;
        resultStr = DRequest.sendGet(url);
        try{
            Map resultmap = (Map) JSON.parse(resultStr);
            if(resultmap.containsKey("errcode")){
                throw new Exception("errcode:"+resultmap.get("errcode")+" errmsg:"+resultmap.get("errmsg"));
            }
        } catch (JSONException e){
            logger.error("请求关注者基本信息 返回格式错误");
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return resultStr;
    }
}
