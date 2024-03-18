package demo;

public class Doctor implements Staff {
    private String qualification;

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