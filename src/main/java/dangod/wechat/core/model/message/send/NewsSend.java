package dangod.wechat.core.model.message.send;

import dangod.wechat.core.model.message.resp.NewsMessage;
import dangod.wechat.core.model.message.resp.bo.News;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsSend extends BaseSend {
    public static String send(String openId, List<News> articles){
        NewsMessage msg = new NewsMessage(FromUserName, openId, articles);
        return msg.toString();
    }
}
