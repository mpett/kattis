import java.util.BitSet;

/**
 * Solution for Kattis problem-id: numbertree
 * https://open.kattis.com/problems/numbertree
 *
 * Author: Martin Pettersson
 */
public class Numbertree {
    Kattio io = new Kattio(System.in, System.out);
    int height; String path; long rootValue;
    final static char RIGHT = 'R';

    public static void main(String[] args) {
        new Numbertree();
    }

    public Numbertree() {
        handleInput();
        // The root value for a perfect binary tree is 2^(H+1)-1.
        rootValue = (long) Math.pow(2, (height + 1)) - 1;
        // If input is only the height, then output the root label.
        if(path == null || path.equals("\"\"") || path.equals(""))
            System.out.println(rootValue);
        else {
            // If we interpret the path of left and right as binary numbers,
            // we can figure out the index of the label on its row in the tree.
            int depth = path.length(); long base = 0;
            BitSet bitSet = new BitSet(depth);
            for(int currentDepth = 0; currentDepth < depth; currentDepth++) {
                base += (long) Math.pow(2, currentDepth+1);
                if(path.charAt(depth - currentDepth - 1) == RIGHT)
                    bitSet.set(currentDepth);
            }
            // The row index we are looking for is derived from the path
            // and the depth of the path.
            long label = rootValue - base
                    + ((long) Math.pow(2, depth) - convert(bitSet) - 1);
            // Output the found label.
            System.out.println(label);

        }
        // Flush input.
        io.close();
    }

    // Convert a BitSet to an integer (long).
    long convert(BitSet bits) {
        long value = 0L;
        for (int i = 0; i < bits.length(); ++i)
            value += bits.get(i) ? (1L << i) : 0L;
        return value;
    }

    // Read the input through Kattio.
    void handleInput() {
        height = io.getInt();
        path = io.getWord();
    }
}