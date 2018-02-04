package dangod.wechat.core.model.message.resp.bo;

public class Image {
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }


    public Image(String mediaId) {
        MediaId = mediaId;
    }
}
