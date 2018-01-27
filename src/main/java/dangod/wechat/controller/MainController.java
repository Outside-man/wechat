package dangod.wechat.controller;

import dangod.wechat.core.util.CheckValid;
import dangod.wechat.core.util.XmlParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static dangod.wechat.controller.constant.ErrorType.ERROR_NOT_FROM_WX;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${Token}")
    private String token;

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
        try {
            if(request.getParameterMap().isEmpty())
                throw new Exception("请求为空");
            map = XmlParse.parseXml(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
