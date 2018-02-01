package dangod.wechat.core.model.message.resp;

import dangod.wechat.core.model.message.resp.bo.Video;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_VIDEO;

public class VideoMessage extends BaseMessage{
    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public VideoMessage(String openId){
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_VIDEO);
    }

    public VideoMessage() {
    }
}
