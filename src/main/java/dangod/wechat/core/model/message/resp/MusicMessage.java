package dangod.wechat.core.model.message.resp;

import dangod.wechat.core.model.message.resp.bo.Music;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_MUSIC;

public class MusicMessage extends BaseMessage {

    public MusicMessage(String fromUserName, String openId){
        this.setFromUserName(fromUserName);
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_MUSIC);
    }

    public MusicMessage() {
    }

    // 音乐
    private dangod.wechat.core.model.message.resp.bo.Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
