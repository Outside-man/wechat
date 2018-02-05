package dangod.wechat.core.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import dangod.wechat.core.api.AccessToken;
import dangod.wechat.core.api.FollowerGetter;
import dangod.wechat.core.model.follower.Follower;
import dangod.wechat.core.util.DRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FollowerGetterImpl implements FollowerGetter{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccessToken accessToken;
    @Value("${AppID}")
    private String appid;
    @Value("${AppSecret}")
    private String secret;

    @Override
    public String getFollowerJSON(String openId) {
        return getFollowerJSON(openId, "zh_CN");
    }

    @Override
    public String getFollowerJSON(String openId, String lang){
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

    @Override
    public Follower getFollower(String openId){
        Map<String,Object> follower = JSON.parseObject(getFollowerJSON(openId),Map.class);
        return new Follower(follower);
    }

    @Override
    public Follower getFollower(String openId, String lang){
        Map<String,Object> follower = JSON.parseObject(getFollowerJSON(openId),Map.class);
        return new Follower(follower);
    }
}
