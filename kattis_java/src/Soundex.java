/**
 * Created by martinpettersson on 12/11/14.
 */
public class Soundex {
    Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        new Soundex();
    }

    public Soundex() {
        String inputString = handleInput();
        String result = americanSoundex(inputString);
        System.out.println(result);
        io.close();
    }

    String americanSoundex(String inputString) {
        // Retain the first letter of the name and drop all other occurrences of a, e, i, o, u, y, h, w.
        char firstLetter = inputString.charAt(0);
        inputString = inputString.substring(1);
        inputString = inputString.replaceAll("[aeiouyh]", "");

        // b, f, p, v → 1
        inputString = inputString.replaceAll("[bfpv]", "1");
        // c, g, j, k, q, s, x, z → 2
        inputString = inputString.replaceAll("[cgjkqsxz]", "2");
        // d, t → 3
        inputString = inputString.replaceAll("[dt]", "3");
        // l → 4
        inputString = inputString.replaceAll("[l]", "4");
        // m, n → 5
        inputString = inputString.replaceAll("[mn]", "5");
        // r → 6
        inputString = inputString.replaceAll("[r]", "6");

        // Return resulting string as upper cased.
        String resultingString = firstLetter + inputString;
        return resultingString.toUpperCase();
    }

    String handleInput() {
        return io.getWord();
    }
}
