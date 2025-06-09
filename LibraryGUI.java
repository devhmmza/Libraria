import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryGUI extends JFrame {
    private Library library;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;

    public LibraryGUI() {
        library = new Library();

        setTitle("Library Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JPanel topPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        JButton borrowButton = new JButton("Borrow Book");
        JButton returnButton = new JButton("Return Book");

        topPanel.add(addButton);
        topPanel.add(borrowButton);
        topPanel.add(returnButton);

        
        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        
        addButton.addActionListener(e -> addBookDialog());
        borrowButton.addActionListener(e -> borrowSelectedBook());
        returnButton.addActionListener(e -> returnSelectedBook());

        setVisible(true);
    }

    
    private void addBookDialog() {
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();

        Object[] fields = {
            "Title:", titleField,
            "Author:", authorField
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Add New Book", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            String author = authorField.getText();
            Book book = new Book(title, author);
            library.addBook(book);
            updateBookList();
        }
    }

    
    private void borrowSelectedBook() {
        int index = bookList.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to borrow.");
            return;
        }
        library.borrowBook(index);
        updateBookList();
    }

    
    private void returnSelectedBook() {
        int index = bookList.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to return.");
            return;
        }
        library.returnBook(index);
        updateBookList();
    }

    
    private void updateBookList() {
        bookListModel.clear();
        java.util.List<Book> books = library.getBooks(); 
        for (Book b : books) {
            String status = b.isAvailable() ? "Available" : "Borrowed";
            bookListModel.addElement(b.getTitle() + " by " + b.getAuthor() + " [" + status + "]");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryGUI());
    }
}
