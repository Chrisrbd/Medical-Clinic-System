import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Registration {

    private static String name ="", dateOfBirth="", address="", phoneNumber="";
    private static Scanner input = new Scanner(System.in);
    private static int numMenu;


    public static void register() {
        try {
            System.out.println("Enter your information: ");
            System.out.print("Name: ");
            name = input.nextLine();

            System.out.print("Date of birth (yyyy-mm-dd): ");
            dateOfBirth = input.nextLine();
            while (!dateOfBirth.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Invalid date. Please enter a date in the correct format.");
                System.out.print("Date of birth (yyyy-mm-dd): ");
                dateOfBirth = input.nextLine();
            }

            System.out.print("Address (number + street name): ");
            address = input.nextLine();
            while (!address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)")) {
                System.out.println("Invalid address. Please enter an address in the correct format.");
                System.out.print("Address (number + street name): ");
                address = input.nextLine();
            }

            System.out.print("Phone number (xxx-xxx-xxxx): ");
            phoneNumber = input.nextLine();
            while (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
                System.out.println("Invalid phone number. Please enter a phone number in the correct format.");
                System.out.print("Phone number (xxx-xxx-xxxx): ");
                phoneNumber = input.nextLine();
            }

            System.out.println("\n1) I am a Patient");
            System.out.println("2) I am a Doctor");
            System.out.println("3) I am the Receptionist");
            System.out.print("\nYour choice: ");
            numMenu = input.nextInt();
            while (numMenu != 1 && numMenu != 2 && numMenu != 3) {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                System.out.print("\nYour choice: ");
                numMenu = input.nextInt();
            }

            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    

        switch (numMenu) {
            case 1 :{ // Register as a patient
                System.out.print("Enter your insurance company name: ");
                String insuranceCompany = input.next();
                Patient newPatient = new Patient(name, LocalDate.parse(dateOfBirth), address, phoneNumber, insuranceCompany);
                try {
                    FileWriter writer = new FileWriter("Patients.txt", true);
                    writer.write(newPatient.toString() + "\n");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                    e.printStackTrace();
                }
                System.out.println("You are registered as a patient.");
                System.out.print("Here is your ID be sure to save it : "+ newPatient.getID());
                System.out.println("\nPress enter to continue...");
                input.nextLine(); // clear the buffer
                input.nextLine(); // wait for the user to press enter
                System.out.println("");
                System.out.println("");
                break;
            }
            case 2 :{ // Register as a doctor
                System.out.print("Enter your specialty: ");
                String specialty = input.next();
                Doctor newDoctor = new Doctor(name, LocalDate.parse(dateOfBirth), address, phoneNumber, specialty);
                try {
                    FileWriter writer = new FileWriter("Doctors.txt", true);
                    writer.write(newDoctor.toString() + "\n");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                    e.printStackTrace();
                }
                System.out.println("You are registered as a doctor.");
                System.out.print("Here is your ID be sure to save it : "+ newDoctor.getID());
                System.out.println("\nPress enter to continue...");
                input.nextLine(); // clear the buffer
                input.nextLine(); // wait for the user to press enter
                System.out.println("");
                System.out.println("");
                break;
            }
            case 3 :{ // Register as the receptionist
                Receptionist newReceptionist = new Receptionist(name, LocalDate.parse(dateOfBirth), address, phoneNumber);
                try {
                    FileWriter writer = new FileWriter("Receptionists.txt", true);
                    writer.write(newReceptionist.toString() + "\n");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                    e.printStackTrace();
                }
                System.out.println("You are registered as a receptionist.");
                System.out.print("Here is your ID be sure to save it : "+ newReceptionist.getID());
                System.out.println("\nPress enter to continue...");
                input.nextLine(); // clear the buffer
                input.nextLine(); // wait for the user to press enter
                System.out.println("");
                System.out.println("");
                break;
            }
        }
    }         

    public static String getName() {
        return name;
    }

    public static String getDateOfBirth() {
        return dateOfBirth;
    }

    public static String getAddress() {
        return address;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }
    
    public static int getNumMenu() {
        return numMenu;
    }
}
