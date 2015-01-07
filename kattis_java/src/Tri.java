/**
 * Solution for Kattis problem-id: tri
 * https://open.kattis.com/problems/tri
 *
 * Author: Martin Pettersson
 */
public class Tri {
    Kattio io = new Kattio(System.in);
    private int first, second, third;

    public static void main(String[] args) {
        new Tri();
    }

    public Tri() {
        handleInput();
        // Just end the show if we found the solution.
        if (leftHandSide()) {
            io.close();
            System.exit(0);
        }
        rightHandSide();
        io.close();
    }

    /**
     * Check left hand side.
     * @return
     */
    boolean leftHandSide() {
        if (first == (second + third))
            System.out.println(first + "=" + second + "+" + third);
        else if (first == (second - third))
            System.out.println(first + "=" + second + "-" + third);
        else if (first == (second * third))
            System.out.println(first + "=" + second + "*" + third);
        else if (first == (second / third))
            System.out.println(first + "=" + second + "/" + third);
        else return false;
        return true;
    }

    /**
     * Check right hand side.
     */
    void rightHandSide() {
        if ((first + second) == third)
            System.out.println(first + "+" + second + "=" + third);
        else if ((first - second) == third)
            System.out.println(first + "-" + second + "=" + third);
        else if ((first * second) == third)
            System.out.println(first + "*" + second + "=" + third);
        else
            System.out.println(first + "/" + second + "=" + third);
    }

    /**
     * Handle input according to spec.
     */
    void handleInput() {
        first = io.getInt(); second = io.getInt(); third = io.getInt();
    }
}
