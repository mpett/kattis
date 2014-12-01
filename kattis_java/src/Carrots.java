/**
 * Solution for Kattis problem-id: carrots
 * https://open.kattis.com/problems/carrots
 *
 * Author: Martin Pettersson
 */
public class Carrots {
    Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        new Carrots();
    }

    public Carrots() {
        int numberOfCarrots = handleInput();
        System.out.println(numberOfCarrots);
        io.close();
    }

    int handleInput() {
        io.getInt();
        return io.getInt();
    }
}
