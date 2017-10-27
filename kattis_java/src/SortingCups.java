import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingCups {
    private static int N;
    public static void main(String[] args)
            throws IOException {
        sortCups();
    }

    private static void sortCups() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        ArrayList<Cup> cups = new ArrayList<>();

        for (int problem = 0; problem < N; problem++) {
            String[] input =
                    reader.readLine().split(" ");
            double radius; String color;

            try {
                radius = Double.parseDouble(input[0]) / 2.0;
                color = input[1];
            } catch (NumberFormatException e) {
                radius = Double.parseDouble(input[1]);
                color = input[0];
            }

            cups.add(new Cup(color, radius));
        }

        Collections.sort(cups);

        for (Cup cup : cups) {
            System.out.println(cup);
        }
    }
}

class Cup implements Comparator<Cup>, Comparable<Cup>{
    private String color;
    private double radius;

    public Cup(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public String toString() {
        return color;
    }

    @Override
    public int compare(Cup o1, Cup o2) {
        return (int) o1.radius - (int) o2.radius;
    }

    @Override
    public int compareTo(Cup o) {
        return (int) this.radius - (int) o.radius;
    }
}
