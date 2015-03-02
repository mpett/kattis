import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by martinpettersson on 27/02/15.
 */
public class BreakingBad {
    Kattio io = new Kattio(System.in);
    private int N, M; private String[] items; private HashMap<String, Integer> itemIndices;
    private ArrayList<String> walter, jesse; private final static String NO_SOLUTION = "impossible";

    public static void main(String[] args) {
        new BreakingBad();
    }

    public BreakingBad() {
        AdjMatrixGraph dangerousPairs = handleInput();
        if (determineDistribution(dangerousPairs))
            printResult();
        else System.out.println(NO_SOLUTION);
        io.close();
    }

    boolean determineDistribution(AdjMatrixGraph dangerousPairs) {
        return false;
    }

    void printResult() {
        for (String item : walter)
            System.out.print(item + " ");
        System.out.println();
        for (String item : jesse)
            System.out.println(item + " ");
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
        String firstItem, secondItem; int V, E;
        for (int i = 0; i < M; i++) {
            firstItem = io.getWord(); secondItem = io.getWord();
            V = itemIndices.get(firstItem); E = itemIndices.get(secondItem);
            itemGraph.addEdge(V, E);
        }
        return itemGraph;
    }
}
