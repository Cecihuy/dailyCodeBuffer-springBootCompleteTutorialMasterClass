package demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Doctor doctor = applicationContext.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualification("MBBS");
        System.out.println(doctor);

        /* second time call for prototype scope */
        Doctor doctor2 = applicationContext.getBean(Doctor.class);
        System.out.println(doctor2);
    }
}