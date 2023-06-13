package addressData;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Esta clase representa una libreta de direcciones.
 * Contiene una lista de entradas de direcciones y métodos para agregar, eliminar y buscar entradas.
 */
public class AddressBook {
    private List<AddressEntry> entries;

    /**
     * Constructor de la clase AddressBook.
     * Inicializa la lista de entradas de direcciones.
     */
    public AddressBook() {
        entries = new ArrayList<>();
    }

    /**
     * Este método agrega una entrada en las direcciones de la lista
     * y actualiza el archivo de texto.
     * @param entry La entrada que se va a agregar.
     */
    public void addEntry(AddressEntry entry) {
        entries.add(entry);
        saveEntriesToFile();
    }

    /**
     * Este método elimina una entrada en  las direcciones de la lista
     * y actualiza el archivo de texto.
     * @param entry La entrada que se va a eliminar.
     */
    public void deleteEntry(AddressEntry entry) {
        entries.remove(entry);
        saveEntriesToFile();
    }

    /**
     * Este método busca una entrada en las direcciones de la lista,
     * pidiendo al usuario que ingrese una letra del apellido de la persona,
     * y regresa todas las entradas que coinciden con la búsqueda.
     * @return Un arreglo de entradas que coinciden con la búsqueda.
     * @param query La letra del apellido de la persona.
     */
    public AddressEntry[] searchByLastName(String query) {
        List<AddressEntry> searchResults = new ArrayList<>();

        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(query)) {
                searchResults.add(entry);
            }
        }

        return searchResults.toArray(new AddressEntry[0]);
    }

    /**
     * Este método muestra todas las entradas en las direcciones de la lista
     * en orden alfabético.
     * @param entries La lista de entradas que se van a mostrar
     */
    public void displayEntriesAlphabetically() {
        List<AddressEntry> sortedEntries = new ArrayList<>(entries);

        Collections.sort(sortedEntries, new Comparator<AddressEntry>() {
            @Override
            public int compare(AddressEntry entry1, AddressEntry entry2) {
                return entry1.getLastName().compareTo(entry2.getLastName());
            }
        });

        for (AddressEntry entry : sortedEntries) {
            System.out.println(entry.toString());
        }
    }

    /**
     * Este método carga las entradas de direcciones desde un archivo de texto.
     * @param fileName El nombre del archivo de texto.
     */
    public void loadEntriesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String street = parts[2].trim();
                    String city = parts[3].trim();
                    String state = parts[4].trim();
                    String postalCode = parts[5].trim();
                    String email = parts[6].trim();
                    String phone = parts[7].trim();

                    AddressEntry entry = new AddressEntry(firstName, lastName, new Address(street, city, state, postalCode), email, phone);
                    entries.add(entry);
                }
            }
            System.out.println("Las entradas se cargaron correctamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al cargar las entradas desde el archivo: " + e.getMessage());
        }
    }

    /**
     * Este método guarda las entradas de direcciones en un archivo de texto.
     * @param fileName El nombre del archivo de texto.
     */
    private void saveEntriesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\addressData\\addressBook.txt"  ))) {
            for (AddressEntry entry : entries) {
                writer.write(entry.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las entradas en el archivo: " + e.getMessage());
        }
    }

    /**
     * Este método regresa todas las entradas en las direcciones de la lista.
     * @return Un arreglo de entradas.
     */
    public AddressEntry[] getEntries () {
        return entries.toArray(new AddressEntry[0]);
    }
}