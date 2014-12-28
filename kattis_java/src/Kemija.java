import java.util.Scanner;

/**
 * Created by martinpettersson on 28/12/14.
 */
public class Kemija {;
    final String VOWELS = "aeiou";

    public static void main(String[] args) {
        new Kemija();
    }

    public Kemija() {
        String inputString = handleInput();
        System.out.println(decodeMessage(inputString));
    }

    String decodeMessage(String message) {
        for (int vowelIndex = 0; vowelIndex < VOWELS.length(); vowelIndex++) {
            char vowel = VOWELS.charAt(vowelIndex);
            int messageIndex = message.indexOf(vowel);
            while (messageIndex != -1) {
                StringBuilder sb = new StringBuilder(message);
                sb = sb.delete(messageIndex, messageIndex+2);
                message = sb.toString();
                messageIndex = message.indexOf(vowel, messageIndex + 1);
            }
        }
        return message;
    }

    String handleInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
