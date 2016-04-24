import java.util.Arrays;

/**
 * Created by martinpettersson on 13/03/16.
 */
public class Substitution {
    private static Kattio io;
    private static int L;
    private static int[] message;
    private static int[] cryptoMessage;
    private static int[] p;

    private final static int ALPHABET_SIZE = 100;

    public static void main(String[] args) {
        io = new Kattio(System.in);
        int N = io.getInt();

        for (int problemNumber = 0; problemNumber < N; problemNumber++) {
            handleInput();
            int k = kSubstitution();
            System.out.println(k);
        }

        io.flush();
        io.close();
    }

    private static int kSubstitution() {
        int k = 0;
        boolean foundAnswer = false;
        int[] substitution = message;

        while (!foundAnswer) {
            if (substitution[0] == cryptoMessage[0]) {
                if (Arrays.equals(substitution, cryptoMessage))
                    foundAnswer = true;
            } else {
                for (int index = 0; index < L; index++)
                    substitution[index] = p[substitution[index] - 1];
                k++;
            }
        }
        return k;
    }

    private static void handleInput() {
        L = io.getInt();
        message = new int[L];
        cryptoMessage = new int[L];
        p = new int[ALPHABET_SIZE];

        for (int messageCharacter = 0; messageCharacter < L; messageCharacter++)
            message[messageCharacter] = io.getInt();

        for (int cryptoCharacter = 0; cryptoCharacter < L; cryptoCharacter++)
            cryptoMessage[cryptoCharacter] = io.getInt();

        for (int alphabetCharacter = 0; alphabetCharacter < ALPHABET_SIZE; alphabetCharacter++)
            p[alphabetCharacter] = io.getInt();
    }
}
