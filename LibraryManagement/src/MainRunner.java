import java.util.Scanner;

import Exception_handle.BookAlreadyBorrowedException;
import Exception_handle.BookNotBorrowedException;
import Exception_handle.BookNotFoundException;
import Exception_handle.MemberNotFoundException;

import java.util.*;
public class MainRunner {
    public static void main(String[] args) {
        Catalog catalog = new LibraryCatalog();
        Library library = new Library(catalog);

        
        catalog.addBook(new Book("Java Basics", "Aashish", "101"));
        catalog.addBook(new Book("Data Structures", "Ravi", "102"));
        catalog.addBook(new Book("OOP Concepts", "Neha", "103"));

        
        library.addMember(new Member("Aashish", "M01"));
        library.addMember(new Member("Neha", "M02"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1: Borrow | 2: Return | 3: List Books | 4: Exit");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter Member ID: ");
                        String mid1 = sc.nextLine();
                        System.out.print("Enter Book ISBN: ");
                        String isbn1 = sc.nextLine();
                        library.borrowBook(library.getMember(mid1), isbn1);
                        break;

                    case "2":
                        System.out.print("Enter Member ID: ");
                        String mid2 = sc.nextLine();
                        System.out.print("Enter Book ISBN: ");
                        String isbn2 = sc.nextLine();
                        library.returnBook(library.getMember(mid2), isbn2);
                        break;

                    case "3":
                        library.listAllBooks();
                        break;

                    case "4":
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Enter 1, 2, 3 or 4.");
                }
            } catch (MemberNotFoundException | BookNotFoundException |
                     BookAlreadyBorrowedException | BookNotBorrowedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
