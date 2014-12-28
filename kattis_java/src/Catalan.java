import java.math.BigInteger;

/**
 * Created by martinpettersson on 29/12/14.
 */
public class Catalan {
    Kattio io = new Kattio(System.in);
    final static BigInteger ONE = BigInteger.ONE;

    public static void main(String[] args) {
        new Catalan();
    }

    public Catalan() {
        int q = io.getInt();
        for (int number = 0; number < q; number++) {
            int x = handleInput();
            System.out.println(catalanNumber(x));
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

    int handleInput() {
        int inputNumber = io.getInt();
        return inputNumber;
    }
}
