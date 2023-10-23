package functions.other;

import java.util.*;

public class ComparatorLambda {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Paul");
        names.add("Michael");
        names.add("Sam");
        names.add("Ed");
        names.add("Alexander");

        System.out.println("Before sorting alphabetically:");
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println();

        System.out.println("\nAfter sorting alphabetically:");
        Collections.sort(names);
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println("\nAfter sorting alphabetically by a lambda expression:");
        Comparator<String> comparator1 = Comparator.naturalOrder();
        names.sort(comparator1.reversed());
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println("\nAfter sorting by length:");
        Comparator<String> comparator2 = Comparator.comparingInt(String::length);
        names.sort(comparator2);
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println("\nAfter sorting by number of 'e's");
        Comparator<String> comparator3 = (name1, name2) -> {
            int count1 = 0;
            for (int i = 0; i < name1.length(); i++) {
                char c = name1.charAt(i);
                if (c == 'e') {
                    count1++;
                }
            }

            int count2 = 0;
            for (int i = 0; i < name2.length(); i++) {
                char c = name2.charAt(i);
                if (c == 'e') {
                    count2++;
                }
            }
            return count2 - count1;
        };

        names.sort(comparator3);
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println("\nNow sort it in reverse order!");
        names = new ArrayList<>();
        names.add("Paul");
        names.add("Michael");
        names.add("Sam");
        names.add("Ed");
        names.add("Alexander");

        names.sort(comparator1.reversed());
        for (String s : names) {
            System.out.println(s);
        }
    }
}
