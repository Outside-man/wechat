package dangod.wechat.core.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Component
@Aspect
public class RequestCheck {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;


    @Pointcut("execution(* dangod.wechat.controller..*.*(..))")
    public void AllRequest(){

    }

    @Before("AllRequest()")
    public void CheckVaild(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();
        //获取请求方法的request & response
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest) {
                request = (HttpServletRequest) arg;
                request.setCharacterEncoding("UTF-8");
            }
            if(arg instanceof HttpServletResponse) {
                response = (HttpServletResponse) arg;
                response.setCharacterEncoding("UTF-8");
            }
        }
        logger.warn(JSON.toJSONString(request.getParameterMap()));
    }
    

}
