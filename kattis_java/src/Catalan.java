import java.math.BigInteger;
import java.util.Random;

/**
 * Created by martinpettersson on 29/12/14.
 */
public class Catalan {
    Kattio io = new Kattio(System.in, System.out);
    final static BigInteger ONE = BigInteger.ONE;

    public static void main(String[] args) {
        new Catalan();
    }

    public Catalan() {
        int q = io.getInt();
       // generateTestData();
        for (int number = 0; number < q; number++) {
            int x = handleInput();
            io.print(catalanNumber(x) + "\n");
        }
        io.close();
    }

    BigInteger catalanNumber(int x) {
        BigInteger cx = bigFactorial(2 * x).divide(bigFactorial(x + 1).multiply(bigFactorial(x)));
        return cx;
    }

    BigInteger bigFactorial(int n) {
        BigInteger inc = ONE; BigInteger fact = ONE;
        for (int c = 1; c <= n; c++) {
            fact = fact.multiply(inc);
            inc = inc.add(ONE);
        }
        return fact;
    }

    // delete me!
    void generateTestData() {
        Random r =  new Random();
        for (int i = 0; i < 1000; i++) {
            System.err.println(r.nextInt(4999));
        }
    }

    int handleInput() {
        int inputNumber = io.getInt();
        return inputNumber;
    }
}
