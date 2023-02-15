import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        ArrayList <Doctor> doctorList = new ArrayList<>();
        ArrayList <Patient> patientList = new ArrayList<>();

        // Create some doctors
        Doctor doctor1 = new Doctor("D1", "John Smith", LocalDate.of(1975, 5, 12), "12 rue de chez elle", "025055432", "Cardiology");
        Doctor doctor2 = new Doctor("D2","Jane Doe", LocalDate.of(1982, 9, 25), "12 rue de chez lui", "05765725", "Pediatrics");
        
        // Create some patients
        Patient patient1 = new Patient("P1","John Doe", LocalDate.of(1985, 6, 10), "123 Main St.", "555-1234", "ABC Insurance");
        Patient patient2 = new Patient("P2","Jane Smith", LocalDate.of(1990, 3, 15), "456 Oak Ave.", "555-5678", "XYZ Insurance");
        Patient patient3 = new Patient("P3","Bob Johnson", LocalDate.of(1975, 9, 1), "789 Elm St.", "555-9012", "DEF Insurance");
        
        // Add doctors to the list
        doctorList.add(doctor1);
        doctorList.add(doctor2);

        // Add patients to the list
        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);

        //final part
        int numMenu; 
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while(exit != true){
            System.out.println("\nWelcome to our Medical Clinic !");
            System.out.println("\nAre you registered with us ? y/n");
            char registered = input.next().charAt(0);
            if(registered == 'n'){
                System.out.println("\n1) I am a Patient");
                System.out.println("2) I am a Doctor");
                System.out.println("3) I am the Receptionist");
                System.out.print("\nYour choice: ");
                numMenu = input.nextInt();
                switch (numMenu) {
                    case 1 :{ // Register as a patient

                        break;
                    }
                    case 2 :{ // Register as a doctor

                        break;
                    }
                    case 3 :{ // Register as the receptionist

                        break;
                    }
                }
            }
            else if (registered == 'y'){
                System.out.print("Enter your ID: ");
                String ID = input.next();
                char firstLetterOfID = ID.charAt(0);
                switch(firstLetterOfID){
                    case 'P':{ // Patient
                        System.out.println("\nHello "+ID+" !"); 
                        System.out.println("What do you want to do ?");
                        System.out.println("\n1) Change my personal informations");
                        System.out.println("2) Make an appointment with a doctor");
                        System.out.println("3) Manage your appointment");
                        System.out.println("4) Return to the main menu");
                        System.out.print("\nYour choice: ");
                        numMenu = input.nextInt();
                        switch(numMenu){
                            case 1 : {
                                
                            }
                            case 2 : {
                                
                            }
                            case 3 : {
                                
                            }
                            case 4 : {
                                return;
                            }
                        }
                        break;
                    }
                    case 'D':{ // Doctor
                        System.out.println("\nHello "+ID+" !"); 
                        System.out.println("What do you want to do ?");
                        System.out.println("\n1) Change my personal informations");
                        System.out.println("2) Make an appointment with a doctor");
                        System.out.println("3) Manage your appointment");
                        System.out.println("4) Return to the main menu");
                        System.out.print("\nYour choice: ");
                        numMenu = input.nextInt();
                        switch(numMenu){
                            case 1 : {
                                
                            }
                            case 2 : {
                                
                            }
                            case 3 : {
                                
                            }
                            case 4 : {
                                return;
                            }
                        }
                        break;
                    }
                    case 'R':{ // Receptionist
                        System.out.println("What do you want to do ?");
                        System.out.println("1) List all doctors");
                        System.out.println("2) List all patients");
                        System.out.println("4) Return to the main menu");
                        numMenu = input.nextInt();
                        switch (numMenu) {
                            case 1 : {        
                                // Print out the list of Doctor objects
                                System.out.println("Here are all the doctors :");
                                for (Doctor doctor : doctorList) {
                                    System.out.println(doctor+"\n");
                                }
                                System.out.println("****************************************************");
                                break;
                            }
                            case 2 : {        
                                // Print out the list of Patient objects
                                System.out.println("Here are all the patients :");
                                for (Patient patient : patientList) {
                                    System.out.println(patient+"\n");
                                }
                                System.out.println("****************************************************");
                                break;
                            }
                            case 4 : {
                                return;
                            }
                        }
                        
                    }                
                }
            }

            else {
                System.out.println("Please enter a valid answer");
                return;
            } 
        }
    }
}
