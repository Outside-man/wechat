package dangod.wechat.core.model.message.req;

import java.util.Map;

public class LinkMessage extends BaseMessage {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public LinkMessage() {
    }

    public LinkMessage(Map xml) {
        super(xml);
        try {
            Title = (String)xml.get("Title");
            Description = (String)xml.get("Description");
            Url = (String)xml.get("Url");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
