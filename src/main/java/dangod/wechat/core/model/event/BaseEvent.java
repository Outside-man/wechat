package dangod.wechat.core.model.event;

import java.util.Map;

public class BaseEvent {
    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（event）
    private String MsgType;
    // 事件类型
    private String Event;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public BaseEvent() {
    }

    public BaseEvent(Map xml){
        try {
            ToUserName = (String)xml.get("ToUserName");
            FromUserName = (String)xml.get("FromUserName");
            CreateTime = (long)xml.get("CreateTime");
            MsgType = (String)xml.get("MsgType");
            Event = (String)xml.get("Event");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
