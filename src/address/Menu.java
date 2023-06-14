package address;

import java.util.Scanner;
import addressData.Address;
import addressData.AddressBook;
import addressData.AddressEntry;

/**
 * Clase que representa el menú de la aplicación,
 * y que contiene la lógica para cada una de las opciones del menú para el usuario.
 */
public class Menu {
    private AddressBook addressBook;

    /**
     * Constructor de la clase Menu.
     * Recibe como parámetro una instancia de la clase AddressBook.
     * @param addressBook Instancia de la clase AddressBook.
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        Scanner scanner = new Scanner(System.in);
    }

    /**
     * Método que muestra el menú de la aplicación y lee la opción ingresada por el usuario,
     * luego llama al método correspondiente para ejecutar la opción ingresada.
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** Address Book Menu ***");
            System.out.println("a) Cargar entradas desde un archivo");
            System.out.println("b) Agregar una nueva entrada");
            System.out.println("c) Eliminar una entrada");
            System.out.println("d) Buscar entradas por apellido");
            System.out.println("e) Mostrar direcciones en orden alfabético");
            System.out.println("f) Salir");

            System.out.print("\nIngrese una opción: ");
            String option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "a":
                    loadEntriesFromFile();
                    break;
                case "b":
                    addEntry();
                    break;
                case "c":
                    deleteEntry();
                    break;
                case "d":
                    searchByLastName();
                    break;
                case "e":
                    displayEntriesAlphabetically();
                    break;
                case "f":
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }

    /**
     * Método que lee el nombre de un archivo ingresado por el usuario,
     * y llama al método correspondiente en la clase AddressBook para cargar las entradas desde el archivo.
     */
    private void loadEntriesFromFile() {
        addressBook.loadEntriesFromFile("src\\addressData\\addressBook.txt");
    }

    /**
     * Método que sirve para agregar una entrada a la libreta de direcciones.
     */
    private void addEntry() {
        // Lógica para agregar una nueva entrada
        Scanner scanner = new Scanner(System.in);
        System.out.println("Agregar una nueva entrada:");

        System.out.print("Nombre: ");
        String firstName = scanner.nextLine();

        System.out.print("Apellido: ");
        String lastName = scanner.nextLine();

        System.out.print("Calle: ");
        String street = scanner.nextLine();

        System.out.print("Ciudad: ");
        String city = scanner.nextLine();

        System.out.print("Estado: ");
        String state = scanner.nextLine();

        System.out.print("Código postal: ");
        int postalCode = Integer.parseInt(scanner.nextLine());

        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();

        System.out.print("Teléfono: ");
        int phone = Integer.parseInt(scanner.nextLine());

        AddressEntry newEntry = new AddressEntry(firstName, lastName, new Address(street, city, state, postalCode), email, phone);
        addressBook.addEntry(newEntry); // Llamar al método correspondiente en la clase AddressBook
        System.out.println("La entrada ha sido agregada correctamente.");
    }

    /**
     * Método que lee el apellido de una entrada ingresado por el usuario,
     * y llama al método correspondiente en la clase AddressBook para eliminar la entrada.
     */
    private void deleteEntry() {
        // Lógica para eliminar una entrada
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eliminar una entrada:");

        System.out.print("Ingrese el apellido para buscar la entrada a eliminar: ");
        String lastName = scanner.nextLine();

        AddressEntry[] searchResults = addressBook.searchByLastName(lastName); // Llamar al método correspondiente en la clase AddressBook

        if (searchResults.length == 0) {
            System.out.println("No se encontraron entradas con el apellido especificado.");
            return;
        }

        System.out.println("Se encontraron las siguientes entradas:");
        for (int i = 0; i < searchResults.length; i++) {
            System.out.println((i + 1) + ") " + searchResults[i].toString());
        }

        System.out.print("Ingrese el número de la entrada que desea eliminar: ");
        int entryNumber = scanner.nextInt();

        if (entryNumber < 1 || entryNumber > searchResults.length) {
            System.out.println("Número de entrada inválido.");
            return;
        }

        AddressEntry entryToDelete = searchResults[entryNumber - 1];
        addressBook.deleteEntry(entryToDelete); // Llamar al método correspondiente en la clase AddressBook
        System.out.println("La entrada ha sido eliminada correctamente.");
    }

    /**
     * Método que lee el inicio del apellido de una entrada ingresado por el usuario,
     * y llama al método correspondiente en la clase AddressBook para buscar las entradas
     * para mostrarlas en pantalla.
     */
    private void searchByLastName() {
        // Lógica para buscar entradas por apellido
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el inicio del apellido a buscar: ");
        String query = scanner.nextLine();

        AddressEntry[] searchResults = addressBook.searchByLastName(query); // Llamar al método correspondiente en la clase AddressBook

        if (searchResults.length == 0) {
            System.out.println("No se encontraron entradas con el apellido especificado.");
            return;
        }

        System.out.println("Se encontraron las siguientes entradas:");
        for (int i = 0; i < searchResults.length; i++) {
            System.out.println((i + 1) + ") " + searchResults[i].toString());
        }
    }

    /**
     * Método que llama al método correspondiente en la clase AddressBook para obtener
     * todas las entradas y mostrarlas en pantalla de forma alfabética.
     */
    private void displayEntriesAlphabetically() {
        // Lógica para mostrar las direcciones en orden alfabético
        AddressEntry[] entries = addressBook.getEntries(); // Obtener todas las entradas de la clase AddressBook

        if (entries.length == 0) {
            System.out.println("No hay entradas en la libreta de direcciones.");
            return;
        }

        System.out.println("Direcciones en orden alfabético por apellido:");
        for (AddressEntry entry : entries) {
            System.out.println(entry.toString());
        }
    }
}
