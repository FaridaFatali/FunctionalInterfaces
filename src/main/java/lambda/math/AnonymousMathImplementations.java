package lambda.math;

public class AnonymousMathImplementations {
    public static void main(String[] args) {
        Math adder = new Math() {
            @Override
            public double calculate(double arg1, double arg2) {
                return arg1 + arg2;
            }
        };
        doMath(adder, 33, 3);

        doMath(new Math() {
            @Override
            public double calculate(double arg1, double arg2) {
                return arg1 * arg2;
            }
        }, 33, 3);

        doMath(new Math() {
            @Override
            public double calculate(double arg1, double arg2) {
                return arg1 - arg2;
            }
        }, 33, 3);

        doMath(new Math() {
            @Override
            public double calculate(double arg1, double arg2) {
                return arg1 / arg2;
            }
        }, 33, 3);
    }

    public static void doMath(Math math, double arg1, double arg2) {
        System.out.println(math.calculate(arg1, arg2));
    }
}
