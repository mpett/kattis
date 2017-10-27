import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Autori {
    public static void main(String[] args)
            throws IOException {
        transform();
    }

    private static void transform()
            throws IOException {
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader
                                (System.in));
        String longForm = in.readLine();
        String[] splitLongForm = longForm.split("-");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : splitLongForm)
            stringBuilder.append(word.charAt(0));
        String result = stringBuilder.toString();
        System.out.println(result);
    }
}
