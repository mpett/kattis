import java.util.Collections;
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
        findPath(0, 0, 1, 2, map, 4, 3, outBuffer, 12);

        // Second test
        int[] newMap = {0, 0, 1, 0, 1, 1, 1, 0, 1};
        int[] newBuffer = new int[7];
        findPath(2, 0, 0, 2, newMap, 3, 3, newBuffer, 7);
    }

    private static void findPath(int startX, int startY, int targetX, int targetY,
                                 int[] map, int mapWidth, int mapHeight, int[] outBuffer, int outBufferSize) {

        // The set of nodes already evaluated.
        HashSet<Cell<Integer, Integer>> closedSet = new HashSet<Cell<Integer, Integer>>();

        // The set of currently discovered nodes still to be evaluated.
        // Initially, only the start node is known.
        Cell<Integer, Integer> startCell = new Cell<Integer, Integer>(startX, startY);
        HashSet<Cell<Integer, Integer>> openSet = new HashSet<Cell<Integer, Integer>>();
        openSet.add(startCell);

        // For each node, which node it can most efficiently be reached from.
        // If a node can be reached from many nodes, it will eventually contain the most
        // efficient previous step.
        HashMap<Cell<Integer, Integer>, Cell<Integer, Integer>> cameFrom =
                new HashMap<Cell<Integer, Integer>, Cell<Integer, Integer>>();

        // For each node, the cost of getting from the start node to that node.
        HashMap<Cell<Integer, Integer>, Integer> gScore = new HashMap<Cell<Integer, Integer>, Integer>();

        // The cost of going from start to start is zero.
        gScore.put(startCell, 0);

        // For each node, the total cost of getting from the start node to the goal node
        // by passing by that node. That value is partly known, partly heuristic.
        HashMap<Cell<Integer, Integer>, Integer> fScore = new HashMap<Cell<Integer, Integer>, Integer>();

        // For the first node, that value is completely heuristic.
        Cell<Integer, Integer> goalCell = new Cell<Integer, Integer>(startX, startY);
        fScore.put(startCell, heuristicCostEstimate(startCell, goalCell));

        Grid cellGrid = new Grid(startCell, goalCell, map, mapWidth, mapHeight);

        System.err.println("lol");
    }

    private static void reconstructPath(HashMap<Cell<Integer, Integer>, Cell<Integer, Integer>> cameFrom,
                                        Cell currentCell) {
        // TODO
    }

    private static int heuristicCostEstimate(Cell startNode, Cell goalNode) {
        return 0;
    }


}

class Grid {
    private Cell startCell;
    private Cell goalCell;
    private Cell[][] gridStructure;
    private int width, height;

    public Grid(Cell startCell, Cell goalCell, int[] map, int width, int height) {
        this.startCell = startCell;
        this.goalCell = goalCell;
        this.width = width;
        this.height = height;
        gridStructure = new Cell[width][height];
        buildGrid();
    }

    public String toString() {
        return "";
    }

    private void buildGrid() {
        for (int xCoordinate = 0; xCoordinate < width; ++xCoordinate) {
            for (int yCoordinate = 0; yCoordinate < height; ++yCoordinate) {
                gridStructure[xCoordinate][yCoordinate] = new Cell(xCoordinate, yCoordinate);
            }
        }
    }

}

/**
 * Cell Data Structure
 * @param <X>
 * @param <Y>
 */
class Cell<X,Y> {
    private final X xCoordinate;
    private final Y yCoordinate;
    private int fScore;

    public Cell(X xCoordinate, Y yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getfScore() { return fScore; }

    public X getX() { return xCoordinate; }
    public Y getY() { return yCoordinate; }

    @Override
    public int hashCode() { return xCoordinate.hashCode() ^ yCoordinate.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell)) return false;
        Cell pairo = (Cell) o;
        return this.xCoordinate.equals(pairo.getX()) &&
                this.yCoordinate.equals(pairo.getY());
    }
}

/**
 * Compares the fScore values of two cells
 */
class CellComparator implements Comparator<Cell> {
    @Override
    public int compare(Cell firstCell, Cell secondCell) {
        if (firstCell.getfScore() > secondCell.getfScore())
            return 1;
        else return -1;
    }
}
