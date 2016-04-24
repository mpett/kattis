import java.util.Scanner;

/**
 * Created by martinpettersson on 05/12/15.
 */
public class RockPaperScissors {
    private int n, k, gamesInTotal, l, winAverage, w;
    private Kattio io = new Kattio(System.in);
    private final String ROCK = "rock";
    private final String PAPER = "paper";
    private final String SCISSORS = "scissors";

    public static void main(String[] args) {
        new RockPaperScissors();
    }

    public RockPaperScissors() {
        handleInput();
        io.close();
    }

    private void handleInput() {
        Scanner scanner = new Scanner(System.in);
        n = io.getInt();
        k = io.getInt();
        for (int game = 0; game < k; game++) {
            String line = scanner.nextLine();
            System.err.println(line);

        }
        scanner.close();
    }
}
