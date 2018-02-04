package dangod.wechat.core.model.message.send;


import dangod.wechat.core.model.message.resp.TextMessage;
import org.springframework.stereotype.Component;

@Component
public class TextSend extends BaseSend {
    public static String send(String openId, String content){
        TextMessage msg = new TextMessage(FromUserName, openId, content);
        return msg.toString();
    }
}
