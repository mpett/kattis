import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Bela {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in));
        HashMap<String, Integer> nonDominant =
                new HashMap<>();
        HashMap<String, Integer> dominant =
                new HashMap<>();

        nonDominant.put("A", 11); nonDominant.put("K", 4);
        nonDominant.put("Q", 3);  nonDominant.put("J", 2);
        nonDominant.put("T", 10); nonDominant.put("9", 0);
        nonDominant.put("8", 0);  nonDominant.put("7", 0);
        dominant.put("A", 11); dominant.put("K", 4);
        dominant.put("Q", 3);  dominant.put("J", 20);
        dominant.put("T", 10); dominant.put("9", 14);
        dominant.put("8", 0);  dominant.put("7", 0);

        String[] firstInput = reader
                            .readLine()
                            .split(" ");

        int N = Integer
                .parseInt(firstInput[0]);
        String dominantSuit
                = firstInput[1];
        int sum = 0;

        for (int index = 0; index < 4 * N; index++) {
            String input = reader.readLine();
            String card = String
                        .valueOf(input.charAt(0));
            String suit = String
                        .valueOf(input.charAt(1));
            if (suit.equals(dominantSuit))
                sum += dominant.get(card);
            else
                sum += nonDominant.get(card);
        }

        System.out.println(sum);
    }
}
