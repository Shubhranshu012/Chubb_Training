import java.util.*;

import Exception_handle.BookAlreadyBorrowedException;
import Exception_handle.BookNotBorrowedException;
import Exception_handle.BookNotFoundException;
import Exception_handle.MemberNotFoundException;

public class Library implements Borrowable {
    private final Catalog catalog;
    private final HashMap<String, Member> members = new HashMap<>();

    public Library(Catalog catalog) {
        this.catalog = catalog;
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) throws MemberNotFoundException {
        Member member = members.get(memberId);
        if (member == null) {
            throw new MemberNotFoundException("Member ID " + memberId + " not found.");
        }
        return member;
    }

    @Override
    public void borrowBook(Member member, String isbn) 
            throws BookNotFoundException, BookAlreadyBorrowedException {
        Book book = catalog.searchByIsbn(isbn);
        if (book == null) throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        if (book.isBorrowed()) throw new BookAlreadyBorrowedException("Book already borrowed.");
        
        book.borrow();
        System.out.println(member.getName() + " borrowed " + book.getTitle());
    }

    @Override
    public void returnBook(Member member, String isbn) 
            throws BookNotFoundException, BookNotBorrowedException {
        Book book = catalog.searchByIsbn(isbn);
        if (book == null) throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        if (!book.isBorrowed()) throw new BookNotBorrowedException("Book " + book.getTitle() + " was not borrowed.");
        
        book.returned();
        System.out.println(member.getName() + " returned " + book.getTitle());
    }

    public void listAllBooks() {
        for (Book book : catalog.listAllBooks()) {
            System.out.println(book);
        }
    }
}
