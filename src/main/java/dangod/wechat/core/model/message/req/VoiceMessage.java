package dangod.wechat.core.model.message.req;

import java.util.Map;

public class VoiceMessage extends BaseMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;
    // 语音识别结果 可能空
    private String Recognition;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public VoiceMessage() {
    }

    public VoiceMessage(Map xml) {
        super(xml);
        try {
            MediaId = (String)xml.get("MediaId");
            Format = (String)xml.get("Format");
            if(xml.containsKey("Recognition"))
                Recognition = (String)xml.get("Recognition");
            else
                Recognition = null;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}