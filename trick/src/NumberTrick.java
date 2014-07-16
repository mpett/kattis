/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-07-16
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.lang.StringBuilder;
public class NumberTrick {
    Kattio io = new Kattio(System.in, System.out);
    static double X;
    final static int TIME_LIMIT = 555555555;

    public static void main(String[] args) {
        new NumberTrick();
    }

    public NumberTrick() {
        handleInput();
        findAllTrickNumbers();
        io.flush();
    }

    void findAllTrickNumbers() {
        int breakPoint = 100000000;
        long startTime = System.nanoTime();
        boolean solutionFound = false;

        if(X==1)
            System.out.println(1);
        for(int number = 10; number < breakPoint; number++) {

            if(System.nanoTime() - startTime > TIME_LIMIT) {
                if (!solutionFound)
                    System.out.println("No solution");
                break;
            }
            double product = (X * (double) number);
            if (!(product == Math.floor(product)) && !Double.isInfinite(product))
                continue;
            String mutable = String.valueOf(number);
            String productS = String.valueOf((int) product);
            if ((productS.charAt(0) != mutable.charAt(1)) || (productS.length() != mutable.length()))
                continue;
            char firstDigit = mutable.charAt(0);
            StringBuilder builder = new StringBuilder(mutable);
            builder.append(firstDigit);
            mutable = builder.substring(1);
            if (mutable.equals(productS)) {
                solutionFound = true;
                System.out.println(number);
            }
        }
    }

    void handleInput() {

        X = io.getDouble();
    }
}
