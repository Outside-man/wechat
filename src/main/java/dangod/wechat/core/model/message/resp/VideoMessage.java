package dangod.wechat.core.model.message.resp;

import dangod.wechat.core.model.message.resp.bo.Video;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_VIDEO;

public class VideoMessage extends BaseMessage{
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }

    public VideoMessage(String fromUserName, String openId){
        this.setFromUserName(fromUserName);
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_VIDEO);
    }

    public VideoMessage() {
    }
    public VideoMessage(String fromUserName, String openId, String mediaId, String title, String description){
        this.setFromUserName(fromUserName);
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_VIDEO);
        this.Video = new Video(mediaId, title, description);
    }
    public VideoMessage(String fromUserName, String openId, String mediaId){
        this.setFromUserName(fromUserName);
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_VIDEO);
        this.Video = new Video(mediaId);
    }
}
