import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by martinpettersson on 27/05/15.
 */
public class SimonSays {
    private int T; Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        new SimonSays();
    }

    public SimonSays() {
        T = io.getInt();
        try {
            Scanner stdin = new Scanner(new BufferedInputStream(System.in));
            while (stdin.hasNext()){
                System.err.println(stdin.next());
            }
            io.close(); stdin.close();
        } catch (Exception e) {
            System.err.println("omg");
        }
    }
}
