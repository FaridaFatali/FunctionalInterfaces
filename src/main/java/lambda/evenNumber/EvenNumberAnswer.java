package lambda.evenNumber;

import java.util.function.IntConsumer;

public class EvenNumberAnswer {
    private int sum = 0;
    private int product = 1;
    private int[] squared = new int[5];

    public static void main(String[] args) {
        EvenNumberAnswer ena = new EvenNumberAnswer();

        EvenNumberOperation operation;
        IntConsumer consumer;

        System.out.println("With EventNumberOperation:");
        operation = i -> System.out.println("i: " + i);
        ena.doEvenNumberOperation(operation, 10);
        System.out.println();

        System.out.println("With IntConsumer:");
        consumer = i -> System.out.println("i: " + i);
        ena.doEvenNumberOperation(consumer, 10);

        operation = i -> ena.sum += i;
        ena.doEvenNumberOperation(operation, 10);
        System.out.println("\nSum with operation: " + ena.sum);

        ena.sum = 0;
        consumer = i -> ena.sum += i;
        ena.doEvenNumberOperation(consumer, 10);
        System.out.println("Sum with consumer: " + ena.sum);

        operation = i -> ena.product *= i;
        ena.doEvenNumberOperation(operation, 10);
        System.out.println("\nProduct with operation: " + ena.product);

        ena.product = 1;
        consumer = i -> ena.product *= i;
        ena.doEvenNumberOperation(consumer, 10);
        System.out.println("Product with consumer: " + ena.product);

        System.out.println("\nj with operation:");
        operation = i -> ena.squared[i / 2 - 1] = i * i;
        ena.doEvenNumberOperation(operation, 10);
        for (int j : ena.squared) {
            System.out.println(j);
        }

        System.out.println("\nj with consumer:");
        consumer = i -> ena.squared[i / 2 - 1] = i * i;
        ena.doEvenNumberOperation(consumer, 10);
        for (int j : ena.squared) {
            System.out.println(j);
        }
    }

    public void doEvenNumberOperation(EvenNumberOperation operation, int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                operation.operate(i);
            }
        }
    }

    public void doEvenNumberOperation(IntConsumer operation, int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                operation.accept(i);
            }
        }
    }
}
