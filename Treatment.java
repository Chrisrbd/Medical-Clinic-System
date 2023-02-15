import java.util.Date;

public class Treatment {
    private Date date;
    private Date startTime;
    private Date endTime;
    private Doctor doctor;
    private Patient patient;

    public Treatment(Date date, Date startTime, Date endTime, Doctor doctor, Patient patient) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
        this.patient = patient;
    }

    //getters
    public Date getDate() {
        return date;
    }
    public Date getStartTime() {
        return startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    
    //setters
    public void setDate(Date date) {
        this.date = date;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
 