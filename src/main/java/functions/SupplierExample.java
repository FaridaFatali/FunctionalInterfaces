package functions;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> string = () -> "I love Java!";
        System.out.println(string.get());

        Supplier<Date> now = () -> new Date();
        System.out.println(now.get());
    }
}
