package nearsoft.algorithm.deepcopy;

import nearsoft.algorithm.deepcopy.Node;
import org.junit.Assert;
import org.junit.Test;


public class DeepCopyTest {

    @Test
    public void deepCopyTest(){

        Node node = new Node(1);
        this.addAdjacentNodes(node, 8);
        addCyclicReferences(node);
        Node copyNode = node.deepCopy();

        Assert.assertTrue(copyNode.isEquals(node));
    }

    @Test
    public void deepCopyFailTest(){

        Node node = new Node(1);
        this.addAdjacentNodes(node, 8);
        addCyclicReferences(node);
        Node copyNode = node.deepCopy();
        copyNode.getAdjacents().get(4).getAdjacents().get(0).getAdjacents().get(1).setData(99);

        Assert.assertFalse(copyNode.isEquals(node));
    }

    private void addAdjacentNodes(Node rootNode, int numberOfLevelsToAdd){

        int numberOfAbjects = numberOfLevelsToAdd;
        if (numberOfLevelsToAdd == 0){
            return;
        }

        for (int i = 0; i < numberOfAbjects; i++) {

            Node node = new Node(i);
            numberOfLevelsToAdd--;
            this.addAdjacentNodes(node,numberOfLevelsToAdd);
            rootNode.addAdjacent(node);
        }
    }

    private void addCyclicReferences(Node node) {

        node.addAdjacent(node);

        Node node50 = node.getAdjacents().get(5).getAdjacents().get(0);
        node.getAdjacents().get(3).getAdjacents().get(1).addAdjacent(node50);

        Node nodes120 = node.getAdjacents().get(1).getAdjacents().get(2).getAdjacents().get(0);
        node.getAdjacents().get(6).getAdjacents().get(0).addAdjacent(nodes120);

        node50.addAdjacent(nodes120);
        nodes120.addAdjacent(node50);
    }
}