import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Information {


    public static void modifyInformation(String id) throws IOException {
        char firstLetterOfIDSearch = id.charAt(0);
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
        Map<String, String> patient = getPatientInfo(fileName, id);
        System.out.println("ID: " + patient.get("id"));
        System.out.println("Name: " + patient.get("name"));
        System.out.println("Date of Birth: " + patient.get("dateOfBirth"));
        System.out.println("Address: " + patient.get("address"));
        System.out.println("Phone Number: " + patient.get("phoneNumber"));
        System.out.println("Insurance Company:" + patient.get("insuranceCompany"));
        // Allow user to modify patient info
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to modify? (name, date of birth, address, phoneNumber, insurance company)");
        String name = patient.get("name");
        String dateOfBirth = patient.get("dateOfBirth");
        String address = patient.get("address");
        String phoneNumber = patient.get("phoneNumber");
        String insuranceCompany = patient.get("insuranceCompany");
        String field = input.nextLine();
        switch(field){
            case "name": {
                name = Registration.enterName();
                break;
            }
            case "dateOfBirth": {
                dateOfBirth = Registration.enterDateOfBirth();
                break;
            }
            case "address": {
                address = Registration.enterAddress();
                break;
            }
            case "phoneNumber": {
                phoneNumber = Registration.enterPhoneNumber();
                break;
            }
            case "insurance company": {
                System.out.println("Enter your insurance company: ");
                insuranceCompany = input.nextLine();
                break;
            }
            default: {
                System.out.println("Invalid field");
                break;
            }
        }
        
        // Update patient info in file
        patient.put("id", id);
        patient.put("name", name);
        patient.put("dateOfBirth", dateOfBirth);
        patient.put("address", address);
        patient.put("phoneNumber", phoneNumber);
        patient.put("insurance company", insuranceCompany);
        updatePatientInfo(fileName, id, patient);
    }
    
    private static Map<String, String> getPatientInfo(String filename, String id) {
        Map<String, String> patient = new HashMap<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("id: " + id)) {
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        if (line.isBlank()) {
                            break;
                        }
                        String[] parts = line.split(": ");
                        patient.put(parts[0], parts[1]);
                    }
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return patient;
    }

    public static void updatePatientInfo(String filename, String id, Map<String, String> patient) throws IOException {
        File inputFile = new File(filename);
        File tempFile = new File("TempPatients.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            boolean foundPatient = false;
            while((currentLine = reader.readLine()) != null) {
                if (currentLine.equals("id: " + id)) {
                    foundPatient = true;
                    for (Map.Entry<String, String> entry : patient.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        writer.write(key + ": " + value);
                        writer.newLine();
                    }
                    writer.newLine();
                } else {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }
            if (!foundPatient) {
                for (Map.Entry<String, String> entry : patient.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    writer.write(key + ": " + value);
                    writer.newLine();
                }
                writer.newLine();
            }
            reader.close();
            writer.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            System.out.println("Error updating patient info: " + e.getMessage());
        }
    }
    
    
}
