package dangod.wechat.core.api.impl;


import com.alibaba.fastjson.JSON;
import dangod.wechat.core.api.AccessToken;
import dangod.wechat.core.api.Media;
import dangod.wechat.core.api.impl.AccessTokenImpl;
import dangod.wechat.core.util.DRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class MediaImpl implements Media{
    @Autowired
    private AccessToken accessToken;

    public String sendTemp(String type, File file) {
        String token = this.accessToken.get();
        String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";
        url = String.format(url, token, type);
        String result = DRequest.sendPostFile(url, file);
        return result;
    }

    public String sendPermVideo(String type, File file, String title, String introduction) {
        String token = this.accessToken.get();
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=%s";
        url = String.format(url, token, type);
        Map<String, String> description = new HashMap();
        description.put("title", title);
        description.put("introduction", introduction);
        String jsonParams = JSON.toJSONString(description);
        String result = DRequest.sendPostFile(url, file, jsonParams);
        return result;
    }

    public String sendPerm(String type, File file) {
        if (type.equals("video")) {
            return this.sendPermVideo(type, file, file.getName(), (new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒")).format(Calendar.getInstance().getTime()));
        } else {
            String token = this.accessToken.get();
            String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=%s";
            url = String.format(url, token, type);
            String result = DRequest.sendPostFile(url, file);
            return result;
        }
    }
}
