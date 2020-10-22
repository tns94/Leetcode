package october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3501/
 */

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> nodePool = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null)
            return node;

        if (nodePool.containsKey(node))
            return nodePool.get(node);

        Node clonedNode = new Node(node.val, new ArrayList<>());
        nodePool.put(node, clonedNode);

        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        return clonedNode;
    }

    public static void main(String[] args) {
        Node node=new Node(1);
        CloneGraph cloneGraph=new CloneGraph();
        cloneGraph.cloneGraph(null);

    }
}
