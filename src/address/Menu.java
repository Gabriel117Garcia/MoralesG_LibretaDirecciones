package address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import addressData.AddressBook;
import addressData.AddressEntry;

public class Menu {
    private AddressBook addressBook;

    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        Scanner scanner = new Scanner(System.in);
    }

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

    private void loadEntriesFromFile() {
        System.out.print("Ingrese el nombre del archivo: ");
        String fileName = new Scanner(System.in).nextLine();
        addressBook.loadEntriesFromFile(fileName);
    }

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
        String postalCode = scanner.nextLine();

        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();

        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();

        AddressEntry newEntry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phone);
        addressBook.addEntry(newEntry); // Llamar al método correspondiente en la clase AddressBook
        System.out.println("La entrada ha sido agregada correctamente.");
    }

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
