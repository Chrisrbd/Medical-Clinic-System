import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    
        
        //final part
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
                char firstLetterOfID = IDVerification.getFirstLetterOfIDSearch();
                
                switch(firstLetterOfID){
                    case 'P':{ // Patient
                        System.out.println("What do you want to do ?");
                        System.out.println("\n1) Change my personal information");
                        System.out.println("2) Make an appointment with a doctor");
                        System.out.println("3) Manage your appointment");
                        System.out.println("4) Return to the main menu");
                        System.out.print("\nYour choice: ");
                        numMenu = input.nextInt();
                        switch(numMenu){
                            case 1 : {
                                System.out.println("Change my personal information");
                                break;
                            }
                            case 2 : {
                                System.out.println("Make an appointment with a doctor");
                                break;
                            }
                            case 3 : {
                                System.out.println("Manage your appointment");
                                break;
                            }
                            case 4 : {
                                return;
                            }
                        }
                        break;
                    }
                    case 'D':{ // Doctor
                        System.out.println("What do you want to do ?");
                        System.out.println("\n1) Change my personal information");
                        System.out.println("2) Make an appointment with a doctor");
                        System.out.println("3) Manage your appointment");
                        System.out.println("4) Return to the main menu");
                        System.out.print("\nYour choice: ");
                        numMenu = input.nextInt();
                        switch(numMenu){
                            case 1 : {
                                System.out.println("Change my personal information");
                                break;
                            }
                            case 2 : {
                                System.out.println("Make an appointment with a doctor");
                                break;
                            }
                            case 3 : {
                                System.out.println("Manage your appointment");
                                break;
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
                                
                                System.out.println("****************************************************");
                                break;
                            }
                            case 2 : {        
                                // Print out the list of Patient objects
                                System.out.println("Here are all the patients :");

                                System.out.println("****************************************************");
                                break;
                            }
                            case 4 : {
                                return;
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


