import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by martinpettersson on 28/01/16.
 */
public class Veci {
    private static Kattio io = new Kattio(System.in);
    private static ArrayList<Integer> permutations;
    private static int inputLength;
    private static int originalNumber;

    public static void main(String[] args) {
        permutations = new ArrayList<Integer>();
        String line = io.getWord();
        inputLength = line.length();
        originalNumber = Integer.parseInt(line);
        permutation(line);
        if (permutations.isEmpty()) System.out.println(0);
        else System.out.println(Collections.min(permutations));
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0 && prefix.length() == inputLength) {
            int permutation = Integer.parseInt(prefix);
            if (permutation > originalNumber)
                permutations.add(permutation);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
