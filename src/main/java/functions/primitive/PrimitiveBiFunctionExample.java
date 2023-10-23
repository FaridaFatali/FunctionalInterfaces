package functions.primitive;

import java.util.function.*;

public class PrimitiveBiFunctionExample {
    public static void main(String[] args) {
        example();
    }

    public static void example() {
        ToIntBiFunction<String, String> toIntBiFunction = (s1, s2) -> s1.length() + s2.length();
        System.out.println(toIntBiFunction.applyAsInt("Hello", "World"));

        ToLongBiFunction<Integer, Integer> toLongBiFunction = (i1, i2) -> i1 * i2;
        System.out.println(toLongBiFunction.applyAsLong(342434, 453));

        ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction = (i1, i2) -> 1.0d * i1 / i2;
        System.out.println(toDoubleBiFunction.applyAsDouble(10, 5));
    }
}
