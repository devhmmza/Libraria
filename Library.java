import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks(){
        if  (books.isEmpty()){
            System.out.println("No books in library.");
            return;
        }
        for (int i = 0; i < books.size(); i++){
            System.out.print((i + 1) + ". ");
            books.get(i).displayInfo();
        }
    }

    public void borrowBook(int index){
        if  (index < 0 || index >= books.size()){
            System.out.println("Invalid book index");
            return;
        }
        Book book = books.get(index);
        if (book.isAvailable()){
            book.borrow();
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook(int index){
        if (index < 0 || index >= books.size()){
            System.out.println("Invalid book index.");
            return;
        }
        Book book = books.get(index);
        if (!book.isAvailable()) {
            book.returnBook();
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
