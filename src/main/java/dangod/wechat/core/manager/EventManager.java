package dangod.wechat.core.manager;

import dangod.wechat.core.model.event.*;
import dangod.wechat.core.model.message.send.TextSend;
import dangod.wechat.core.util.XmlParse;
import dangod.wechat.manager.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

import static dangod.wechat.core.constant.MessageType.*;

@Component
public class EventManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${default-recive.error}")
    private String error;
    @Value("${default-recive.undefined}")
    private String undefined;
    @Value("${default-recive.subscribe}")
    private String subscribe;
    @Autowired
    private SubscribeEventManager subscribeEventManager;
    @Autowired
    private UnSubscribeEventManager unSubscribeEventManager;
    @Autowired
    private ClickEventManager clickEventManager;
    @Autowired
    private LocationEventManager LocationEventManager;
    @Autowired
    private ScanEventManager scanEventManager;
    @Autowired
    private ViewEventManager viewEventManager;

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
                    if(xml.containsKey("Ticket")){
                        result = scanEventManager.getResult(new ScanEvent_U(xml));
                        break;
                    }
                    result = subscribeEventManager.getResult(new SubscribeEvent(xml));
                    if(result == null) result = TextSend.send(openId, subscribe);
                    break;
                case EVENT_TYPE_UNSUBSCRIBE:
                    result = unSubscribeEventManager.getResult(new UnSubscribeEvent(xml));
                    break;
                case EVENT_TYPE_SCAN:
                    result = scanEventManager.getResult(new ScanEvent(xml));
                    break;
                case EVENT_TYPE_LOCATION:
                    result = LocationEventManager.getResult(new LocationEvent(xml));
                    break;
                case EVENT_TYPE_CLICK:
                    result = clickEventManager.getResult(new ClickEvent(xml));
                    break;
                case EVENT_TYPE_VIEW:
                    result = viewEventManager.getResult(new ViewEvent(xml));
                    break;
                default:
                    result = TextSend.send(openId, undefined);
                    logger.error("接收到未定义类型的消息\n"+ XmlParse.toXml(xml));
            }
            if(result == null){
                result = TextSend.send(openId, undefined);
                logger.error("接收到未定义类型的消息\n"+ XmlParse.toXml(xml));
            }
        } catch (Exception e) {
            result = TextSend.send(openId, error);
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    public String getResult(){
        String result = manager();
        return result;
    }
}
