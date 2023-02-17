import java.time.LocalDate;

public class Doctor extends Person {
    private String specialty;
    private String id;
    private static int compteurId = 0;
  
    public Doctor(String name, LocalDate dateOfBirth, String address, String phoneNumber, String specialty) {
      super(name, dateOfBirth, address, phoneNumber);
      this.specialty = specialty;
      id = "D" + (++compteurId);
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
        "name: " + getName() +
        "\ndateOfBirth: " + getDateOfBirth() +
        "\naddress: " + getAddress() +
        "\nphoneNumber: " + getPhoneNumber() +
        "\nspecialty: " + specialty
        ;
    }
  }
