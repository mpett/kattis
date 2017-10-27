import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String[] input =
                reader.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int Y = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);
        for (int i = 1; i <= N; i++) {
            if (i % X == 0 && i % Y == 0) {
                System.out.println("FizzBuzz");
                continue;
            }
            if (i % X == 0) {
                System.out.println("Fizz");
                continue;
            }
            if (i % Y == 0) {
                System.out.println("Buzz");
                continue;
            }
            System.out.println(i);
        }
    }
}
