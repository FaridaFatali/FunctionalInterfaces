package functions;

import java.util.function.*;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> lowerCaseConverter = s -> System.out.println(s.toLowerCase());
        lowerCaseConverter.accept("I LOve JAva progRAMming LAnguage");

        Consumer<Integer> apply = i -> System.out.println(i.equals(10));
        apply.accept(15);
        apply.accept(10);

        BiConsumer<String, String> concat = (s1, s2) -> System.out.println(s1 + s2);
        concat.accept("Functional ", "Interfaces");
    }
}
