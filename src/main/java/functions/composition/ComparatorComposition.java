package functions.composition;

import domain.*;
import java.util.*;

public class ComparatorComposition {
    public static void main(String[] args) {
        List<Book> books = init();

        books.forEach(book -> System.out.println("Book list: \n" + book));

        System.out.println();

        System.out.println("\nAfter sorting alphabetically:");
        Collections.sort(books);
        books.forEach(System.out::println);

        System.out.println("\nAfter sorting alphabetically1:");
        Comparator<Book> compareByTitle = Comparator.comparing(Book::getTitle);
        books.sort(compareByTitle);
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nAfter sorting by author lastname:");
        Comparator<Book> compareByAuthorLastName = Comparator.comparing(Book::getAuthorLName);
        books.sort(compareByAuthorLastName);
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nAfter sorting by author lastname in reverse:");
        books.sort(compareByAuthorLastName.reversed());
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nAfter sorting by page count:");
        Comparator<Book> compareByPageCount = Comparator.comparingInt(Book::getPages);
        books.sort(compareByPageCount);
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nAfter sorting by first title and then by author lastname:");
        Comparator<Book> compareTitleAndThenByAuthorLastName = compareByTitle.thenComparing(compareByAuthorLastName);
        books.sort(compareTitleAndThenByAuthorLastName);
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nAfter sorting by the first title and then by author last name and then by page count:");
        Comparator<Book> compareTitleAndThenByAuthorLastNameAndThenByPageCount = compareByTitle.thenComparing(compareByAuthorLastName).thenComparing(compareByPageCount);
        books.sort(compareTitleAndThenByAuthorLastNameAndThenByPageCount);
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static List<Book> init() {
        return BookFactory.getBookList();
    }
}
