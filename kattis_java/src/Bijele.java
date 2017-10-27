import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bijele {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in));
        String[] input =
                reader
                    .readLine()
                        .split(" ");
        int[] correctSet = {1, 1, 2, 2, 2, 8};
        int[] result = new int[correctSet.length];
        for (int i = 0; i < input.length; i++) {
            int r = correctSet[i]
                    - Integer.parseInt(input[i]);
            result[i] = r;
        }

        for (int r : result)
            System.out.print(r + " ");
    }
}
