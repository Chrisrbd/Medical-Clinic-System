import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IDVerification {

    private static String id;
    private static char firstLetterOfIDSearch;

    public static void IDVerify() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        id = input.next();
        firstLetterOfIDSearch = id.charAt(0);
        String fileName = "";
        switch (firstLetterOfIDSearch) {
            case 'P': {
                fileName = "Patients.txt";
                break;
            }
            case 'D': {
                fileName = "Doctors.txt";
                break;
            }
            case 'R': {
                fileName = "Receptionists.txt";
                break;
            }
            default: {
                System.out.println("Invalid ID");
                break;
            }
        }
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(id)) {
                    String userName = br.readLine().substring(6);
                    System.out.println("\nSuccessful authentication!");
                    System.out.println("Welcome " + userName + "!\n");
                    br.close();
                    System.out.println("\nPress enter to continue...");
                    input.nextLine(); // clear the scanner
                    input.nextLine(); // wait for the user to press enter
                    break;                
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    } 

    public static char getFirstLetterOfIDSearch() {
        return firstLetterOfIDSearch;
    }

    public static String getId() {
        return id;
    }

}
