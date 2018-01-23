package dangod.wechat.controller;

import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @Value("${Token}")
    private String content;

    @ResponseBody
    @RequestMapping(value = {"","/","index"})
    public String index(HttpServletRequest request, HttpServletResponse response){
        System.out.println(content);
        return content;
    }


}
