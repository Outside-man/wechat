package dangod.wechat.core.model.message.resp;

import dangod.wechat.core.model.message.resp.bo.Image;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_IMAGE;
import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_MUSIC;

public class ImageMessage extends BaseMessage{
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }

    public ImageMessage(String fromUserName, String openId, String mediaId) {
        this.setFromUserName(fromUserName);
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_IMAGE);
        Image = new Image(mediaId);
    }
    public ImageMessage() {
    }
}
