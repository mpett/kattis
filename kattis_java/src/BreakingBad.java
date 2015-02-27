import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by martinpettersson on 27/02/15.
 */
public class BreakingBad {
    Kattio io = new Kattio(System.in);
    private int N, M;
    private ArrayList<String> items; private HashMap<String, String> dangerousPairs;
    private ArrayList<String> walter, jesse;


    public static void main(String[] args) {
        new BreakingBad();
    }

    public BreakingBad() {
        handleInput();
        //test();
        walter = new ArrayList<String>();
        jesse = new ArrayList<String>();
        String dangerousPair;
        for (String item : items) {
            dangerousPair = dangerousPairs.get(item);
            if (dangerousPair != null) {
                jesse.add(item);
            } else
                walter.add(item);

        }
        if (walter.isEmpty() || jesse.isEmpty())
            System.out.printf("impossible");
        else {
            for (String item : walter)
                System.out.print(item + " ");
            System.out.println();
            for (String item : jesse)
                System.out.print(item + " ");
        }
    }

    void test() {
        System.err.println(N + " " + M);
        for (String item : items) {
            System.err.println("Item " + item);
            System.err.println("Dangerous with " + dangerousPairs.get(item));
            System.err.println("");
        }
    }

    void handleInput() {
        items = new ArrayList<String>();
        dangerousPairs = new HashMap<String, String>();
        N = io.getInt();
        for (int item = 0; item < N; item++)
            items.add(io.getWord());
        M = io.getInt();
        for (int itemPair = 0; itemPair < M; itemPair++)
            dangerousPairs.put(io.getWord(), io.getWord());
    }
}
