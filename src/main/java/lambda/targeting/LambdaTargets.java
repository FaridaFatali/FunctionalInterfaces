package lambda.targeting;

import java.util.Comparator;

public class LambdaTargets {
    public static void main(String[] args) {
        Comparator<String> c = String::compareToIgnoreCase;

        compareStrings(c, "Java", "java");

        compareStrings(String::compareToIgnoreCase, "Java", "java");

        Runnable r = toDoLater();
        r.run();
    }

    public static void compareStrings(Comparator<String> comparator, String s1, String s2) {
        System.out.println(comparator.compare(s1, s2));
    }

    public static Runnable toDoLater() {
        return () -> System.out.println("Later");
    }
}
