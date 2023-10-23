package lambda;

public class LambdaScope {
    private int i = 3;
    private String s = "Instance variable";
    private static boolean b = false;

    public static void main(String[] args) {
        int i = 5;
        String s = "In main() method";
        LambdaScope ls = new LambdaScope();

        // We can't change value of these local variables and reference, they must be final or effectively final

        ScopeInterface si1 = (ii, ss) -> {
            int m = 10;
            int k = m;

            // We can change value of the variables out of the scope if we use lambda expression
            k += i;    // Local i variable in main() method
            k += ls.i; // Instance i variable throw ls reference
            ls.i++;
            k += ii;

            k += s.length();       // s variable in main() method
            ls.s = "I love Java";  // s variable throw ls reference
            k += ls.s.length();
            k += ss.length();
            return k;
        };

        int outcome = si1.f(100, ":)");
        System.out.println(outcome);

        ScopeInterface si2 = (ii, ss) -> {
            int m = 10;  // This isn't shadowing, we declared it once again
            int k = m;

            ls.i++;
            ls.s = "A new value!";

            k += i;
            k += ls.i;
            ii++;
            k += ii;

            LambdaScope.b = true;

            k += s.length();
            k += ls.s.length();
            ss = "I love Java";
            k += ss.length();
            return k;
        };

        System.out.println(si2.m);

        ScopeInterface si3 = (ii, ss) -> {
            System.out.println("in si3: " + ii + " " + ss);
            return 5;
        };

        si3.f(si2.m, "Java");

        outcome = si2.f(100, ":)");
        System.out.println(outcome);

    }
}

@FunctionalInterface
interface ScopeInterface {
    int m = 1; // public static final

    int f(int i, String s);
}
