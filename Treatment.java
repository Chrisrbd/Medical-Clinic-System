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
        System.out.println("Enter the start date of the treatment (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(input.next());
        System.out.println("Enter the end date of the treatment (yyyy-mm-dd): ");
        LocalDate endDate = LocalDate.parse(input.next());
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

    @Override
    public String toString() {
        return "Treatment [doctor=" + doctor + ", endDate=" + endDate + ", patient=" + patient + ", startDate="
                + startDate + "]";
    }





}
 