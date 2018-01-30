package dangod.wechat.core.model.message.send;

import org.springframework.beans.factory.annotation.Value;

public class BaseSend {
    protected static String FromUserName;
    @Value("${WXID}")
    public  void setFromUserName(String WXID) {
        FromUserName = WXID;
    }
}
