package demo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuthenticationAspect {
    @Pointcut(value = "within(demo..*)")
    public void authenticatingPointCut(){

    }
    @Pointcut(value = "within(demo..*)")
    public void authorizationPointCut(){

    }
    @Before(value = "authenticatingPointCut() && authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticating the request");
    }
}