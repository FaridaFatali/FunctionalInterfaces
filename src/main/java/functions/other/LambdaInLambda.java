package functions.other;

import java.util.*;
import java.util.function.*;

public class LambdaInLambda {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Joseph");
        names.add("Angelina");
        names.add("Donald");
        names.add("Steven");
        names.add("Josephina");
        names.add("Georgina");
        names.add("Jennifer");
        names.add("Michael");

        System.out.println("\nAfter sorting alphabetically by a lambda expression:");
        Comparator<String> comparator1 = Comparator.naturalOrder();
        names.sort(comparator1);
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println("\nAfter sorting alphabetically in lower case by a lambda expression:");
        Comparator<String> comparator2 = (s1, s2) -> {
            UnaryOperator<String> converter = String::toLowerCase;
            s1 = converter.apply(s1);
            s2 = converter.apply(s2);
            return s1.compareTo(s2);
        };
        names.sort(comparator2);
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println("\nAfter sorting in terms of their lengths by a lambda expression:");
        Comparator<String> comparator3 = (s1, s2) -> {
            Function<String, Integer> lengthMeasurer = String::length;
            int i1 = lengthMeasurer.apply(s1);
            int i2 = lengthMeasurer.apply(s2);
            return i1- i2;
        };
        names.sort(comparator3);
        for (String s : names) {
            System.out.println(s);
        }
    }
}
