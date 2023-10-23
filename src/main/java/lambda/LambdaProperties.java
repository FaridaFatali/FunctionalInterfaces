package lambda;

public class LambdaProperties {
    public static void main(String[] args) {
        LambdaProperties lp = new LambdaProperties();
        lp.start();

        PropertyInterface adder2 = (i, j) -> {
            PropertyInterface.sMethod();
            return i + j;
        };
    }

    public void start() {
        PropertyInterface adder1 = (i, j) -> i + j;
        System.out.println("\nAdding: " + adder1.doIt(6, 8));

        System.out.println("\nPrinting aProperty variable in PropertyInterface: " + PropertyInterface.aProperty);
        System.out.println("\nPrinting adder1.aProperty" + adder1.aProperty);

        System.out.println("\nPrinting default dMethod() in PropertyInterface:");
        adder1.dMethod();

        // We can't call static sMethod() throw adder1 reference in lambda expression
        // We only can call it throw the interface
        System.out.println("\nPrinting static sMethod() throw the interface:");
        PropertyInterface.sMethod();

        aMethod(adder1, 8, 9);
        System.out.println();

        PropertyInterface adder2 = (i, j) -> {
            PropertyInterface.sMethod();
            adder1.dMethod();
            return i + j;
        };
        System.out.println("\nAdding: " + adder2.doIt(5, 8));

        System.out.println();

        SubPropertyInterface multiplier = (i, j) -> i * j;
        System.out.println("\nMultiplying by SubPropertyInterface: " + multiplier.doIt(5, 8));

        PropertyInterface multiplier2 = multiplier;
        System.out.println("\nMultiplying by PropertyInterface: " + multiplier2.doIt(6, 7));

        System.out.println("\naProperty variable throw SubPI: " + SubPropertyInterface.aProperty);
        System.out.println("\naSubProperty variable throw SubPI: " + SubPropertyInterface.aSubProperty);
        System.out.println("\naProperty variable throw multiplier: " + multiplier.aProperty);
        System.out.println("\naSubProperty variable throw multiplier: " + multiplier.aSubProperty);

        System.out.println("\ndMethod() throw multiplier:");
        multiplier.dMethod();

        System.out.println("\nsubDMethod() throw multiplier: ");
        multiplier.subDMethod();

        System.out.println("\nsubSMethod() throw the interface:");
        SubPropertyInterface.subSMethod();

        System.out.println("\nCalling aMethod()");
        aMethod(multiplier, 4, 8);

        System.out.println();

        PropertyInterface lambdaExpression = adder2;
        lambdaExpression = multiplier;
        System.out.println(lambdaExpression.doIt(5, 7));

        SubPropertyInterface adder3 = (i, j) -> i + j;
        PropertyInterface lambdaExpression2 = adder3;
        System.out.println(lambdaExpression2.doIt(4, 7));
    }

    public static void aMethod(PropertyInterface pi, int i, int j) {
        System.out.println("in sMethod(): " + pi.doIt(i, j));
    }
}

@FunctionalInterface
interface PropertyInterface {
    int aProperty = 1;

    int doIt(int i, int j);

    static void sMethod() {
        System.out.println("in sMethod()");
    }

    default void dMethod() {
        System.out.println("in dMethod()");
    }
}

@FunctionalInterface
interface SubPropertyInterface extends PropertyInterface {
    int aSubProperty = 10;

    // We can't declare a new abstract method here, because it exists in its parent interface

    static void subSMethod() {
        System.out.println("in subSMethod()");
    }

    default void subDMethod() {
        System.out.println("in subDMethod()");
    }
}
