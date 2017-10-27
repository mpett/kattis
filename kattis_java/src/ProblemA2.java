import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.stream.IntStream;

public class ProblemA2 {
    private static int N;
    private static int[] M;
    private static int[] S;


    public static void main(String[] args)
            throws IOException {
        minuteLength();
    }

    private static void minuteLength()
            throws IOException {
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader
                                (System.in));
        N = Integer.parseInt(in.readLine());
        M = new int[N]; S = new int[N];
        for (int problem = 0; problem < N; problem++) {
            String[] input =
                    in.readLine().split(" ");
            int mt = Integer.parseInt(input[0]);
            int st = Integer.parseInt(input[1]);
            M[problem] = mt;
            S[problem] = st;
        }

        int sumM = IntStream.of(M).sum();
        int sumS = IntStream.of(S).sum();
        double result = (double) sumS
                / ((double) sumM * 60.0);

        DecimalFormat df =
                new DecimalFormat("#.000000000");
        String output =
                df.format(result).toString();

        if (result <= 1.0) {
            System.out.println
                    ("measurement error");
        } else {
            System.out.println(output);
        }
    }
}
