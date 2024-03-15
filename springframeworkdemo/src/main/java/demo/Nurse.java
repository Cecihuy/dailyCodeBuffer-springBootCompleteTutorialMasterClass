package demo;

public class Nurse implements Staff {
    private String trial;
    
    public String getTrial() {
        return trial;
    }
    public void setTrial(String trial) {
        this.trial = trial;
    }
    public void assist(){        
        System.out.println("Nurse is assisting");
    }
}
