package dangod.wechat.core.model.message.send;

import dangod.wechat.core.model.message.resp.TextMessage;
import dangod.wechat.core.model.message.resp.VideoMessage;
import dangod.wechat.core.model.message.resp.bo.Video;
import dangod.wechat.core.util.XmlParse;
import org.springframework.stereotype.Component;

@Component
public class VideoSend extends BaseSend {
    public static String send(String openId, String mediaId){
        VideoMessage msg = new VideoMessage(FromUserName, openId, mediaId);
        return msg.toString();
    }
    public static String send(String openId, String mediaId, String title, String description){
        VideoMessage msg = new VideoMessage(FromUserName, openId, mediaId, title, description);
        return msg.toString();
    }
}
