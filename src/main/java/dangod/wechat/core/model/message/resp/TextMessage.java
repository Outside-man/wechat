package dangod.wechat.core.model.message.resp;


import dangod.wechat.core.util.XmlParse;

public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public TextMessage(String openId,String content){
        this.setToUserName(openId);
        this.setContent(content);
        this.setMsgType("text");
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString(){
        return XmlParse.toXml(this);
    }
}

