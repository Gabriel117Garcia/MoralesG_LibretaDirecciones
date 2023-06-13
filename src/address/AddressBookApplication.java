package address;

import addressData.AddressBook;

public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.loadEntriesFromFile("src\\addressData\\addressBook.txt");
        Menu menu = new Menu(addressBook);
        menu.displayMenu();
    }
}