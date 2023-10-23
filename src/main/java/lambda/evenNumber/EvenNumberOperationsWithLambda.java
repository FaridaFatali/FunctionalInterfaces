package lambda.evenNumber;

public class EvenNumberOperationsWithLambda {
    private static int total;
    private static int product = 1;
    private static int[] squares = new int[5];

    public static void main(String[] args) {
        EvenNumberOperation printer = (i) -> System.out.println("i: " + i);
        pickEvenNumber(10, printer);

        pickEvenNumber(10, i -> total += i);
        System.out.println("\nSum: " + total);

        pickEvenNumber(10, i -> product *= i);
        System.out.println("\nProduct: " + product);

        pickEvenNumber(10, (i) -> squares[i / 2 - 1] = i * i);
        System.out.println("\nSquares:");
        for (int i : squares) {
            System.out.println("i: " + i);
        }
    }

    public static void pickEvenNumber(int n, EvenNumberOperation operation) {
        for (int i = 2; i <= n; i += 2) {
            operation.operate(i);
        }
    }
}
