import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemA {
    private static int N;
    private static String beforeDeletion;
    private static String afterDeletion;

    public static void main(String[] args)
            throws IOException {
        readInput();
        if (validate())
            System.out.println("Deletion succeeded");
        else
            System.out.println("Deletion failed");
    }

    private static void readInput()
            throws IOException {
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader
                                (System.in));
        N = Integer.parseInt(in.readLine());
        beforeDeletion = in.readLine();
        afterDeletion = in.readLine();

    }

    private static boolean validate() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int charIndex = 0;
             charIndex < beforeDeletion.length();
             charIndex++) {
            if (afterDeletion.charAt(charIndex) == '1')
                stringBuilder.append('0');
            else if (afterDeletion.charAt(charIndex) == '0')
                stringBuilder.append('1');
        }

        String validation
                = stringBuilder.toString();
        if (validation.equals(beforeDeletion) && N%2 == 0)
            return true;
        if (!validation.equals(beforeDeletion)
                && N%2 != 0) {
            return true;
        }
        return false;
    }
}
