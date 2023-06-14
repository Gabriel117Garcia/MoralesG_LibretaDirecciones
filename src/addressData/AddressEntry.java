package addressData;

/**
 * Clase que representa una entrada de dirección/contacto en la libreta de direcciones.
 */
public class AddressEntry {
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private int phoneNumber;

    /**
     * Constructor que acepta un nombre, un apellido, una dirección, un correo electrónico y un número de teléfono.
     * @param firstName     El nombre de la persona.
     * @param lastName      El apellido de la persona.
     * @param address       La dirección de la persona.
     * @param email         El correo electrónico de la persona.
     * @param phoneNumber   El número de teléfono de la persona.
     */
    public AddressEntry(String firstName, String lastName, Address address, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Método que devuelve el nombre completo de la persona.
     * @return El nombre completo de la persona.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }


    /**
     * getter del atributo firstName.
     * @return Devuelve el atributo firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter del atributo firstName.
     * @param firstName: El nuevo valor del atributo firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter del atributo lastName.
     * @return Devuelve el atributo lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter del atributo lastName.
     * @param lastName: El nuevo valor del atributo lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter del atributo address.
     * @return Devuelve el atributo address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * setter del atributo address.
     * @param address: El nuevo valor del atributo address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * getter del atributo email.
     * @return Devuelve el atributo email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter del atributo email.
     * @param email: El nuevo valor del atributo email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter del atributo phoneNumber.
     * @return Devuelve el atributo phoneNumber.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * setter del atributo phoneNumber.
     * @param phoneNumber: El nuevo valor del atributo phoneNumber.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Método que devuelve una cadena con los datos de la persona.
     */
    @Override
    public String toString() {
        return getFullName() + ", " + address.toString() + ", " + email + ", " + phoneNumber;
    }
}