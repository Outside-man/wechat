package dangod.wechat.core.model.message.resp;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_VOICE;

public class VoiceMessage extends BaseMessage {
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public VoiceMessage(String openId, String mediaId) {
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_VOICE);
        MediaId = mediaId;
    }
    public VoiceMessage() {
    }
}
