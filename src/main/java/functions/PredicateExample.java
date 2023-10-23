package functions;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
//        predicateExample();
        biPredicateExample();
    }

    public static void predicateExample() {
        Predicate<String> stringLen = s -> s.length() < 10;

        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");
        System.out.println("Is ApplesInTheBag less than 10: " + stringLen.test("ApplesInTheBag"));

        Predicate<Integer> isEven1 = t -> {
            if (t % 2 == 0) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println("is 6 even? - " + isEven1.test(6));

        // Or just in this way
        Predicate<Integer> isEven2 = t -> t % 2 == 0;
        System.out.println("is 6 even? - " + isEven2.test(6));
    }

    public static void biPredicateExample() {
        BiPredicate<String, String> isLonger = (s1, s2) -> s1.length() >= s2.length();
        System.out.println("Is \"I love Java!\" longer than \"I love Python!\" ? - " + isLonger.test("I love Java!", "I love Python!"));

        BiPredicate<String, Integer> longerThanPredicate = (s, i) -> s.length() > i;
        System.out.println(longerThanPredicate.test("I love Java programming language", 30));

        BiPredicate<String, Integer> shorterThanPredicate = (s, i) -> s.length() < i;
        System.out.println(shorterThanPredicate.test("I love Java programming language", 40));

    }
}

