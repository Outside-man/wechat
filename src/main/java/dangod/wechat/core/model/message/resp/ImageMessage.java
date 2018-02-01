package dangod.wechat.core.model.message.resp;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_IMAGE;
import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_MUSIC;

public class ImageMessage extends BaseMessage{
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public ImageMessage(String openId, String mediaId) {
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_IMAGE);
        MediaId = mediaId;
    }
    public ImageMessage() {
    }
}
