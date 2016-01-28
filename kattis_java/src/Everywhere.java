import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by martinpettersson on 28/01/16.
 */
public class Everywhere {
    Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        new Everywhere();
    }

    public Everywhere() {
        handleInput();
    }

    void handleInput() {
        int T = io.getInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int n = io.getInt();
            String[] input = new String[n];
            for (int city = 0; city < n; city++) {
                input[city] = io.getWord();
            }
            System.out.println(uniqueElements(input));
        }
    }

    int uniqueElements(String[] inputArray) {
        Set<String> uniqueElements = new TreeSet<String>();
        uniqueElements.addAll(Arrays.asList(inputArray));
        return uniqueElements.size();
    }
}
