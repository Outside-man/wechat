package dangod.wechat.core.model.message.send;

import dangod.wechat.core.model.message.resp.MusicMessage;
import dangod.wechat.core.model.message.resp.bo.Music;
import org.springframework.stereotype.Component;

@Component
public class MusicSend extends BaseSend{
    public static String send(String openId, String thumbMediaId){
        MusicMessage msg = new MusicMessage(FromUserName, openId);
        Music music = new Music(thumbMediaId);
        msg.setMusic(music);
        return msg.toString();
    }
    public static String send(String openId, String thumbMediaId, String title, String description, String musicUrl, String HQMusicUrl){
        MusicMessage msg = new MusicMessage(FromUserName, openId);
        Music music = new Music(thumbMediaId);
        music.setTitle(title);
        music.setDescription(description);
        music.setMusicUrl(musicUrl);
        music.setHQMusicUrl(HQMusicUrl);
        msg.setMusic(music);
        return msg.toString();
    }
}
