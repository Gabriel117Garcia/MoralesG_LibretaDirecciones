package addressData;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddressBook {
    private List<AddressEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public void addEntry(AddressEntry entry) {
        entries.add(entry);
        saveEntriesToFile();
    }

    public void deleteEntry(AddressEntry entry) {
        entries.remove(entry);
        saveEntriesToFile();
    }

    public AddressEntry[] searchByLastName(String query) {
        List<AddressEntry> searchResults = new ArrayList<>();

        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(query)) {
                searchResults.add(entry);
            }
        }

        return searchResults.toArray(new AddressEntry[0]);
    }

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

                    AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phone);
                    entries.add(entry);
                }
            }
            System.out.println("Las entradas se cargaron correctamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al cargar las entradas desde el archivo: " + e.getMessage());
        }
    }

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
    public AddressEntry[] getEntries () {
        return entries.toArray(new AddressEntry[0]);
    }
}