package dangod.wechat.manager.event;

import dangod.wechat.core.dao.UserRepo;
import dangod.wechat.core.model.event.SubscribeEvent;
import dangod.wechat.core.model.follower.Follower;
import dangod.wechat.core.model.message.req.TextMessage;
import dangod.wechat.core.model.message.send.TextSend;
import dangod.wechat.core.model.po.User;
import dangod.wechat.core.service.FollowerGetter;
import dangod.wechat.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class SubscribeEventManager {

    @Autowired
    private FollowerGetter followerGetter;
    @Autowired
    private UserRepo userRepo;

    public String getResult(SubscribeEvent event) {
        String openId = event.getFromUserName();
        String result = null;
        try {
            //做关注之后的业务动作
            Follower follower = followerGetter.getFollower(openId);
            User user = new User(openId);
            userRepo.save(user);
//            result = TextSend.send(openId, "欢迎"+follower.getNickname()+"客观订阅~~");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}