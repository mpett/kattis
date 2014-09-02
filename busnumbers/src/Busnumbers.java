import java.util.Arrays;
public class Busnumbers {

    Kattio io = new Kattio(System.in, System.out);
    private static int N; private static int[] numbers;
    public static void main(String[] args) {
        new Busnumbers();
    }

    public Busnumbers() {
        // Handle input according to problem specification.
        handleInput();
        // Sort input array.
        Arrays.sort(numbers);
        // Find the solution and print it.
        printShortestRepresentation();
        // Flush io.
        io.flush();
    }

    void printShortestRepresentation() {
        boolean hasConsecutive = false;
        int numConseqs = 0;
        for (int index = 0; index < N - 1; index++) {
            int currentNumber = numbers[index];
            int nextNumber = numbers[index + 1];
            if (hasConsecutive && (currentNumber + 1) == nextNumber) {
                numConseqs++;
                continue;
            }
            else if (hasConsecutive && !((currentNumber + 1) == nextNumber)) {
                if (numConseqs >= 2)
                    System.out.print("-" + currentNumber + " ");
                else
                    System.out.print(" " + currentNumber + " ");
                hasConsecutive = false;
                numConseqs = 0;
                continue;
            } else if ((currentNumber + 1) == nextNumber) {
                hasConsecutive = true;
                numConseqs++;
                System.out.print(currentNumber);
            } else
                System.out.print(currentNumber + " ");

        }
        if (hasConsecutive) {
            if (numConseqs >= 2)
                System.out.print("-" + numbers[N - 1]);
            else
                System.out.print(" " + numbers[N - 1]);
        }
        else
            System.out.print(numbers[N-1]);
        System.out.println();
    }

    void handleInput() {
        N = io.getInt();
        numbers = new int[N];
        for (int index = 0; index < N; index++) {
            numbers[index] = io.getInt();
        }
    }
}