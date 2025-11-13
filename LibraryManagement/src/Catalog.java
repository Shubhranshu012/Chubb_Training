import java.util.List;

public interface Catalog {
    void addBook(Book book);
    void removeBook(String isbn);
    Book searchByIsbn(String isbn);
    List<Book> listAllBooks();
}
