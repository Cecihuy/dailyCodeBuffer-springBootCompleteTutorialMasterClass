package demo;
import org.springframework.beans.factory.BeanNameAware;
import jakarta.annotation.PostConstruct;

public class Doctor implements Staff, BeanNameAware {
    private String qualification;
    
    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Construct Method is called");
    }
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware setBeanName method is called");
    }
    public void assist(){
        System.out.println("Doctor is assisting");
    }
    @Override
    public String toString() {
        return "Doctor [qualification=" + qualification + "]";
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }    
}