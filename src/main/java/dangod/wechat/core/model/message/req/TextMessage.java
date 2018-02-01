package dangod.wechat.core.model.message.req;

import java.util.Map;

public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public TextMessage() {
    }

    public TextMessage(Map xml) {
        super(xml);
        try {
            Content = (String) xml.get("Content");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
