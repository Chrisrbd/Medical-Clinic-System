import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        
    
        
        //final part
        String id =""; 
        int numMenu; 
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while(exit != true){
            try{
                System.out.println("\nWelcome to our Medical Clinic !");
                System.out.println("\n1) Sign up");
                System.out.println("2) Log in");
                System.out.println("3) Exit");
                System.out.print("\nYour choice: ");
                numMenu = input.nextInt();
                while (numMenu != 1 && numMenu != 2 && numMenu != 3) {
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                    System.out.print("\nYour choice: ");
                    numMenu = input.nextInt();
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                break;
            }
            
            if(numMenu == 1){ // Sign up
                Registration.register();
            }
            else if (numMenu == 2){ // Sign in                

                IDVerification.IDVerify();
                id = IDVerification.getId(); // get the id of the user who is logged in
                char firstLetterOfID = IDVerification.getFirstLetterOfIDSearch();
                
                switch(firstLetterOfID){
                    case 'P':{ // Patient
                        while(exit != true){
                            System.out.println("What do you want to do ?");
                            System.out.println("\n1) Change my personal information");
                            System.out.println("2) Make an appointment with a doctor");
                            System.out.println("3) Modify an appointment");
                            System.out.println("4) Cancel an appointment");
                            System.out.println("5) Exit");
                            System.out.print("\nYour choice: ");
                            numMenu = input.nextInt();
                            switch(numMenu){
                                case 1 : {
                                    System.out.println("Change my personal information\n");
                                    Information.modifyInformation(id);
                                    break;
                                }
                                case 2 : {
                                    Appointment.addAppointment();
                                    break;
                                }
                                case 3 : {
                                    System.out.println("Modify an appointment");
                                    break;
                                }
                                case 4 : {
                                    System.out.println("Cancel an appointment");

                                    break;
                                }
                                case 5 : {
                                    System.out.println("\nThank you for using our Medical Clinic System. Goodbye !\n");
                                    exit = true;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    case 'D':{ // Doctor
                        while(exit !=true){
                            System.out.println("What do you want to do ?");
                            System.out.println("\n1) Change my personal information");
                            System.out.println("2) Add a treatment");
                            System.out.println("3) Modify a treatment");
                            System.out.println("4) Delete a treatment");
                            System.out.println("5) List all treatments");
                            System.out.println("6) Exit");
                            System.out.print("\nYour choice: ");
                            numMenu = input.nextInt();
                            switch(numMenu){
                                case 1 : {
                                    System.out.println("Change my personal information");
                                    
                                    break;
                                }
                                case 2 : {
                                    Appointment.addAppointment();
                                    break;
                                }
                                case 3 : {
                                    Treatment.addTreatment();
                                    break;
                                }
                                case 4 : {
                                    break;
                                }
                                case 5 : {
                                    System.out.println("Here are all the treatments :");
                                    PrintFile.printFile("Treatments.txt");
                                    break;
                                }
                                case 6 : {
                                    System.out.println("\nThank you for using our Medical Clinic System. Goodbye !\n");
                                    exit = true;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    case 'R':{ // Receptionist
                        while(exit != true){
                            System.out.println("What do you want to do ?");
                            System.out.println("\n1) Change my personal information");
                            System.out.println("2) List all doctors");
                            System.out.println("3) List all patients");
                            System.out.println("4) Add an Appointment");
                            System.out.println("5) Cancel an appointment");
                            System.out.println("6) Modify an appointment");
                            System.out.println("7) List all appointments");
                            System.out.println("8) Exit");
                            numMenu = input.nextInt();
                            switch (numMenu) {
                                case 2 : {        
                                    // Print out the list of Doctor objects
                                    System.out.println("Here are all the doctors :");
                                    PrintFile.printFile("Doctors.txt");
                                    break;
                                }
                                case 3 : {        
                                    // Print out the list of Patient objects
                                    System.out.println("Here are all the patients :");
                                    PrintFile.printFile("Patients.txt");
                                    break;
                                }
                                case 4 : {
                                    Appointment.addAppointment();
                                    break;
                                }
                                case 5 : {
                                    System.out.println("Cancel an appointment");
                                    break;
                                }
                                case 6 : {
                                    System.out.println("Modify an appointment");
                                    break;
                                }
                                case 7 : {
                                    System.out.println("Here are all the appointments :");
                                    PrintFile.printFile("Appointments.txt");
                                    break;
                                }
                                case 8 : {
                                    System.out.println("\nThank you for using our Medical Clinic System. Goodbye !\n");
                                    exit = true;
                                    break;
                                }
                            }
                        }
                        break;
                    }                
                }
                
            
            }
            else if (numMenu == 3){ // Exit
                System.out.println("\nThank you for using our Medical Clinic System. Goodbye !\n");
                break;
            } 
            
        } // end of while
        input.close();
    } // end of main
} // end of Main class


