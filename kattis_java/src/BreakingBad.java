import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by martinpettersson on 27/02/15.
 */
public class BreakingBad {
    Kattio io = new Kattio(System.in);
    private int N, M; private String[] items; private HashMap<String, Integer> itemIndices;
    private String walterItems, jesseItems; private final static String NO_SOLUTION = "impossible";

    public static void main(String[] args) {
        new BreakingBad();
    }

    public BreakingBad() {
        AdjMatrixGraph dangerousPairs = handleInput();
        if (determineDistribution(dangerousPairs))
            System.out.println(walterItems + "\n" + jesseItems);
        else System.out.println(NO_SOLUTION);
        io.close();
    }

    boolean determineDistribution(AdjMatrixGraph dangerousPairs) {
        HashMap<Integer, Boolean> walter = new HashMap<Integer, Boolean>();
        HashMap<Integer, Boolean> jesse = new HashMap<Integer, Boolean>();
        Iterable<Integer> itemPairs;
        for (int itemIndex = 0; itemIndex < N; itemIndex++) {
            itemPairs = dangerousPairs.adj(itemIndex);
            if (!itemPairs.iterator().hasNext()) {
                walter.put(itemIndex, true);
                walterItems += items[itemIndex] + " ";
                continue;
            } else {
                for (int itemPair : itemPairs) {
                    System.err.println(itemPair);
                    if (walter.get(itemPair) != null) {
                        jesse.put(itemPair, true);
                        jesseItems += items[itemIndex] + " ";
                    } else {
                        walter.put(itemIndex, true);
                        walterItems += items[itemIndex] + " ";
                    }
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
}
