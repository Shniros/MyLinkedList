
public class Node<E> {
    private E value;
    private Node next;
    private Node prev;
    public Node(){};
    public Node(E value){
        this.value = value;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public void setValue(E value) {
        this.value = value;
    }
    public Node getNext() {
        return next;
    }
    public Node getPrev(){
        return prev;
    }
    public E getValue() {
        return value;
    }

}
