
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.logging.FileHandler;


public class Appointment {
    private String patient;
    private String doctor;
    private String reason;
    private LocalDate date;
    private LocalTime time;
    

    public Appointment(String patient, String doctor, String reason, LocalDate date, LocalTime time) {
        this.patient = patient;
        this.doctor = doctor;
        this.reason = reason;
        this.date = date;
        this.time = time;
    }

    public static void addAppointment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Complete the following information to add an appointment");
        System.out.println("Enter the patient name: ");
        String patient = input.nextLine();
        System.out.println("Enter the doctor name ");
        String doctor = input.nextLine();
        System.out.println("Enter the reason for the appointment: ");
        String reason = input.next();
        System.out.println("Enter the date of the appointment (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(input.next());
        System.out.println("Enter the time of the appointment (hh:mm): ");
        LocalTime time = LocalTime.parse(input.next());
        Appointment newAppointment = new Appointment(patient, doctor, reason, date, time);
        System.out.println("Appointment added successfully: ");
        System.out.println(newAppointment);
        writeAppointment(newAppointment);
    }

    public static void writeAppointment(Appointment appointment) {
        String appointmentString = appointment.toString();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Appointments.txt", true));
            writer.write(appointmentString);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error when writing to the appointment : " + e.getMessage());
        }
        
    }
    
    @Override
    public String toString() {
        return "Appointment{" +
                "patient= " + patient +
                ", doctor= " + doctor +
                ", reason= " + reason +
                ", date= " + date +
                ", time= " + time +
                '}';
    }
}
