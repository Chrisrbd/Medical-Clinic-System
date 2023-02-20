import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IDVerification {

    private static char firstLetterOfIDSearch;

    public static void IDVerify() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String idSearch = input.next();
        input.close(); // close the scanner
        firstLetterOfIDSearch = idSearch.charAt(0);
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
                if (line.contains(idSearch)) {
                    String userName = br.readLine().substring(6);
                    System.out.println("\nSuccessful authentication!");
                    System.out.println("Welcome " + userName + "!\n");
                    br.close();
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
}
