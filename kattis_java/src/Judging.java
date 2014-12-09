import java.util.Set;

/**
 * Created by martinpettersson on 07/12/14.
 */
public class Judging {
    private static String CORRECT = "correct";
    private static String WRONG_ANSWER = "wronganswer";
    private static String TIME_LIMIT = "timelimit";
    private int numberOfSubmissions;
    int[] kattis_submissions = new int[3]; int[] dom_submissions = new int[3];

    Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        new Judging();
    }

    public Judging() {
        handleInput();
        int totalDiff = 0;
        for (int index = 0; index < 3; index++) {
            totalDiff += Math.abs(kattis_submissions[index] - dom_submissions[index]);
        }
        System.out.println(numberOfSubmissions - (totalDiff/2));
    }

    void handleInput() {
        numberOfSubmissions = io.getInt();
        for (int kattis = 0; kattis < numberOfSubmissions; kattis++) {
            String result = io.getWord();
            if (result.equals(CORRECT))
                kattis_submissions[0]++;
            else if (result.equals(WRONG_ANSWER))
                kattis_submissions[1]++;
            else
                kattis_submissions[2]++;
        }

        for (int dom = 0; dom < numberOfSubmissions; dom++) {
            String result = io.getWord();
            if (result.equals(CORRECT))
                dom_submissions[0]++;
            else if (result.equals(WRONG_ANSWER))
                dom_submissions[1]++;
            else
                dom_submissions[2]++;
        }
    }
}
