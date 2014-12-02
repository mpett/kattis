import java.util.Scanner;
import java.util.HashMap;

/**
 * Solution for Kattis problem-id: babelfish
 * https://open.kattis.com/problems/babelfish
 *
 * Author: Martin Pettersson
 */
public class Babelfish {
    String firstLanguage, secondLanguage = "";
    HashMap<String, String> dictionary = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Babelfish();
    }

    public Babelfish() {
        // We begin by storing words into a hash map.
        readDictionary();
        // Output translation for every word in message.
        while (scanner.hasNext())
            System.out.println(translation(scanner.nextLine()));
        // Close input stream.
        scanner.close();
    }

    String translation(String foreignWord) {
        String translatedWord = "eh";
        if (dictionary.containsKey(foreignWord))
            translatedWord = dictionary.get(foreignWord);
        return translatedWord;
    }

    void readDictionary() {
        String line = scanner.nextLine();
        while (!line.isEmpty()) {
            String[] words = line.split(" ");
            firstLanguage = words[0]; secondLanguage = words[1];
            dictionary.put(secondLanguage, firstLanguage);
            line = scanner.nextLine();
        }
    }
}
