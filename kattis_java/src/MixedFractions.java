/**
 * Solution for Kattis problem-id: mixedfractions
 * https://open.kattis.com/problems/mixedfractions
 *
 * Author: Martin Pettersson
 */
public class MixedFractions {
    Kattio io = new Kattio(System.in, System.out);
    private int numerator, denominator;

    public static void main(String[] args) {
        new MixedFractions();
    }

    public MixedFractions() {
        boolean hasMoreTestCases = handleInput();
        int numInteger, remainder = 0;
        while (hasMoreTestCases) {
            remainder = numerator % denominator;
            numInteger = (numerator - remainder) / denominator;
            System.out.println(numInteger + " " + remainder + " / " + denominator);
            hasMoreTestCases = handleInput();
        }
        io.flush();
    }

    // Handles input according to problem specification.
    boolean handleInput() {
        numerator = io.getInt();
        denominator = io.getInt();
        if (numerator == 0 && denominator == 0)
            return false;
        return true;
    }
}
