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
            BitSet bitSet = new BitSet(path.length());
            int depth = path.length();
            for(int i = 0; i < depth; i++) {
                if(path.charAt(depth -i -1) == RIGHT)
                    bitSet.set(i);
            }
            // The row index we are looking for is derived from the path
            // and the depth of the path.
            long rowIndex = (long) Math.pow(2, depth) - convert(bitSet) - 1;
            // We get the row of interest by looking at the depth.
            // Row = 2 ^ depth. This value is subtracted from the root
            // label value in order to get the first label value of the row.
            long subtractor = 0;
            for(int i = 1; i <= depth; i++)
                subtractor += (long) Math.pow(2, i);
            long label = rootValue - subtractor + rowIndex;
            // Output the found label.
            System.out.println(label);

        }
        // Flush input.
        io.close();
    }

    // Convert a BitSet to an integer (long).
    long convert(BitSet bits) {
        long value = 0L;
        for (int i = 0; i < bits.length(); ++i) {
            value += bits.get(i) ? (1L << i) : 0L;
        }
        return value;
    }

    // Read the input through Kattio.
    void handleInput() {
        height = io.getInt();
        path = io.getWord();
    }
}