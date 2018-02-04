package dangod.wechat.core.model.message.req;

import java.util.Map;

public class ShortVideoMessage extends BaseMessage {
    private String MediaId;
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public ShortVideoMessage() {
    }

    public ShortVideoMessage(Map xml) {
        super(xml);
        try {
            MediaId = (String)xml.get("MediaId");
            ThumbMediaId = (String)xml.get("ThumbMediaId");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
