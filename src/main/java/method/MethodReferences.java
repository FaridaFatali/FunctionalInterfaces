package method;

import domain.Book;

import java.math.BigInteger;
import java.util.Date;
import java.util.function.*;

public class MethodReferences {
    public static void main(String[] args) {
        examples();
        System.out.println("----------------");
        limitations();
    }

    public static void examples() {
        Consumer<String> print1 = s1 -> System.out.println(s1);
        print1.accept("Printing print1 using lambda");

        Consumer<String> print2 = System.out::println;
        print2.accept("\nPrinting print2 using method reference");

        Supplier<Long> now = System::currentTimeMillis;
        System.out.println("\nPrinting date using method reference: " + new Date(now.get()));

        Function<Double, Double> twoSquared = Math::sqrt;
        System.out.println("\nPrinting sqrt using method reference");

        // Calling an instance method
        Book book1 = new Book("The Cat in the Hat", "Dr", "Seuss", 450);

        System.out.println("\nPrinting book info using lambda");
        Consumer<Book> bookConsumer1 = book -> book.printInfo();
        bookConsumer1.accept(book1);

        System.out.println("\nPrinting book info using method reference");
        Consumer<Book> bookConsumer2 = Book::printInfo;
        bookConsumer2.accept(book1);

        // Calling an instance method by passing argument
        System.out.println("\nPrinting book author first name using method reference");
        Consumer<String> bookConsumer3 = book1::setAuthorFName;
        bookConsumer3.accept("Jon");
        System.out.println(book1);

        UnaryOperator<String> greeting = x -> "Hello, ".concat(x);
        System.out.println("\nGreeting: " + greeting.apply("World"));

        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println("\nGreeting using method reference: " + makeGreeting.apply("Java"));

        // Calling a constructor
        Supplier<Date> dateSupplier1 = () -> new Date();
        System.out.println("\nGetting date using lambda: " + dateSupplier1.get());

        Supplier<Date> dateSupplier2 = Date::new;
        System.out.println("\nGetting date using method reference: " + dateSupplier2.get());

        Supplier<Book> bookSupplier1 = Book::new;
        System.out.println("\nGetting book info using method reference: " + bookSupplier1.get());

        IntFunction<String> intToString = num -> Integer.toString(num);
        System.out.println("\nLength of string 123 using lambda: " + intToString.apply(123).length());

        // Static method reference using ::
        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("\nLength of string 2322 using method reference: " + intToString2.apply(2322).length());

        // lambdas made using a constructor
        Function<String, BigInteger> newBigInt = BigInteger::new;
        System.out.println("\nA BigInteger object constructed using this string 123456789: " + newBigInt.apply("123456789"));

        BinaryOperator<String> binaryGreeting1 = (x, y) -> x.concat(y);
        System.out.println("\nConcat x and y using lambda: " + binaryGreeting1.apply("Hello ", "World"));

        BinaryOperator<String> binaryGreeting2 = String::concat;
        System.out.println("\nConcat x and y using method reference: " + binaryGreeting2.apply("Hello ", "World"));

        BiFunction<String, String, String> biFunctionGreeting = String::concat;
        System.out.println("\nConcat x and y by BiFunction: " + biFunctionGreeting.apply("Hello, ", "Java World"));
    }

    public static void limitations() {
        Function<Integer, A> aFunction = A::new;
        System.out.println("Printing aFunction: " + aFunction.apply(4).i);

        A a = new A(6);
        Consumer<Boolean> aConsumer1 = a::f1;
        aConsumer1.accept(true);

        // We can't write it because f2 has 2 parameters
//        Consumer<Boolean> aConsumer2 = a::f2;
//        aConsumer2.accept(true);

        Consumer<Boolean> aStaticConsumer1 = A::ff1;
        aStaticConsumer1.accept(true);

        // We can't write it because f22 has 2 parameters
//        Consumer<Boolean> aStaticConsumer2 = A::ff2;
//        aStaticConsumer2.accept(true);

        BiConsumer<Boolean, String> aStaticConsumer2 = A::ff2;
        aStaticConsumer2.accept(true, "Hello");
    }
}

class A {
    int i = 5;

    A(int i) {
        this.i = i;
    }

    public void f1(boolean b) {
    }

    public void f2(boolean b, String s) {
    }

    static void ff1(boolean b) {
    }

    static void ff2(boolean b, String s) {
    }
}