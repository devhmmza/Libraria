import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("===== Welcome to the Library Management System =====");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();

                    Book book = new Book(title, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    library.displayBooks();
                    System.out.print("Enter book number to borrow: ");
                    int borrowIndex = scanner.nextInt() - 1;
                    library.borrowBook(borrowIndex);
                    break;

                case 4:
                    library.displayBooks();
                    System.out.print("Enter book number to return: ");
                    int returnIndex = scanner.nextInt() - 1;
                    library.returnBook(returnIndex);
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
