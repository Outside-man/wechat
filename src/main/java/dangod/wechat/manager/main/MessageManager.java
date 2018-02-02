package dangod.wechat.manager.main;

import com.alibaba.fastjson.JSON;
import dangod.wechat.core.model.message.req.TextMessage;
import dangod.wechat.core.model.message.send.TextSend;
import dangod.wechat.manager.message.TextManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class MessageManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private TextManager textManager;

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
        System.out.println(JSON.toJSONString(xml));
        try {
            switch ((String)xml.get("MsgType")) {
                case "text":
                    result = textManager.getResulte(new TextMessage(xml));
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
        String result = "收到消息";
        result = manager();
        return result;
    }
}