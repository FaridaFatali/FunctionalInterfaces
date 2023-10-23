package functions;

public class CommonFunctionalInterfaces {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        UniIntegerChecker isZero = i -> i == 0;
        System.out.println(isZero.method(5));

        UniIntegerChecker isOne = i -> i == 1;
        System.out.println(isOne.method(1));

        UniIntegerChecker isPositive = i -> i > 0;
        System.out.println(isPositive.method(6));

        UniIntegerChecker isNegative = i -> i < 0;
        System.out.println(isNegative.method(-4));

        UniIntegerChecker isGreaterThan = i -> i > 100;
        System.out.println(isGreaterThan.method(10));

        System.out.println();

        BiIntegerChecker isEqual = (i, j) -> i == j;
        System.out.println(isEqual.method(3, 6));

        BiIntegerChecker isNotEqual = (i, j) -> i != j;
        System.out.println(isNotEqual.method(4, 6));

        BiIntegerChecker isGreater = (i, j) -> i > j;
        System.out.println(isGreater.method(44, 74));

        BiIntegerChecker isLess = (i, j) -> i < j;
        System.out.println(isLess.method(33, 55));
    }
}

@FunctionalInterface
interface UniIntegerChecker {
    boolean method(int i);
}

@FunctionalInterface
interface BiIntegerChecker {
    boolean method(int i, int j);
}
