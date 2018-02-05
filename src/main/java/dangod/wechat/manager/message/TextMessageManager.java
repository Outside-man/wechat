package dangod.wechat.manager.message;

import dangod.wechat.core.api.RecordAction;
import dangod.wechat.core.dao.ActionLogRepo;
import dangod.wechat.core.dao.ActionRepo;
import dangod.wechat.core.model.follower.Follower;
import dangod.wechat.core.model.message.req.TextMessage;
import dangod.wechat.core.model.message.send.ImageSend;
import dangod.wechat.core.model.message.send.TextSend;
import dangod.wechat.core.model.message.send.VideoSend;
import dangod.wechat.core.api.impl.FollowerGetterImpl;
import dangod.wechat.core.model.po.ActionLog;
import dangod.wechat.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextMessageManager {
    @Autowired
    private FollowerGetterImpl followerGetter;
    @Autowired
    private CalculateService calculateService;
    @Autowired
    private RecordAction recordAction;

    public String getResulte(TextMessage message){
        String openId = message.getFromUserName();
        String result = TextSend.send(openId, "收到文本消息");
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
                recordAction.Record(openId, 1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
}
