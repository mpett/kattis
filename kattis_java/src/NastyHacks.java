import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NastyHacks {
    private static int n;
    private static int r, e , c;

    public static void main(String[] args)
            throws IOException {
        analyze();
    }

    private static void analyze()
            throws IOException {
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader
                                (System.in));
        n = Integer.parseInt(in.readLine());

        for (int testCase = 0; testCase < n; testCase++) {
            String input = in.readLine();
            String[] inputSplit = input.split(" ");
            r = Integer.parseInt(inputSplit[0]);
            e = Integer.parseInt(inputSplit[1]);
            c = Integer.parseInt(inputSplit[2]);
            if ((e - c) == r)
                System.out.println("does not matter");
            else if((e - c) > r)
                System.out.println("advertise");
            else
                System.out.println("do not advertise");
        }
    }
}
