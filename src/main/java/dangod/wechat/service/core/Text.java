package dangod.wechat.service.core;


import dangod.wechat.core.message.resp.TextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Text {
    private static String FromUserName;
    @Value("${WXID}")
    public  void setFromUserName(String WXID) {
        FromUserName = WXID;
    }
    public static String send(String openId, String content){
        TextMessage msg = new TextMessage(openId, content);
        msg.setFromUserName(FromUserName);
        return msg.toString();
    }
}
