import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadrantSelecition {
    public static void main(String[] args)
            throws IOException {
        determineQuadrant();
    }

    private static void determineQuadrant()
            throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in));
        int x = Integer.parseInt
                (reader.readLine());
        int y = Integer.parseInt
                (reader.readLine());
        if (x > 0 && y > 0)
            System.out.println("1");
        else if (x > 0 && y < 0)
            System.out.println("4");
        else if (x < 0 && y < 0)
            System.out.println("3");
        else if (x < 0 && y > 0)
            System.out.println("2");
    }
}
