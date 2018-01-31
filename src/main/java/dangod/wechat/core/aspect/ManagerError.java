package dangod.wechat.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ManagerError {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Pointcut("execution(* dangod.wechat.manager.*.*(..))")
    public void Manager(){

    }
    @AfterThrowing("Manager()")
    public void errorManager(JoinPoint jp){
        System.out.println(jp.getTarget().getClass().getName()+"出现Manager异常");
        logger.error(jp.getTarget().getClass().getName()+"出现Manager异常");
    }
}
