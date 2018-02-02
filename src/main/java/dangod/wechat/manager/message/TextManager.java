package dangod.wechat.manager.message;

import dangod.wechat.core.model.follower.Follower;
import dangod.wechat.core.model.message.req.TextMessage;
import dangod.wechat.core.model.message.resp.bo.Video;
import dangod.wechat.core.model.message.send.ImageSend;
import dangod.wechat.core.model.message.send.TextSend;
import dangod.wechat.core.model.message.send.VideoSend;
import dangod.wechat.core.service.FollowerGetter;
import dangod.wechat.service.CalculateService;
import dangod.wechat.service.impl.CalculateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TextManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private FollowerGetter followerGetter;
    @Autowired
    private CalculateService calculateService;

    public String getResulte(TextMessage message){
        String openId = message.getFromUserName();
        String result = "收到文字";
        try{

            if(message.getContent().charAt(0)=='#'){
                System.out.println(message.getContent().substring(1));
                result = VideoSend.send(openId, message.getContent().substring(1), "demo", "demo");
            }else if(message.getContent().charAt(0)=='*'){
                System.out.println(message.getContent().substring(1));
                result = ImageSend.send(openId, message.getContent().substring(1));
            } else {
                Follower follower = followerGetter.getFollower(openId);
                result = follower.getNickname() + "要的答案" + calculateService.cal(message.getContent());
                result = TextSend.send(openId, result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
}
