package nearsoft.algorithm.deepcopy;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

public class Node {

    private int data;
    private List<Node> adjacents = new ArrayList<Node>();

    public Node(int data){
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public List<Node> getAdjacents() {
        return adjacents;
    }

    public void addAdjacent(Node node){
        this.adjacents.add(node);
    }

    public Node deepCopy(){

        IdentityHashMap<Node, Node> nodesAdded = new IdentityHashMap<Node, Node>();
        Node copyNode = copy( this, nodesAdded );
        return copyNode;
    }

    private Node copy(Node node, IdentityHashMap<Node, Node> nodesAdded) {

        Node copyNode = new Node(node.getData());
        nodesAdded.put(node, copyNode);

        for (Node adjacent :node.getAdjacents()) {

            if (!nodesAdded.containsKey(adjacent)) {

                Node adjecentCopy = copy(adjacent,nodesAdded);
                copyNode.addAdjacent(adjecentCopy);
            }else {
                copyNode.addAdjacent(nodesAdded.get(adjacent));
            }
        }
        return copyNode;
    }

    public boolean isEquals(Node node){
        LinkedList<Node> comparedNodes = new LinkedList<Node>();
        return this.deepCompare(this, node, comparedNodes);
    }

    private boolean deepCompare(Node node1, Node node2, LinkedList<Node> comparedNodes){

        if (comparedNodes.contains(node1) ) {
            return true;
        }

        comparedNodes.add(node1);

        if ( node1.data != node2.getData() ) {
            return false;
        }

        if ( node1.adjacents.size() != node2.getAdjacents().size()) {
            return false;
        }

        for (int i = 0; i < node1.getAdjacents().size(); i++) {

            Node newNode1 = node1.getAdjacents().get(i);
            Node newNode2 =node2.getAdjacents().get(i);

            boolean isEquals = deepCompare( newNode1, newNode2, comparedNodes );
            if (!isEquals){
                return false;
            }
        }
        return true;
    }

}
