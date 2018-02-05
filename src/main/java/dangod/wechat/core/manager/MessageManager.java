package dangod.wechat.core.manager;

import com.alibaba.fastjson.JSON;
import dangod.wechat.core.model.message.req.*;
import dangod.wechat.core.model.message.send.TextSend;
import dangod.wechat.core.util.XmlParse;
import dangod.wechat.manager.message.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

import static dangod.wechat.core.constant.MessageType.*;

@Component
public class MessageManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${default-recive.error}")
    private String error;
    @Value("${default-recive.undefined}")
    private String undefined;
    @Autowired
    private TextMessageManager textMessageManager;
    @Autowired
    private ImageMessageManager imageMessageManager;
    @Autowired
    private VoiceMessageManager voiceMessageManager;
    @Autowired
    private VideoMessageManager videoMessageManager;
    @Autowired
    private ShortVideoMessageManager shortVideoMessageManager;
    @Autowired
    private LocationMessageManager locationMessageManager;
    @Autowired
    private LinkMessageManager linkMessageManager;

    private Map xml;

    public Map getXml() {
        return xml;
    }

    public void setXml(Map xml) {
        this.xml = xml;
    }
    private String manager(){
        String openId = (String)xml.get("FromUserName");
        String result = null;
        System.out.println(JSON.toJSONString(xml));
        try {
            switch ((String)xml.get("MsgType")) {
                case REQ_MESSAGE_TYPE_TEXT:
                    result = textMessageManager.getResulte(new TextMessage(xml));
                    break;
                case REQ_MESSAGE_TYPE_IMAGE:
                    result = imageMessageManager.getResulte(new ImageMessage(xml));
                    break;
                case REQ_MESSAGE_TYPE_VOICE:
                    result = voiceMessageManager.getResulte(new VoiceMessage(xml));
                    break;
                case REQ_MESSAGE_TYPE_VIDEO:
                    result = videoMessageManager.getResulte(new VideoMessage(xml));
                    break;
                case REQ_MESSAGE_TYPE_SHORTVIDEO:
                    result = shortVideoMessageManager.getResult(new ShortVideoMessage(xml));
                    break;
                case REQ_MESSAGE_TYPE_LOCATION:
                    result = locationMessageManager.getResult(new LocationMessage(xml));
                    break;
                case REQ_MESSAGE_TYPE_LINK:
                    result = linkMessageManager.getResult(new LinkMessage(xml));
                    break;
                default:
                    result = TextSend.send(openId, undefined);
                    logger.error("接收到未定义类型的消息\n"+ JSON.toJSONString(xml));
            }
            if(result == null){
                result = TextSend.send(openId, undefined);
                logger.error("接收到未定义类型的消息\n"+ JSON.toJSONString(xml));
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