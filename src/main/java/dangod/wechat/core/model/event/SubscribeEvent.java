package dangod.wechat.core.model.event;

import java.util.Map;

public class SubscribeEvent extends BaseEvent{
    public SubscribeEvent() {
    }

    public SubscribeEvent(Map xml) {
        super(xml);
    }
}
