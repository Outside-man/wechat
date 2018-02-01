package dangod.wechat.core.model.event;

import java.util.Map;

/**
 * 用户还未关注公众号，用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
 */
public class ScanEvent_U extends BaseEvent {
    private String EventKey;
    private String Ticket;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public ScanEvent_U() {
    }

    public ScanEvent_U(Map xml) {
        super(xml);
        try {
            EventKey = (String)xml.get("EventKey");
            Ticket = (String)xml.get("Ticket");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
