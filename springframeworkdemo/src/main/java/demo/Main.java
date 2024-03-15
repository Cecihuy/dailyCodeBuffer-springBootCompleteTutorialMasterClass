package demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Doctor staff = applicationContext.getBean(Doctor.class);
        staff.assist();
        System.out.println(staff.getQualification());
    }
}