public class LinkedListStringStack {
    private class Node {
        Node next;
        String value;
    }
    
    private Node root = null;

    public void push(String item) {
        // Add Node to the beggining of linked list
        Node prevRoot = root;
        root = new Node();
        root.next = prevRoot;
        root.value =  item;
    }

    public String pop() {
        //remove first element from linked list
        String to_pop = root.value;
        root = root.next;
        return to_pop;
    }

    boolean isEmpty() {
        return root == null;
    }

}