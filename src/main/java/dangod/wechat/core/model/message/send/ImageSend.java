package dangod.wechat.core.model.message.send;

import dangod.wechat.core.model.message.resp.ImageMessage;
import dangod.wechat.core.model.message.resp.TextMessage;
import org.springframework.stereotype.Component;

@Component
public class ImageSend extends BaseSend {
    public static String send(String openId, String mediaId){
        ImageMessage msg = new ImageMessage(FromUserName, openId, mediaId);
        return msg.toString();
    }
}