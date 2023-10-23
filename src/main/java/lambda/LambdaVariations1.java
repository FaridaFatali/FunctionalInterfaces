package lambda;

import java.util.Date;

public class LambdaVariations1 {
    public static void main(String[] args) {
        Interface1 le1 = () -> System.out.println("Hello");
        le1.f();
        Interface1 le2 = () -> { System.out.println("Hello in scope"); };
        le2.f();
        Interface1 le3 = () -> { return; };
        le3.f();
        Interface1 le4 = () -> { };
        le4.f();
        Interface1 le5 = () -> System.out.println(new Date());
        le5.f();

        System.out.println();

        Interface2 le6 = (int i) -> System.out.println("i: " + i);
        le6.f(44);
        Interface2 le7 = (i) -> System.out.println("i: " + i);
        le7.f(33);
        Interface2 le8 = i -> System.out.println("i: " + i);
        le8.f(66);
        Interface2 le9 = i -> System.out.println(Math.sqrt(i));
        le9.f(81);

        System.out.println();

        Interface3 le10 = () -> 33;
        System.out.println("le10: " + le10.f());
        Interface3 le11 = () -> 7 * 3;
        System.out.println("le11: " + le11.f());
        Interface3 le12 = () -> { return 4 * 6; };
        System.out.println("le12: " + le12.f());
        Interface3 le13 = () -> (int) Math.pow((100 % 3 + 100 % 9), 3) + 4;
        System.out.println("le13: " + le13.f());
        Interface3 le14 = () -> {
            double d = Math.pow((100 % 3 + 100 % 9), 3);
            int k = (int) d;
            k += 5;
            return k;
        };
        System.out.println("le14: " + le14.f());

        System.out.println();

        Interface4 le15 = (int i) -> i;
        System.out.println("le15: " + le15.f(23));
        Interface4 le16 = (i) -> i * i;
        System.out.println("le16: " + le16.f(34));
        Interface4 le17 = i -> i;
        System.out.println("le17: " + le17.f(45));
        Interface4 le18 = i -> (int) Math.pow((100 % 3 + 100 % 9), 3) + i;
        System.out.println("le18: " + le18.f(56));
        Interface4 le19 = i -> {
            double d = Math.pow((100 % 3 + 100 % 9), 3);
            int k = (int) d;
            k += i;
            return k;
        };
        System.out.println("le19: " + le19.f(67));

        Interface4 square = i -> i * i;
        System.out.println("Square: " + square.f(49));

        Interface4 remainderOfTwo = i -> i % 2;
        System.out.println("Remainder: " + remainderOfTwo.f(55));

        System.out.println();

        Interface5 le20 = (d1, d2) -> d1 % d2;
        System.out.println("le20: " + le20.f(323, 44));
    }
}

@FunctionalInterface
interface Interface1 {
    void f();
}

@FunctionalInterface
interface Interface2 {
    void f(int i);
}

@FunctionalInterface
interface Interface3 {
    int f();
}

@FunctionalInterface
interface Interface4 {
    int f(int i);
}

@FunctionalInterface
interface Interface5 {
    double f(double d1, double d2);
}