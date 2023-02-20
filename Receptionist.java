import java.time.LocalDate;


public class Receptionist extends Person{
    


    public Receptionist(String name, LocalDate dateOfBirth, String address, String phoneNumber) {
        super(name, dateOfBirth, address, phoneNumber);
    }

    public String getID() {
        return null;
    }

    @Override
    public String toString() {
        return  
        "id: " + getID() +
        "\nname: " + getName() +
        "\ndateOfBirth: " + getDateOfBirth() +
        "\naddress: " + getAddress() +
        "\nphoneNumber: " + getPhoneNumber();
    }
}
