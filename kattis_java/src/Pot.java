import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String unformatted = reader.readLine();
            int power = Integer.parseInt(
                    String.valueOf(
                            unformatted.charAt
                                    (unformatted.length()-1)));
            unformatted = unformatted
                    .substring(0, unformatted.length()-1);
            int X = Integer.parseInt(unformatted);
            int result =
                    (int) Math.pow((int) X, (int) power);
            results.add(result);
        }

        int sum = results
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

    }
}
