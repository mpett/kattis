/**
 * Created by martinpettersson on 26/02/15.
 */
public class AlphabetSpam {
    Kattio io = new Kattio(System.in);
    private final char UNDERSCORE = '_';
    String inputString; double underscores, lowerCase, upperCase, symbols;

    public static void main(String[] args) {
        new AlphabetSpam();
    }

    public AlphabetSpam() {
        inputString = handleInput();
        count();
        printResults();
        io.close();
    }

    void printResults() {
        double wordLength = (double) inputString.length();
        System.out.println(underscores/wordLength + "\n" +
                           lowerCase/wordLength + "\n" +
                           upperCase/wordLength + "\n" +
                           symbols/wordLength
        );
    }

    void count() {
        char character;
        for (int characterIndex = 0; characterIndex < inputString.length(); characterIndex++) {
            character = inputString.charAt(characterIndex);
            if (character == UNDERSCORE)
                underscores++;
            else if (Character.isLowerCase(character))
                lowerCase++;
            else if (Character.isUpperCase(character))
                upperCase++;
            else if (!Character.isAlphabetic(character))
                symbols++;
        }
    }

    String handleInput() {
        return io.getWord();
    }
}
