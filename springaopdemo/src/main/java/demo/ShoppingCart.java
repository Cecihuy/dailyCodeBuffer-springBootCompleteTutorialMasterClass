package demo;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(){
        System.out.println("checkout method from ShoppingCart called");
    }
}