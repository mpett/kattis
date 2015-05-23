/**
 * Created by martinpettersson on 26/02/15.
 */
public class AlphabetSpam {
    Kattio io = new Kattio(System.in);
    String inputString;
    final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        new AlphabetSpam();
    }

    public AlphabetSpam() {
        handleInput();
        double results[] = ratioResults();
        for (double ratio : results)
            System.out.println(ratio);
        io.close();
    }

    double[] ratioResults() {
        double[] results = new double[4];
        double numWhitespaces = inputString.length() - inputString.replace("_", "").length();
        double whiteSpaceRatio = numWhitespaces / inputString.length();
        results[0] = whiteSpaceRatio;
        int originalLength = inputString.length();
        inputString = inputString.replace("_", "");
        char currentChar; double numLowercase = 0; double numUppercase = 0; double numSymbols = 0;
        for (int charIndex = 0; charIndex < inputString.length(); charIndex++) {
            currentChar = inputString.charAt(charIndex);
            if (LOWERCASE.indexOf(currentChar) != -1)
                numLowercase++;
            else if (UPPERCASE.indexOf(currentChar) != -1)
                numUppercase++;
            else numSymbols++;
        }
        results[1] = numLowercase / originalLength;
        results[2] = numUppercase / originalLength;
        results[3] = numSymbols / originalLength;
        return results;
    }

    void handleInput() {
        inputString = io.getWord();
    }
}
