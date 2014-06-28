/**
 * Solution for Kattis problem-id: erase
 * https://open.kattis.com/problems/erase
 *
 * Author: Martin Pettersson
 */
public class Erase {
    Kattio io = new Kattio(System.in, System.out);
    String beforeDel, afterDel;
    int N;

    public static void main(String[] args) {
        new Erase();
    }

    public Erase() {
        handleInput(); String result;
        // If N is even, the problem is easy. We just need to check that both strings are equal.
        if(N % 2 == 0)
            result = beforeDel.equals(afterDel) ? "Deletion succeeded" : "Deletion failed";
        // If not, we have to check if the second binary string is the first one reversed.
        else
            result = afterDel.equals(reverseBinary(beforeDel)) ? "Deletion succeeded" : "Deletion failed";
        // Result printed to stdout
        System.out.println(result);
        // Flush input
        io.flush();
    }

    // Takes a binary string as input, and returns the reversed binary string.
    String reverseBinary(String binary) {
        StringBuilder builder = new StringBuilder();
        for(int character = 0; character < binary.length(); character++) {
            if(binary.charAt(character) == '0')
                builder.append('1');
            else builder.append('0');
        }
        return builder.toString();
    }

    // Reads from stdin using Kattio according to problem specification.
    void handleInput() {
        N = io.getInt();
        beforeDel = io.getWord();
        afterDel = io.getWord();
    }
}
 