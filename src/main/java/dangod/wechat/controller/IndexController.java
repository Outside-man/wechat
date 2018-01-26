package dangod.wechat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @Value("${Token}")
    private String token;



    @ResponseBody
    @RequestMapping(value = {"","/","index"})
    public String index(HttpServletRequest request, HttpServletResponse response){



        return null;
    }


}
