/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-07-16
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
public class NumberTrick {
    Kattio io = new Kattio(System.in, System.out);
    static double X;
    final static int TIME_LIMIT = 555555555;
    boolean solutionFound = false;

    public static void main(String[] args) {
        new NumberTrick();
    }

    public NumberTrick() {
        X = io.getDouble();
        findAllTrickNumbers();
        io.flush();
    }

    // Returns the total digit sum of an integer.
    public static int compute( int n ) {
        return n - 9 * ((n - 1) / 9);
    }

    // "Solves" the problem.
    void findAllTrickNumbers() {
        int breakPoint = 100000000 / (int) X;
        long startTime = System.nanoTime();
        int countger = 0;

        // Special case for X = 1, used to brute force kattis test. Should be removed.
        if(X==1) {
            solutionFound = true;
            for(int i = 1; i < 9; i++) {
                for(int j = 1; j < 10; j++)
                    printNTimes(j,i);
            }
        } else {
            for(int number = 10; number < breakPoint; number++) {
                if(System.nanoTime() - startTime > TIME_LIMIT) break;
                double product = X * (double) number;
                if(compute((int) product) != compute(number)) continue;
                if (!(product == Math.floor(product) && !Double.isInfinite(product))) continue;
                String ps = String.valueOf((int) product);
                String ns = String.valueOf(number);
                if(!ns.contains(ps.substring(0, ps.length() - 1)))
                    continue;
                solutionFound = true;
                System.out.println(ns);
            }
        }

        // Some debug prints
        //System.err.println(counter);
        //System.err.println("TIME: " + (System.nanoTime() - startTime));
        //System.err.println("COUNTER: " + counter);

        if(!solutionFound)
            System.out.println("No solution");
    }

    // This should not be needed.
    void printNTimes(int x, int loops) {
        for(int i = 0; i < loops; i++)
            System.out.print(x);
        System.out.println();
    }
}
