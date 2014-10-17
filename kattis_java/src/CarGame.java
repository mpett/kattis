/**
 * Created by martinpettersson on 17/10/14.
 */
import java.util.regex.Pattern;
public class CarGame {
    Kattio io = new Kattio(System.in);
    private static String[] words, plates;

    public static void main(String[] args) {
        new CarGame();
    }

    public CarGame() {
        // Handles input according to specification.
        handleInput();
        // Solve the actual problem using regular expressions.
        printValidWords();
        // Flush input stream.
        io.flush();
    }

    void printValidWords() {
        for (String plate : plates) {
            boolean foundWord = false;

            String regExp = "[a-zA-Z]*" + plate.charAt(0)
                            + "[a-zA-Z]*" + plate.charAt(1)
                            + "[a-zA-Z]*" + plate.charAt(2)
                            + "[a-zA-Z]*";

            for (String word : words) {
                if (Pattern.matches(regExp, word)) {
                    System.out.println(word);
                    foundWord = true;
                }
            }
            if (!foundWord)
                System.out.println("No valid word");
        }
    }

    void handleInput() {
        int numWords = io.getInt();
        int numPlates = io.getInt();
        words = new String[numWords]; plates = new String[numPlates];
        // Read all words
        for (int currentWordIndex = 0; currentWordIndex < numWords; currentWordIndex++)
            words[currentWordIndex] = io.getWord();
        // Read all numberplates, and remember to lowercase them.
        for (int currentPlateIndex = 0; currentPlateIndex < numPlates; currentPlateIndex++)
            plates[currentPlateIndex] = io.getWord().toLowerCase();
    }
}
