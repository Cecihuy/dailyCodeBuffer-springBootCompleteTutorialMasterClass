package demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        String arg = joinPoint.getArgs()[0].toString();
        System.out.println("before logger method called with Argument : " + arg);
    }
    @After("execution(* *.checkout(..))")
    public void afterLogger(){
        System.out.println("after method called");
    }
}