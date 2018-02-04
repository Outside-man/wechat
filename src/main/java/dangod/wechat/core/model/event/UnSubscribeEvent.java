package dangod.wechat.core.model.event;

import java.util.Map;

public class UnSubscribeEvent extends BaseEvent {
    public UnSubscribeEvent(Map xml) {
        super(xml);
    }

    public UnSubscribeEvent() {

    }
}
