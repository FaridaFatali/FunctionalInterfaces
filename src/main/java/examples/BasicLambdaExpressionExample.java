package examples;

public class BasicLambdaExpressionExample {
    public static void main(String[] args) {
        AnInterface1 anInterface1 = () -> System.out.println("Hello");
        anInterface1.aMethod();

        AnInterface2 anInterface2 = (x) -> System.out.println("\nx: " + x);
        anInterface2.aMethod(5);

        AnInterface3 anInterface3 = (x, y) -> System.out.println("\nx: " + x + ", y: " + y);
        anInterface3.aMethod(4, 6);

        AnInterface4 anInterface4 = (x, y) -> {
            System.out.println("\nAdding: " + x + " and " + y);
            return x + y;
        };
        System.out.println(anInterface4.aMethod(5, 7));

        method1(anInterface4);

        SquaredI squaredI = Math::sqrt;
        System.out.println(squaredI.squared(64));

        AnInterface5<Integer, String, Double> anInterface5 = (u, t) -> (double) t.length();
        double result = anInterface5.aMethod(44, "Hello, World.");
        System.out.println("\nResult: " + result);
    }

    public static void method1(AnInterface4 anInterface4) {
        anInterface4.aMethod(4, 6);
    }
}

interface AnInterface1 {
    void aMethod();
}

interface AnInterface2 {
    void aMethod(int x);
}

interface AnInterface3 {
    void aMethod(int x, int y);
}

interface AnInterface4 {
    int aMethod(int x, int y);
}

interface AnInterface5<U, T, V> {
    V aMethod(U u, T t);
}

interface SquaredI {
    double squared(double arg);
}