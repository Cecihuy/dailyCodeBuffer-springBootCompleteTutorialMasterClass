package demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Staff staff = applicationContext.getBean(Doctor.class);     //change getBean argument to Doctor.class or Nurse.class
        staff.assist();
    }
}