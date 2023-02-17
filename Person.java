import java.time.LocalDate;

public abstract class Person {

    //attributes
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;

    //constructors
    public Person(String name, LocalDate dateOfBirth, String address, String phoneNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //getters

    public String getName() {
        return name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //methods



}
