import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R2 {
    public static void main(String[] args)
            throws IOException {
        determineR2();
    }

    private static void determineR2()
            throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in));
        String[] input = reader
                .readLine()
                .split(" ");
        int R1 = Integer
                .parseInt(input[0]);
        int S = Integer
                .parseInt(input[1]);
        int R2 = 2*S - R1;
        System.out.println(R2);
    }
}
