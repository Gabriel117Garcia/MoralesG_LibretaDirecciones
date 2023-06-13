package address;

import addressData.AddressBook;

/**
 * Contiene la clase principal del programa.
 */
public class AddressBookApplication {

    /**
     * Método principal del programa, que crea una instancia del objeto AddressBook,
     * una del objeto Menu y llama al método displayMenu() de este último.
     * @param args Argumentos de la línea de comando.
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.loadEntriesFromFile("src\\addressData\\addressBook.txt");
        Menu menu = new Menu(addressBook);
        menu.displayMenu();
    }
}