import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrintFile {  
    public static void printFile(String fileName) throws IOException {
        Scanner input = new Scanner(System.in);
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
    
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("\nPress enter to continue...");
        input.nextLine(); // wait for the user to press enter
        reader.close();
    }
    
}
