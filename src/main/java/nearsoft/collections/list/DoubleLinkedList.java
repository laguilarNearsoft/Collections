package nearsoft.collections.list;

import java.util.LinkedList;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void add( T newData){

        final Node<T> newNode = new Node<T>(newData);

        if ( tail == null ){
            head = newNode;
            tail = newNode;
        }

        tail.nextNode = newNode;
        newNode.previousNode = tail;
        tail = newNode;
    }

    public void add(int index, T newData){

        final Node<T> nodeToAdd = new Node<T>(newData);

        Node<T> currentNode = getNodeByIndex(index);

        if (currentNode.previousNode == null){
            head = nodeToAdd;
            nodeToAdd.nextNode = currentNode.nextNode;
            return;
        }

        currentNode.previousNode.nextNode = nodeToAdd;
        nodeToAdd.nextNode = currentNode;

    }

    public void delete(int index) {

        if (head == null) {
            return;
        }

        if (index == 0) {
            head = head.nextNode;
            head.previousNode = null;
            return;
        }

        final Node<T> currentNode = getNodeByIndex(index);

        if ( head.equals(currentNode) ){
            head = currentNode.previousNode;
            return;
        }

        currentNode.previousNode.nextNode = currentNode.nextNode;
        currentNode.nextNode.previousNode = currentNode.previousNode;
    }

    public void printList(){

        Node<T> node = this.head;
        while (node != null ) {
            System.out.println(node.data);
            node = node.nextNode;
        }

    }

    public void delete(T dataToDelete){

        Node<T> currentNode = head;

        if( currentNode.data.equals(dataToDelete)){
            head = currentNode.nextNode;
        }

        boolean dataDeleted = false;
        while (currentNode != null && !dataDeleted) {

            if (currentNode.nextNode != null && currentNode.nextNode.data.equals(dataToDelete)) {
                Node<T> replaceNode = currentNode.nextNode.nextNode;
                currentNode.nextNode = replaceNode;
                dataDeleted = true;
            }
            currentNode = currentNode.nextNode;
        }

    }

    public T get(int index){

        final Node<T> node = this.getNodeByIndex(index);

        if ( node == null ){
            return null;
        }

        return node.data;
    }

    private Node<T> getNodeByIndex(int index) {

        Node<T> currentNode = this.head;
        for (int i = 0; (i < index ) && (currentNode != null); i++) {
            currentNode = currentNode.nextNode;
        }

        if ( currentNode == null){
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }

        return currentNode;
    }

    public T search( T data){

        Node<T> node = this.head;
        while (node != null ) {

            if( node.data.equals(data)) {
                return data;
            }
            node = node.nextNode;
        }
        return null;
    }

    private static class Node<T>{

        private T data;
        private Node<T> nextNode;
        private Node<T> previousNode;

        public Node(T data) {
            this.data = data;
        }
    }

}
