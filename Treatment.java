import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Treatment {
    private LocalDate startDate;
    private LocalDate endDate;
    private String doctor;
    private String patient;

    public Treatment(String patient, String doctor, LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.doctor = doctor;
        this.patient = patient;
    }

    public static void addTreatment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Complete the following information to add a treatment");
        System.out.println("Enter the patient name: ");
        String patient = input.nextLine();
        System.out.println("Enter the doctor name ");
        String doctor = input.nextLine();
        System.out.print("Enter the date of the appointment (yyyy-mm-dd): ");
        String newDate = input.next();
        while (!newDate.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[01])")) {
            System.out.println("Invalid date. Please enter a date in the correct format.");
            System.out.print("Enter the date of the appointment (yyyy-mm-dd): ");
            newDate = input.next();
        }
        LocalDate startDate = LocalDate.parse(newDate);
        System.out.print("Enter the date of the appointment (yyyy-mm-dd): ");
        newDate = input.next();
        while (!newDate.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[01])")) {
            System.out.println("Invalid date. Please enter a date in the correct format.");
            System.out.print("Enter the date of the appointment (yyyy-mm-dd): ");
            newDate = input.next();
        }
        LocalDate endDate = LocalDate.parse(newDate);
        Treatment newTreatment = new Treatment(patient, doctor, startDate, endDate);
        System.out.println("Treatment added successfully: ");
        System.out.println(newTreatment);
        writeTreatment(newTreatment);
    }

    public static void writeTreatment(Treatment treatment) {
        String treatmentString = treatment.toString();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Treatments.txt", true));
            writer.write(treatmentString);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error when writing to the treatment : " + e.getMessage());
        }
    }

    public static void deleteTreatment(Treatment treatment) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the patient name: ");
        String patient = input.nextLine();
        System.out.println("Enter the doctor name ");
        String doctor = input.nextLine();

    }

    @Override
    public String toString() {
        return "Treatment [doctor=" + doctor + ", endDate=" + endDate + ", patient=" + patient + ", startDate="
                + startDate + "]";
    }





}
 
