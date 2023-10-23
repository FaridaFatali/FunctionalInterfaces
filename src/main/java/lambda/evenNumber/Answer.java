package lambda.evenNumber;

public class Answer {
    int sum = 0;
    int product = 1;
    int[] squared = new int[5];

    public static void main(String[] args) {
        System.out.println("Numbers:");
        doIt(10, System.out::println);

        Answer answer = new Answer();

        doIt(10, (int k) -> answer.sum += k);
        System.out.println("\nSum: " + answer.sum);

        doIt(10, (int k) -> answer.product *= k);
        System.out.println("\nProduct: " + answer.product);

        doIt(10, (int k) -> answer.squared[k / 2 - 1] = k * k);
        System.out.print("\nSquares: [");
        for (int i : answer.squared) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public static void doIt(int n, EvenNumberOperation operation) {
        for (int i = 2; i <= n; i += 2) {
            operation.operate(i);
        }
    }
}
