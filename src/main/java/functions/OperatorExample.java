package functions;

import java.util.Comparator;
import java.util.function.*;

public class OperatorExample {
    public static void main(String[] args) {
        unaryOperatorExample();
        System.out.println();
        binaryOperatorExample();
    }

    public static void unaryOperatorExample() {
        Function<Integer, Integer> squareFunction = num -> num * num;
        System.out.println("Result of Function<Integer, Integer> : " + squareFunction.apply(3));

        UnaryOperator<Integer> squareOperator = num -> num * num;
        System.out.println("Result of UnaryOperator<Integer> : " + squareOperator.apply(3));

        System.out.println();

        Function<Double, Double> squaredFunction = num -> Math.sqrt(num);
        System.out.println("Result of Function<Double, Double> : " + squaredFunction.apply(5.0));

        UnaryOperator<Double> squaredOperator = num -> Math.sqrt(num);
        System.out.println("Result of UnaryOperator<Double> : " + squaredOperator.apply(5.0));

        System.out.println();

        UnaryOperator<String> str = msg -> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case."));

        System.out.println();

        UnaryOperator<Integer> identityOperator = UnaryOperator.identity();
        int result = identityOperator.apply(10);
        System.out.println("Result of UnaryOperator<Integer> : " + result);
    }

    public static void binaryOperatorExample() {
        BinaryOperator<String> concat = (s1, s2) -> s1 + s2;
        System.out.println("Result of BinaryOperator<String> : " + concat.apply("I love these ", "built-in functions in Java!"));

        System.out.println();

        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Result of BinaryOperator<Integer> : " + add.apply(10, 25));

        System.out.println();

        Comparator<Integer> comparator = (i1, i2) -> i1 - i2;

        BinaryOperator<Integer> maxOperator = BinaryOperator.maxBy(comparator);
        BinaryOperator<Integer> minOperator = BinaryOperator.minBy(comparator);

        System.out.println("Max: " + maxOperator.apply(32, 23));
        System.out.println("Min: " + minOperator.apply(32, 23));
        System.out.println("Max or Min? - " + maxOperator.apply(23, 23));
    }
}
