/**
 * Created by martinpettersson on 28/01/16.
 */
public class Oddities {
    private static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int numTestCases = io.getInt();
        for (int testCase = 0; testCase < numTestCases; testCase++) {
            int number = io.getInt();
            if (number % 2 == 0)
                System.out.println(number + " is even");
            else
                System.out.println(number + " is odd");
        }
    }
}
