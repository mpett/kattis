import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by martinpettersson on 28/01/16.
 */
public class ColdputerScience {
    private static Kattio io = new Kattio(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String line = reader.readLine();
        System.out.println(line.length() - line.replace("-", "").length());
    }
}
