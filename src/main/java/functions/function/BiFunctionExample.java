package functions.function;

import java.util.function.*;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Double> doubleConstructor = (num1, num2) -> Double.valueOf((num1 + "." + num2));
        System.out.println("Constructing a double using 3 and 134: " + doubleConstructor.apply(3, 134));
        System.out.println("Constructing a double using 0 and 55: " + doubleConstructor.apply(0, 55));

        System.out.println();

        BiFunction<Integer, Integer, String> concat = (num1, num2) -> num1 + Integer.toString(num2);
        System.out.println("215 and 65 are concat'd: " + concat.apply(125, 65));

        System.out.println();

        BiFunction<Integer, Integer, Boolean> isGreaterThan = (num1, num2) -> num1 > num2;
        System.out.println("Checking greatness: " + isGreaterThan.apply(37, 19));
        System.out.println("Checking greatness: " + isGreaterThan.apply(19, 37));

        System.out.println();

        BiFunction<Integer, Integer, Boolean> isEqual = (num1, num2) -> num1 == num2;
        System.out.println("Checking equality: " + isEqual.apply(5, 5));
        System.out.println("Checking equality: " + isEqual.apply(5, 3));

        System.out.println();

        // Would be better to use Predicate:
        BiPredicate<Integer, Integer> isGreaterThanPredicate = (num1, num2) -> num1 > num2;
        System.out.println("Checking greatness with predicate: " + isGreaterThanPredicate.test(37, 19));
        System.out.println("Checking greatness with predicate: " + isGreaterThanPredicate.test(19, 37));
        System.out.println();
        BiPredicate<Integer, Integer> isEqualPredicate = (num1, num2) -> num1 == num2;
        System.out.println("Checking equality with predicate: " + isEqualPredicate.test(5, 5));
        System.out.println("Checking equality with predicate: " + isEqualPredicate.test(5, 3));

        System.out.println();

        BiFunction<Integer, Integer, Integer> power = (num1, num2) -> (int) Math.pow(num1, num2);
        System.out.println("7 ^ 3: " + power.apply(7, 3));

        System.out.println();

        BiFunction<Integer, Integer, Integer> max = (num1, num2) -> {
            if (num1 > num2) {
                return num1;
            } else {
                return num2;
            }
        };
        System.out.println("7 ? 3:  max value - " + max.apply(7, 3));

        System.out.println();

        BiFunction<String, String, Boolean> bf1 = (target, search) -> target.length() > search.length();
        String s1 = "I love Java";
        String s2 = "I love Python";
        System.out.println("Is \"" + s1 + "\" longer than \"" + s2 + "\"? " + bf1.apply(s1, s2));
    }
}
