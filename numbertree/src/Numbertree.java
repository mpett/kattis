import java.util.ArrayList;

class Node {
    Node L, R;
    int label;
    Node(int label) {
        this.label = label;
    }
}

public class Numbertree {
    Kattio io = new Kattio(System.in, System.out);
    int height; String path; int rootValue;
    final static char LEFT = 'L';
    Node root;
    ArrayList<ArrayList<Node>> blargh;

    public static void main(String[] args) {
        new Numbertree();
    }

    public Numbertree() {
        handleInput();
        rootValue = (int) Math.pow(2, (height + 1)) - 1;
        if(path == null) {
            System.out.println(rootValue);
        } else {
            populateTree();
            System.out.println(findNode());
        }
        io.close();
    }

    void populateTree() {
        blargh = new ArrayList<ArrayList<Node>>();
        int count = rootValue;
        for(int depth = 0; depth <= path.length(); depth++) {
            int numNodes = (int) Math.pow(2, depth);
            ArrayList<Node> nodes = new ArrayList<Node>();
            for(int i = 0; i < numNodes; i++) {
                Node node = new Node(count);
                nodes.add(node);
                count--;
            }
            blargh.add(nodes);
        }

        for(int depth = 0; depth < path.length(); depth++) {
            int lol = 0;
            for(int i = 0; i < blargh.get(depth).size(); i++) {
                blargh.get(depth).get(i).L = blargh.get(depth + 1).get(lol);
                blargh.get(depth).get(i).R = blargh.get(depth + 1).get(lol+1);
                lol += 2;
            }
        }

        root = blargh.get(0).get(0);
    }

    int findNode() {
        Node tmpNode = root;
        for(int direction = 0; direction < path.length(); direction++) {
            if(path.charAt(direction) == LEFT)
                tmpNode = tmpNode.L;
            else
                tmpNode = tmpNode.R;
        }
        return tmpNode.label;
    }

    void handleInput() {
        height = io.getInt();
        path = io.getWord();
    }
}