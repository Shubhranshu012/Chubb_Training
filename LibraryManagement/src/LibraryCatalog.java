import java.util.*;

public class LibraryCatalog implements Catalog {
    private final HashMap<String, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    @Override
    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        return books.get(isbn);
    }

    @Override
    public List<Book> listAllBooks() {
        return new ArrayList<>(books.values());
    }
}
