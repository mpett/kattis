

/**
 * Created by martinpettersson on 27/02/15.
 */
public class BreakingBad {
    Kattio io = new Kattio(System.in);
    private int N, M;

    public static void main(String[] args) {
        new BreakingBad();
    }

    public BreakingBad() {
        AdjMatrixGraph dangerousPairs = handleInput();
        System.err.println(dangerousPairs);
        io.close();
    }

    AdjMatrixGraph handleInput() {
        N = io.getInt();
        String[] items = new String[N];
        for (int item = 0; item < N; item++)
            items[item] = io.getWord();
        M = io.getInt();
        AdjMatrixGraph itemGraph = new AdjMatrixGraph(hashItem(io.getWord()), hashItem(io.getWord()));
        for (int dangerousPair = 1; dangerousPair < M; dangerousPair++) {
            String firstItem = io.getWord(); String secondItem = io.getWord();
            int V = hashItem(firstItem); int E = hashItem(secondItem);
            itemGraph = new AdjMatrixGraph(V, E);
        }
        return itemGraph;
    }

    int hashItem(String item) {
        int hash=3;
        int strlen = item.length();
        for (int i=0; i < strlen; i++) {
            hash = hash+item.charAt(i);
        }
        return Math.abs(hash);
    }
}
