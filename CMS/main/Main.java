import java.util.Scanner;

public class Main {
    private static ContactManager contactManager = new ContactManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber, email);
        contactManager.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private static void updateContact() {
        contactManager.viewContacts();
        System.out.print("Enter contact number to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        Contact updatedContact = new Contact(name, phoneNumber, email);
        contactManager.updateContact(index, updatedContact);
        System.out.println("Contact updated successfully.");
    }

    private static void deleteContact() {
        contactManager.viewContacts();
        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline
        contactManager.deleteContact(index);
        System.out.println("Contact deleted successfully.");
    }
}
