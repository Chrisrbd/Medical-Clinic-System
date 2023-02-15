import java.time.LocalDate;

public class Doctor extends Person {
    private String specialty;
  
    public Doctor(String id, String name, LocalDate dateOfBirth, String address, String phoneNumber, String specialty) {
      super(id, name, dateOfBirth, address, phoneNumber);
      this.specialty = specialty;
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
        "id: " + getId() +
        "name: " + getName() +
        "\ndateOfBirth: " + getDateOfBirth() +
        "\naddress: " + getAddress() +
        "\nphoneNumber: " + getPhoneNumber() +
        "\nspecialty: " + specialty
        ;
    }
  }
