import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Faktor {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in));

        String[] input =
                reader.readLine()
                        .split(" ");

        int A = Integer.parseInt(input[0]);
        int I = Integer.parseInt(input[1]);
        int B = A * (I-1) + 1;

        System.out.println(B);
    }
}
