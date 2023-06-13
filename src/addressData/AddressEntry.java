package addressData;

import java.util.Scanner;

public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String email;
    private String phoneNumber;

    public AddressEntry(String firstName, String lastName, String street, String city, String state, String postalCode, String email, String phoneNumber) {
        this.firstName = validateString(firstName, "First Name");
        this.lastName = validateString(lastName, "Last Name");
        this.street = validateString(street, "Street");
        this.city = validateString(city, "City");
        this.state = validateString(state, "State");
        this.postalCode = validateString(postalCode, "Postal Code");
        this.email = validateString(email, "Email");
        this.phoneNumber = validateString(phoneNumber, "Phone Number");
    }

    private String validateString(String value, String fieldName) {
        Scanner scanner = new Scanner(System.in);

        while (value.isEmpty()) {
            System.out.println(fieldName + " no puede ser vacío. Por favor ingresa algo válido en " + fieldName + ":");
            value = scanner.nextLine();
        }

        return value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = validateString(firstName, "First Name");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = validateString(lastName, "Last Name");
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = validateString(street, "Street");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = validateString(city, "City");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = validateString(state, "State");
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = validateString(postalCode, "Postal Code");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = validateString(email, "Email");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = validateString(phoneNumber, "Phone Number");
    }

    @Override
    public String toString() {
        return "AddressEntry{" +
                "Nombre='" + firstName + '\'' +
                ", Apellido='" + lastName + '\'' +
                ", Calle='" + street + '\'' +
                ", Ciudad='" + city + '\'' +
                ", Estado='" + state + '\'' +
                ", Código postal='" + postalCode + '\'' +
                ", Correo electrónico='" + email + '\'' +
                ", Teléfono='" + phoneNumber + '\'' +
                '}';
    }
}