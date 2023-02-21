
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
        System.out.print("Enter the date of the appointment (yyyy-mm-dd): ");
        String newDate = input.next();
        while (!newDate.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[01])")) {
            System.out.println("Invalid date. Please enter a date in the correct format.");
            System.out.print("Enter the date of the appointment (yyyy-mm-dd): ");
            newDate = input.next();
        }
        LocalDate date = LocalDate.parse(newDate);
        System.out.print("Enter the time of the appointment (hh:mm): ");
        String newTime = input.next();
        while (!newTime.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            System.out.println("Invalid time. Please enter a time in the correct format.");
            System.out.print("Enter the time of the appointment (hh:mm): ");
            newTime = input.next();
        }
        LocalTime time = LocalTime.parse(newTime);
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
