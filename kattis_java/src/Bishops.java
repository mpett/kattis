/**
 * Solution for Kattis problem-id: bishops
 * https://open.kattis.com/problems/bishops
 *
 * Author: Martin Pettersson
 */
public class Bishops {
    Kattio io = new Kattio(System.in);
    private static int N;

    public static void main(String[] args) {
        new Bishops();
    }

    // So Kattis classifies this as a hard problem. rly?
    public Bishops() {
        // Maximum number of bishops will be 2*N - 2 if N > 1.
        while (io.hasMoreTokens()) {
            handleInput();
            if (N==1)
                System.out.println(1);
            else if (N > 1)
                System.out.println(2*N-2);
            else
                System.out.println(0);
            // Flush input stream.
            io.flush();
        }
    }

    // Read input according to problem specification.
    void handleInput() {
        N = io.getInt();
    }
}
