import Exception_handle.BookAlreadyBorrowedException;
import Exception_handle.BookNotBorrowedException;
import Exception_handle.BookNotFoundException;

public interface Borrowable {
    void borrowBook(Member member, String isbn) 
        throws BookNotFoundException, BookAlreadyBorrowedException;

    void returnBook(Member member, String isbn) 
        throws BookNotFoundException, BookNotBorrowedException;
}