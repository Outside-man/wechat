package dangod.wechat.core.model.message.req;

import java.util.Map;

public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public ImageMessage() {
    }

    public ImageMessage(Map xml) {
        super(xml);
        try {
            PicUrl = (String)xml.get("PicUrl");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
