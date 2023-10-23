package functions.composition;

import java.util.function.*;

public class PredicateCompositionExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = t -> t % 2 == 0;
        System.out.println("Is 6 even? - " + isEven.test(6));

        Predicate<Integer> isEvenNot = Predicate.not(isEven);
        System.out.println("Is 6 not even? - " + isEvenNot.test(6));

        Predicate<Integer> isPositive = t -> t > 0;
        System.out.println("Is 7 positive? - " + isPositive.test(7));

        Predicate<Integer> isBothEvenAndPositive = isEven.and(isPositive);
        System.out.println("Is -70 both even and positive? - " + isBothEvenAndPositive.test(-70));

        Predicate<Integer> isEvenOrPositive = isEven.or(isPositive);
        System.out.println("Is -70 even or positive? - " + isEvenOrPositive.test(-70));

        BiPredicate<String, Integer> longerThanPredicate = (s, i) -> s.length() > i;
        System.out.println("\nIs longer? - " + longerThanPredicate.test("Incomprehensibility", 20));

        BiPredicate<String, Integer> longerThanPredicateNegated = longerThanPredicate.negate();
        System.out.println("Is not longer? - " + longerThanPredicateNegated.test("Incomprehensibility", 20));

        BiPredicate<String, Integer> shorterThanPredicate = (s, i) -> s.length() < i;
        System.out.println("Is shorter? - " + shorterThanPredicate.test("Incomprehensibility", 20));

        BiPredicate<String, Integer> longerAndShorterThanPredicate = longerThanPredicate.and(shorterThanPredicate);
        System.out.println("Longer and shorter? - " + longerAndShorterThanPredicate.test("Incomprehensibility", 20));

        BiPredicate<String, Integer> longerOrShorterThanPredicate = longerThanPredicate.or(shorterThanPredicate);
        System.out.println("Longer or shorter? - " + longerOrShorterThanPredicate.test("Incomprehensibility", 20));


    }
}
