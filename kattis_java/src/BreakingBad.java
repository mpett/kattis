import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by martinpettersson on 27/02/15.
 */
public class BreakingBad {
    Kattio io = new Kattio(System.in);
    private int N, M; private String[] items; private HashMap<String, Integer> itemIndices;
    private final static String NO_SOLUTION = "impossible";
    private boolean[] walter, jesse;

    public static void main(String[] args) {
        new BreakingBad();
    }

    public BreakingBad() {
        //printTestData(5000, 2000);
        //System.exit(0);
        AdjMatrixGraph dangerousPairs = handleInput();
        if (determineDistribution(dangerousPairs))
            printResult();
        else System.out.println(NO_SOLUTION);
        io.close();
    }

    void printResult() {
        String walterItems = ""; String jesseItems = "";
        for (int item = 0; item < N; item++) {
            if (walter[item]) walterItems += items[item] + " ";
            if (jesse[item]) jesseItems += items[item] + " ";
        }
        System.out.println(walterItems + "\n" + jesseItems);
    }

    boolean determineDistribution(AdjMatrixGraph dangerousPairs) {
        Iterator<Integer> itemPairs;
        walter = new boolean[N]; jesse = new boolean[N];
        for (int item = 0; item < N; item++) {
            itemPairs = dangerousPairs.adj(item).iterator();
            if (!itemPairs.hasNext())
                walter[item] = true;
            else {
                while (itemPairs.hasNext()) {
                    int dangerousItem = itemPairs.next();
                    if (walter[dangerousItem] && jesse[dangerousItem])
                        return false;
                    else if (walter[dangerousItem])
                        jesse[item] = true;
                    else walter[item] = true;
                }
            }
        }
        return true;
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

    void printTestData(int N, int M) {
        System.out.println(N*5);
        for (int i = 0; i < N; i++) {
            System.out.println("battery_acid" + i + "\n" + "drain_cleaner" + i + "\n" + "antifreeze" + i + "\n" + "cold_medicine" + i + "\n" + "lantern_fuel" + i);
        }
        System.out.println(M*2);
        for (int i = 0; i < M; i++) {
            System.out.println("cold_medicine" + i + " battery_acid" + i);
            System.out.println("antifreeze" + i + " cold_medicine" + i);
        }
    }
}
