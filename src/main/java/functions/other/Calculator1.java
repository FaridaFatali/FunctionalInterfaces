package functions.other;

import java.util.function.BinaryOperator;

public class Calculator1 {
    private BinaryOperator<Double> adder = (arg1, arg2) -> arg1 + arg2;
    private BinaryOperator<Double> subtracter = (arg1, arg2) -> arg1 - arg2;
    private BinaryOperator<Double> multiplier = (arg1, arg2) -> arg1 * arg2;
    private BinaryOperator<Double> divider = (arg1, arg2) -> arg1 / arg2;

    public double add(double arg1, double arg2) {
        return adder.apply(arg1, arg2);
    }

    public double subtract(double arg1, double arg2) {
        return subtracter.apply(arg1, arg2);
    }

    public double multiply(double arg1, double arg2) {
        return multiplier.apply(arg1, arg2);
    }

    public double divide(double arg1, double arg2) {
        return divider.apply(arg1, arg2);
    }

    public static void main(String[] args) {
        Calculator1 calculator = new Calculator1();
        System.out.println(calculator.add(44, 55));
        System.out.println(calculator.subtract(44, 55));
        System.out.println(calculator.multiply(44, 55));
        System.out.println(calculator.divide(44, 55));
    }

}
