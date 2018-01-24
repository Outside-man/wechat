package dangod.wechat.controller;

import dangod.wechat.util.CheckValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class IndexController {
    @Autowired
    private CheckValid checkValid;


    @Value("${Token}")
    private String token;



    @ResponseBody
    @RequestMapping(value = {"","/","index"})
    public String index(HttpServletRequest request, HttpServletResponse response){
        System.out.println(token);
        return token;
    }

    @ResponseBody
    @RequestMapping(value = {"/checkVaild"}, method = GET)
    public String checkValid(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("signature")String signature,
                             @RequestParam("timestamp")String timestamp,
                             @RequestParam("nonce")String nonce,
                             @RequestParam("echostr")String echostr){
        if(checkValid.check(token, signature, timestamp, nonce)){
            return echostr;
        }else {
            return "消息并不是来自微信服务器";
        }
    }

}
