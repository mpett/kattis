import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StuckInATimeLoop {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in));
        int N = Integer.parseInt(
                reader.readLine());
        for (int i = 1; i <= N; i++) {
            System.out.println
                    (i + " " + "Abracadabra");
        }

    }
}
