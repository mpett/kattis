import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterDevelopment {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in));
        int N = Integer.parseInt(reader.readLine());
        int numberOfRelationships =
                (int) Math.pow(2, N) - N - 1;
        System.out.println(numberOfRelationships);
    }
}
