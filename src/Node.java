import java.util.Iterator;

public class Node {
    private int value;
    private Node next;
    private Node prev;
    public Node(){};
    public Node(int value){
        this.value = value;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getNext() {
        return next;
    }
    public Node getPrev(){
        return prev;
    }
    public int getValue() {
        return value;
    }

}
