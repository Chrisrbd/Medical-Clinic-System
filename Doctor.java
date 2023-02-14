import java.util.Date;

public class Doctor extends Person{
    
    private String speciality;

    public Doctor(String name, Date birthdate, String speciality){
        super(name, birthdate);
        this.speciality = speciality;
    }
}
