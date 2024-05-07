package com.admin.admin.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;


@Aspect
@Component
public class logging {


    Logger log = LoggerFactory.getLogger(logging.class);

    @Pointcut(value = "execution(* com.carz.carz.controller.AdminController.*(..))")
    public void mypointcut(){

    }

    @Around("mypointcut()")
    public Object applicationlogger(ProceedingJoinPoint pjp) throws Throwable{
        ObjectMapper mapper = new ObjectMapper();
        String methodname = pjp.getSignature().getName();
        String classname = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        log.info("method invoked "+classname+" : "+methodname +"()"+"arguments : "+mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        log.info(classname+" : "+methodname +"()"+" response : "+mapper.writeValueAsString(object));
        return object;
    }
}
