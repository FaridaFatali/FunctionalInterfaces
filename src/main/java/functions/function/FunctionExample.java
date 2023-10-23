package functions.function;

import domain.*;
import java.util.List;
import java.util.function.*;

public class FunctionExample {
    public static void main(String[] args) {
//        functionExample();
        identityExample();
    }

    public static void functionExample() {
        Function<Integer, String> converter = num -> Integer.toString(num);
        System.out.println("Length of 123456789: " + converter.apply(123456789).length());

        System.out.println();

        Function<Integer, Integer> square = num -> num * num;
        System.out.println("Square of the number: " + square.apply(5));

        System.out.println();

        Function<Integer, Double> squared = num -> Math.sqrt(num);
        System.out.println("22 squared: " + squared.apply(22));

        System.out.println();

        Function<Integer, Boolean> isEven = num -> num % 2 == 0;
        System.out.println("isEven result: " + isEven.apply(5));
        System.out.println("isEven result: " + isEven.apply(6));

        // Would be better to write it with Predicate
        System.out.println();
        Predicate<Integer> isEvenPredicate = num -> num % 2 == 0;
        System.out.println("isEvenPredicate result: " + isEvenPredicate.test(5));
        System.out.println("isEvenPredicate result: " + isEvenPredicate.test(6));

        System.out.println();

        Function<Integer[], Integer> arrayLengthMeasurer = array -> array.length;
        System.out.println("Length of array: " + arrayLengthMeasurer.apply(new Integer[]{23, 74, 836, 43}));

        Function<Integer[], String[]> intStringConverter = array -> {
            int length = array.length;
            String[] strings = new String[length];

            for (int i = 0; i < length; i++) {
                String s = array[i].toString();
                int diff = 10 - s.length();

                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        s = "0".concat(s);
                    }
                }
                strings[i] = s;
            }
            return strings;
        };

        System.out.println();

        String[] strings = intStringConverter.apply(new Integer[]{474, 7328, 94, 37792});
        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println();

        Function<List<Book>, Integer[]> bookPageCountConverter = books -> {
            int size = books.size();
            Integer[] pages = new Integer[size];

            for (int i = 0; i < size; i++) {
                pages[i] = books.get(i).getPages();
            }
            return pages;
        };

        List<Book> bookList = BookFactory.getBookList();
        Integer[] pages = bookPageCountConverter.apply(bookList);
        System.out.println("\nNumber of pages:");
        for (int page : pages) {
            System.out.println(page);
        }
    }

    public static void identityExample() {
        Function<Book, Book> identityLambdaExpression = Function.identity();

        Book book = new Book("The Cat in the Hat", "Dr.", "Seuss", 450);
        Book aNewBook = identityLambdaExpression.apply(book);
        System.out.println(book);
        System.out.println(aNewBook);
        System.out.println(book == aNewBook);
    }
}
