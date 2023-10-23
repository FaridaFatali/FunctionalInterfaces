package functions.composition;

public class Compose {
    public interface Fun<A, B> {
        B call(A x);
    }

    public static <A, B, C> Fun<A, C> compose(final Fun<B, C> f, final Fun<A, B> g) {
        return new Fun<A, C>() {
            public C call(A x) {
                return f.call(g.call(x));
            }
        };
    }

    public static void main(String[] args) {
        Fun<Double, Double> sin = new Fun<Double, Double>() {
            @Override
            public Double call(Double x) {
                return Math.sin(x);
            }
        };

        // With Lambda:
//        Fun<Double, Double> sin = x -> Math.sin(x);

        // With method reference
//        Fun<Double, Double> sin = Math::sin;


        Fun<Double, Double> asin = new Fun<Double, Double>() {
            @Override
            public Double call(Double x) {
                return Math.asin(x);
            }
        };

        Fun<Double, Double> sin1 = (Double degree) -> Math.sin(degree);
        Fun<Double, Double> asin1 = (Double degree) -> Math.asin(degree);

        Fun<Double, Double> sinAsin1 = compose(sin, asin);
        Fun<Double, Double> sinAsin2 = compose(sin1, asin);

        System.out.println(sinAsin1.call(0.5));
        System.out.println(sinAsin2.call(0.5));
    }
}
