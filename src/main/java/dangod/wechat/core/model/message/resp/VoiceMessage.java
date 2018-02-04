package dangod.wechat.core.model.message.resp;

import dangod.wechat.core.model.message.resp.bo.Voice;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_VOICE;

public class VoiceMessage extends BaseMessage {
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }

    public VoiceMessage(String fromUserName, String openId, String mediaId) {
        this.setFromUserName(fromUserName);
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_VOICE);
        Voice = new Voice(mediaId);
    }
    public VoiceMessage() {
    }
}
