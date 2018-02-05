package dangod.wechat.controller;

import dangod.wechat.core.api.Media;
import dangod.wechat.core.util.CheckValid;
import dangod.wechat.core.util.XmlParse;
import dangod.wechat.core.manager.EventManager;
import dangod.wechat.core.manager.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.Map;

import static dangod.wechat.constant.ErrorType.ERROR_NOT_FROM_WX;
import static dangod.wechat.core.constant.MessageType.REQ_MESSAGE_TYPE_EVENT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${Token}")
    private String token;
    @Autowired
    private MessageManager messageManager;
    @Autowired
    private EventManager eventManager;

    @ResponseBody
    @RequestMapping(value = {"","/","index"}, method = GET)
    public String checkValid(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("signature")String signature,
                             @RequestParam("timestamp")String timestamp,
                             @RequestParam("nonce")String nonce,
                             @RequestParam("echostr")String echostr){
        if(CheckValid.check(signature, timestamp, nonce, token)){
            return request.getParameter("echostr");
        }else {
            logger.error(ERROR_NOT_FROM_WX);
            return ERROR_NOT_FROM_WX;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"","/","index"}, method = POST)
    public String index(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> map = null;
        String responseStr = null;
        try {
            if(request.getParameterMap().isEmpty())
                throw new Exception("请求为空");
            map = XmlParse.parseXml(request);
            String openId = map.get("FromUserName");
            if(map.get("MsgType").equals(REQ_MESSAGE_TYPE_EVENT)){
                eventManager.setXml(map);
                responseStr = eventManager.getResult();
            }else{
                messageManager.setXml(map);
                responseStr = messageManager.getResult();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return responseStr;
    }

    @Autowired
    private Media media;
    @ResponseBody
    @RequestMapping(value = {"/test/{type}"}, method = GET)
    public String test(HttpServletRequest request, HttpServletResponse response,
                       @PathVariable("type")String type){
        String result = "没有该类型文件";
        File file = null;
        switch (type){
            case "video":
                file = new File("file"+ File.separator+"demo.mp4");
                result = media.sendTemp("video", file);
                break;
            case "image":
                file = new File("file"+ File.separator+"test.jpg");
                result = media.sendTemp("image", file);
                break;
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = {"/test"}, method = GET)
    public String test(HttpServletRequest request, HttpServletResponse response){

        return null;
    }


}

