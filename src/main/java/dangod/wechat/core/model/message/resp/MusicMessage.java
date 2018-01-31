package dangod.wechat.core.model.message.resp;

import dangod.wechat.core.model.message.resp.BaseMessage;

public class MusicMessage extends BaseMessage {

    public MusicMessage(String openId){
        this.setToUserName(openId);
        this.setMsgType("music");
    }
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}