package dangod.wechat.core.model.message.resp.bo;

public class Voice {
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public Voice(String mediaId) {
        MediaId = mediaId;
    }
}
