import java.util.Date;

public class Patient extends Person {
    private String insuranceCompany;

    public Patient(String name, Date birthdate, String insuranceCompany){
        super(name, birthdate);
        this.insuranceCompany = insuranceCompany;
    }
    
}
