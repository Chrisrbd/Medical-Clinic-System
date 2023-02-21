import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Doctor extends Person {
    private String specialty;
    private String id;
    private static int counterId = 0;
  
    public Doctor(String name, LocalDate dateOfBirth, String address, String phoneNumber, String specialty) {
      super(name, dateOfBirth, address, phoneNumber);
      try {
        initCounterId();
      } catch (IOException e) {
        System.out.println("Error while reading the file: " + e.getMessage());
      }
      id = "D" + (++counterId);
      this.specialty = specialty;
    }

    public void initCounterId() throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader("Doctors.txt"));
      String lastLine = "";
      String line = reader.readLine();
      while (line != null) {
        if (line.startsWith("id:")) {
            lastLine = line;
        }
        line = reader.readLine();
      }
      reader.close();

      if (!lastLine.equals("")) {
        String[] tokens = lastLine.split("\\s+");
        if (tokens.length >= 2) {
            String lastId = tokens[1];
            counterId = Integer.parseInt(lastId.substring(1));
        }
      }
    }

    public String getID() {
      return id;
    }

    public void setID(String id) {
      this.id = id;
    }

    public String getSpecialty() {
      return specialty;
    }
  
    public void setSpecialty(String specialty) {
      this.specialty = specialty;
    }
  
    @Override
    public String toString() {
        return
        "\nid: " + id +
        "\nname: " + getName() +
        "\ndateOfBirth: " + getDateOfBirth() +
        "\naddress: " + getAddress() +
        "\nphoneNumber: " + getPhoneNumber() +
        "\nspecialty: " + specialty;
    }
  }
