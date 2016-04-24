import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by martinpettersson on 24/04/16.
 */
public class Pathfinder {

    public static void main(String[] args) {
        // First test
        int[] map = {1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1};
        int[] outBuffer = new int[12];
        int result = findPath(0, 0, 1, 2, map, 4, 3, outBuffer, 12);
        System.out.println(result);

        // Second test
        int[] newMap = {0, 0, 1, 0, 1, 1, 1, 0, 1};
        int[] newBuffer = new int[7];
        result = findPath(2, 0, 0, 2, newMap, 3, 3, newBuffer, 7);
        System.out.println(result);
    }

    private static int findPath(int startX, int startY, int targetX, int targetY,
                                int[] map, int mapWidth, int mapHeight, int[] outBuffer, int outBufferSize) {
        // The set of nodes already evaluated.
        HashSet<Node<Integer, Integer>> closedSet = new HashSet<Node<Integer, Integer>>();

        // The set of currently discovered nodes still to be evaluated.
        // Initially, only the start node is known.
        Node<Integer, Integer> startNode = new Node<Integer, Integer>(startX, startY);
        HashSet<Node<Integer, Integer>> openSet = new HashSet<Node<Integer, Integer>>();
        openSet.add(startNode);

        // For each node, which node it can most efficiently be reached from.
        // If a node can be reached from many nodes, it will eventually contain the most
        // efficient previous step.
        HashMap<Node<Integer, Integer>, Node<Integer, Integer>> cameFrom =
                new HashMap<Node<Integer, Integer>, Node<Integer, Integer>>();

        // For each node, the cost of getting from the start node to that node.
        HashMap<Node<Integer, Integer>, Integer> gScore = new HashMap<Node<Integer, Integer>, Integer>();

        // The cost of going from start to start is zero.
        gScore.put(startNode, 0);

        // For each node, the total cost of getting from the start node to the goal node
        // by passing by that node. That value is partly known, partly heuristic.
        HashMap<Node<Integer, Integer>, Integer> fScore = new HashMap<Node<Integer, Integer>, Integer>();

        // For the first node, that value is completely heuristic.
        Node<Integer, Integer> goalNode = new Node<Integer, Integer>(startX, startY);
        fScore.put(startNode, heuristicCostEstimate(startNode, goalNode));

        while (!openSet.isEmpty()) {

        }


        return 0;
    }

    private static int heuristicCostEstimate(Node startNode, Node goalNode) {
        return 0;
    }


}

class Node<L,R> {
    private final L left;
    private final R right;
    private int fScore;

    public Node(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }

    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) return false;
        Node pairo = (Node) o;
        return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
    }
}