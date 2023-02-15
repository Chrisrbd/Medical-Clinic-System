import java.time.LocalDate;

public class Patient extends Person {
    private String insuranceCompany;
  
    public Patient(String id, String name, LocalDate dateOfBirth, String address, String phoneNumber, String insuranceCompany) {
      super(id, name, dateOfBirth, address, phoneNumber);
      this.insuranceCompany = insuranceCompany;
    }
  
    public String getInsuranceCompany() {
      return insuranceCompany;
    }
  
    public void setInsuranceCompany(String insuranceCompany) {
      this.insuranceCompany = insuranceCompany;
    }
  
    @Override
    public String toString() {
        return  
        "id: " + getId() +
        "name: " + getName() +
        "\ndateOfBirth: " + getDateOfBirth() +
        "\naddress: " + getAddress() +
        "\nphoneNumber: " + getPhoneNumber() +
        "\ninsurance company: " + getInsuranceCompany()
        ;
    }
  }
