/**
 * Created by martinpettersson on 07/01/15.
 */
public class Tri {
    Kattio io = new Kattio(System.in);
    private int first, second, third;

    public static void main(String[] args) {
        new Tri();
    }

    public Tri() {
        handleInput();
        if (leftHandSide()) {
            io.close();
            System.exit(0);
        }
        rightHandSide();
        io.close();
    }

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

    void handleInput() {
        first = io.getInt(); second = io.getInt(); third = io.getInt();
    }
}
