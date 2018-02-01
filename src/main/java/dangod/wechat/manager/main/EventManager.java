package dangod.wechat.manager.main;

import dangod.wechat.core.model.message.send.TextSend;
import dangod.wechat.manager.event.SubscribeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static dangod.wechat.core.constant.MessageType.*;

@Component
public class EventManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SubscribeManager subscribeManager;

    private Map xml;

    public Map getXml() {
        return xml;
    }

    public void setXml(Map xml) {
        this.xml = xml;
    }
    private String manager(){
        String result = null;
        String openId = (String)xml.get("FromUserName");
        try {
            switch ((String)xml.get("Event")) {

                case EVENT_TYPE_SUBSCRIBE:
                    result = subscribeManager.getResulte(xml);
                    break;
                case EVENT_TYPE_UNSUBSCRIBE:
                    //取消订阅
                    break;
                case EVENT_TYPE_SCAN:
                    result = subscribeManager.getResulte(xml);
                    break;
                case EVENT_TYPE_LOCATION:
                    result = TextSend.send(openId, "收到坐标");
                    break;
                case EVENT_TYPE_CLICK:
                    result = TextSend.send(openId, "收到菜单点击");
                    break;
                case EVENT_TYPE_VIEW:
                    result = TextSend.send(openId, "收到跳转链接");
                    break;
                default:
                    result = TextSend.send(openId, "公众号出故障了呢");
                    throw new Exception("接收到未定义类型的消息");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    public String getResult(){
        String result = "收到事件";
        result = manager();
        return result;
    }
}
