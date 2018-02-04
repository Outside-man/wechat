package dangod.wechat.core.model.message.resp;


import dangod.wechat.core.util.XmlParse;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_TEXT;

public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public TextMessage(String fromUserName, String openId,String content){
        this.setFromUserName(fromUserName);
        this.setToUserName(openId);
        this.setContent(content);
        this.setMsgType(RESP_MESSAGE_TYPE_TEXT);
    }

    public TextMessage() {
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}

