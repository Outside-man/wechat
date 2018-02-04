package dangod.wechat.core.model.message.send;

import dangod.wechat.core.model.message.resp.VoiceMessage;
import org.springframework.stereotype.Component;

@Component
public class VoiceSend extends BaseSend {
    public static String send(String openId, String mediaId){
        VoiceMessage msg = new VoiceMessage(FromUserName, openId, mediaId);
        return msg.toString();
    }
}
