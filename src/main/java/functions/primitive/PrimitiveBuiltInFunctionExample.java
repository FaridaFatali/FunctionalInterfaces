package functions.primitive;

import java.util.function.*;

public class PrimitiveBuiltInFunctionExample {
    public static void main(String[] args) {
        DoubleFunction<Integer> integerConverter = num -> (int) num;
        System.out.println(integerConverter.apply(Math.PI));

        ToDoubleFunction<Integer> doubleMaker = num -> (double) num;
        System.out.println(doubleMaker.applyAsDouble(10));

        IntConsumer le1 = i -> System.out.println(i);
        le1.accept(2222);

        DoublePredicate isPi = d -> d == Math.PI;
        System.out.println(isPi.test(Math.PI));
    }
}
