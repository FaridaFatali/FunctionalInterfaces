package lambda.math;

public class LambdaMathImplementations {
    public static void main(String[] args) {
        // Using reference
        Math adder = (arg1, arg2) -> arg1 + arg2;
        doMath(adder, 85, 33);

        // With method reference
//        Math adder = Double::sum;
//        doMath(adder, 85, 33);

        Math multiplier = (arg1, arg2) -> arg1 * arg2;
        doMath(multiplier, 85, 33);

        Math subtracter = (arg1, arg2) -> arg1 - arg2;
        doMath(subtracter, 85, 33);

        Math divider = (arg1, arg2) -> arg1 / arg2;
        doMath(divider, 85, 33);

        System.out.println("----------------------------");

        // We can write the same code without reference, without types and return keyword
        doMath(Double::sum, 85, 33);
        doMath((arg1, arg2) -> arg1 * arg2, 85, 33);
        doMath((arg1, arg2) -> arg1 - arg2, 85, 33);
        doMath((arg1, arg2) -> arg1 / arg2, 85, 33);


        // We can use all of these variations, but the 3rd is the most optimal variation
//        doMath((double arg1, double arg2) -> { return arg1 + arg2;}, 85, 33);
//        doMath((arg1, arg2) -> { return arg1 + arg2;}, 85, 33);
//        doMath((arg1, arg2) -> arg1 + arg2, 85, 33);

        System.out.println("----------------------------");

        Math mod = (a, b) -> a % b;
        doMath(mod, 85, 33);

        System.out.println("----------------------------");

//        Math power = (a, b) -> java.lang.Math.pow(a, b);
        Math power = java.lang.Math::pow;
        System.out.println(power.calculate(8, 3));

        // Or just
        doMath(power, 8, 3);
    }

    public static void doMath(Math math, double arg1, double arg2) {
        double outcome = math.calculate(arg1, arg2);
        System.out.println(outcome);
    }
}
