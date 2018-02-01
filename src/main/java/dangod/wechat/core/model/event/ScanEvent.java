package dangod.wechat.core.model.event;

import java.util.Map;

/**
 * 用户已经关注公众号，微信会将带场景值扫描事件推送给开发者。
 */
public class ScanEvent extends BaseEvent{
    private long EventKey;
    private String Ticket;

    public long getEventKey() {
        return EventKey;
    }

    public void setEventKey(long eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public ScanEvent() {
    }

    public ScanEvent(Map xml) {
        super(xml);
        try {
            EventKey = (long)xml.get("EventKey");
            Ticket = (String)xml.get("Ticket");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
