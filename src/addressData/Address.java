package addressData;

/**
 * La clase Address sirve para crear objetos de tipo Address, los cuales
 * representan una dirección de una persona.
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;

    /**
     * Constructor de la clase Address.
     *
     * @param street: Calle de la dirección.
     * @param city: Ciudad de la dirección.
     * @param state: Estado de la dirección.
     * @param postalCode: Código postal de la dirección.
     */
    public Address(String street, String city, String state, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    /**
     * getter del atributo street.
     * @return: Devuelve el atributo street.
     */
    public String getStreet() {
        return street;
    }

    /**
     * getter del atributo city.
     * @return: Devuelve el atributo city.
     */
    public String getCity() {
        return city;
    }

    /**
     * getter del atributo state.
     * @return: Devuelve el atributo state.
     */
    public String getState() {
        return state;
    }

    /**
     * getter del atributo postalCode.
     * @return: Devuelve el atributo postalCode.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * setter del atributo street.
     * @param street: Calle de la dirección.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * setter del atributo city.
     * @param city: Ciudad de la dirección.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * setter del atributo state.
     * @param state: Estado de la dirección.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * setter del atributo postalCode.
     * @param postalCode: Código postal de la dirección.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Método toString de la clase Address.
     * @return: String con la información de la dirección.
     */
    @Override
    public String toString() {
        return "Dirección {" +
                "Calle='" + street + '\'' +
                ", Ciudad='" + city + '\'' +
                ", Estado='" + state + '\'' +
                ", Código postal='" + postalCode + '\'' +
                '}';
    }
}