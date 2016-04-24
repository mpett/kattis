/**
 * Created by martinpettersson on 28/01/16.
 */
public class SpeedLimit {
    private static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        while (true) {
            int numTestCases = io.getInt();
            if (numTestCases == -1) return;
            int prev = 0;
            int result = 0;
            for (int testCase = 0; testCase < numTestCases; testCase++) {
                int miles = io.getInt();
                int elapsedTime = io.getInt();
                result += miles * (elapsedTime - prev);
                prev = elapsedTime;
            }
            System.out.println(result + " miles");
        }
    }
}
