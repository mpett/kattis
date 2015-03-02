import java.util.HashMap;

/**
 * Created by martinpettersson on 27/02/15.
 */
public class BreakingBad {
    Kattio io = new Kattio(System.in);
    private int N, M; private String[] items; private HashMap<String, Integer> itemIndices;

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
        items = new String[N];
        itemIndices = new HashMap<String, Integer>();
        String currentItem;
        for (int item = 0; item < N; item++) {
            currentItem = io.getWord();
            items[item] = currentItem;
            itemIndices.put(currentItem, item);
        }
        M = io.getInt();
        AdjMatrixGraph itemGraph = new AdjMatrixGraph(N);
        System.err.println(M);
        for (int i = 0; i < M; i++) {
            String firstItem = io.getWord(); String secondItem = io.getWord();
            int V = itemIndices.get(firstItem); int E = itemIndices.get(secondItem);
            itemGraph.addEdge(V, E);
        }
        return itemGraph;
    }
}
