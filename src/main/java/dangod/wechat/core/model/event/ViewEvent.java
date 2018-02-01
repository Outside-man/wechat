package dangod.wechat.core.model.event;

import java.util.Map;

public class ViewEvent extends BaseEvent{
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public ViewEvent() {
    }

    public ViewEvent(Map xml) {
        super(xml);
        try {
            EventKey = (String)xml.get("EventKey");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
