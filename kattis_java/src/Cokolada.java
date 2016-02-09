/**
 * Created by martinpettersson on 28/01/16.
 */
public class Cokolada {
    private static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int K = io.getInt();
        int smallestBarSize = (int) Math.pow(2.0, log(K,2));
        System.out.println(smallestBarSize + " " + numberOfBreaks(smallestBarSize, K));
        io.close();
    }

    private static int numberOfBreaks(int cookieSize, int K) {
        int numberOfBreaks = 0;
        int tmp = 0;
        while (true) {
            if (tmp > K) {
                tmp -= cookieSize;
                cookieSize /= 2;
                numberOfBreaks++;
                continue;
            }
            if (tmp == K)
                return numberOfBreaks;
            tmp += cookieSize;
        }
    }

    private static double log(int x, int base) {
        double log = (Math.log(x) / Math.log(base));
        return Math.ceil(log);
    }

}
