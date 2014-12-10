/**
 * Created by martinpettersson on 10/12/14.
 */
public class Ladder {
    Kattio io = new Kattio(System.in);
    private static double h, v;

    public static void main(String[] args) {
        new Ladder();
    }

    public Ladder() {
        // Read input according to problem specification
        handleInput();
        // Give us the answer using some neat trigonometry
        System.out.println(ladderLength(h, v));
        // Flush input
        io.flush();
    }

    int ladderLength(double h, double v) {
        v = Math.toRadians(v);
        int ladderLength = (int) Math.ceil(
            h / Math.sin(v)
        );
        return ladderLength;
    }

    void handleInput() {
        // Wall height input
        h = io.getDouble();
        // Angle input
        v = io.getDouble();
    }
}


