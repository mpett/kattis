import java.io.IOException;
import java.util.Scanner;

/**
 * Created by martinpettersson on 09/11/15.
 */
public class T9Spelling {
    Kattio io = new Kattio(System.in);
    private int previousButton = 99;

    public static void main(String[] args) throws IOException {
        new T9Spelling();
    }

    public T9Spelling() throws IOException {
        String[] inputStrings = handleInput();
        int caseIndex = 1;
        for (String inputString : inputStrings) {
            System.out.println("Case #" + caseIndex + ": " +translate(inputString));
            caseIndex++;
        }
        io.close();
    }

    private String translate(String originalWord) {
        String translatedWord = "";
        for (int charIndex = 0; charIndex < originalWord.length(); charIndex++) {
            int sequence = characterConverter(originalWord.charAt(charIndex));
            int button = firstDigit(sequence);
            if (button == previousButton)
                translatedWord += " ";
            translatedWord += sequence;
            previousButton = button;
        }
        return translatedWord;
    }

    private int characterConverter(char character) {
        switch (character) {
            case 'a' : return 2;
            case 'b' : return 22;
            case 'c' : return 222;
            case 'd' : return 3;
            case 'e' : return 33;
            case 'f' : return 333;
            case 'g' : return 4;
            case 'h' : return 44;
            case 'i' : return 444;
            case 'j' : return 5;
            case 'k' : return 55;
            case 'l' : return 555;
            case 'm' : return 6;
            case 'n' : return 66;
            case 'o' : return 666;
            case 'p' : return 7;
            case 'q' : return 77;
            case 'r' : return 777;
            case 's' : return 7777;
            case 't' : return 8;
            case 'u' : return 88;
            case 'v' : return 888;
            case 'w' : return 9;
            case 'x' : return 99;
            case 'y' : return 999;
            case 'z' : return 9999;
            case ' ' : return 0;
        }
        return 0;
    }

    public static int firstDigit(int n) {
        while (n < -9 || 9 < n) n /= 10;
        return Math.abs(n);
    }

    private String[] handleInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.nextLine());
        String[] inputStrings = new String[numberOfLines];
        for (int i = 1; i<= numberOfLines;i++){
            String line = sc.nextLine();
            inputStrings[i-1] = line;
        }
        return inputStrings;
    }
}
