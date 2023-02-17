import java.time.LocalDate;

public class Patient extends Person {
    private String insuranceCompany;
    private String id;
    private static int compteurId = 0;
  
    public Patient(String name, LocalDate dateOfBirth, String address, String phoneNumber, String insuranceCompany) {
      super(name, dateOfBirth, address, phoneNumber);
      id = "P" + (++compteurId);
      this.insuranceCompany = insuranceCompany;
    }

    public String getID() {
      return id;
    }
  
    public void setID(String id) {
      this.id = id;
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
        "id: " + getID() +
        " name: " + getName() +
        "\ndateOfBirth: " + getDateOfBirth() +
        "\naddress: " + getAddress() +
        "\nphoneNumber: " + getPhoneNumber() +
        "\ninsurance company: " + getInsuranceCompany()
        ;
    }
  }
