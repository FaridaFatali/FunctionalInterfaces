package functions.primitive;

import java.util.function.*;

public class PrimitiveFunctionExample {
    public static void main(String[] args) {
        example1();
        System.out.println("-----------");
        example2();
    }

    public static void example1() {
        IntFunction<Double> intFunction = i -> Math.sqrt(i);
        System.out.println(intFunction.apply(6));

        LongFunction<Double> longFunction = l -> 1d / l;
        System.out.println(longFunction.apply(6));

        DoubleFunction<String> doubleFunction = d -> String.valueOf(d);
        System.out.println(doubleFunction.apply(3.2324));
    }

    public static void example2() {
        IntToLongFunction intToLongFunction = i -> (long) i;
        System.out.println(intToLongFunction.applyAsLong(Integer.MAX_VALUE) + 1);

        IntToDoubleFunction intToDoubleFunction = i -> 1d / i;
        System.out.println(intToDoubleFunction.applyAsDouble(5));

        LongToIntFunction longToIntFunction = l -> (int) l;
        System.out.println(longToIntFunction.applyAsInt(2384774L));
    }
}
