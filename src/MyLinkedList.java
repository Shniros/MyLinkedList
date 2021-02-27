import exception.NoSuchElementException;

import java.util.*;

public class MyLinkedList<E> implements Iterable<E>{
    private Node head;
    private Node tail;

    transient int size = 0;
    public void addToHead(E value){
        Node n = new Node(value);
        if(head == null){
            head = n;
            tail = head;
        }
        else{
            head.setPrev(n);
            n.setNext(head);
            head = n;
        }
        size++;
    }
    public Node findNode(E value){
        Node current = this.head;
        while(current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
        }
            return null;
    }
    public void delete(E value){
        Node node = findNode(value);
        if(node == null){
            throw new NoSuchElementException();
        }
        else if(head == tail && tail == node){
            this.head = null;
            this.tail = null;
            size--;
        }
        else if(head == node){
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
        else if(tail == node){
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        }
        else{
            Node next = node.getNext(); // делаем шаг вперед
            node = node.getPrev();//возвращаемся на шаг назад
            node.setNext(next); // связыем пред -> next
            next.setPrev(node); // пред <- next
            size--;
           }
    }
    public void addToTail(E value){
        Node n = new Node(value);
        if(head == null){
            head = n;
            tail = head;
        }
        else{
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        size++;
    }
    public boolean isEmpty() {
        return (head == null && tail == null);
    }
    public boolean contains(Object o) {
        return false;
    }
    public int getSize() {
        return size;
    }
    public Node getFirst() {
        return head;
    }
    public Node getLast() {
        return tail;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListItr(head);
    }

    private class ListItr implements Iterator<E>{
        private Node<E> lastReturned;
        private Node<E> next;

        public ListItr(Node curr){
            this.next = curr;
        }
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.getNext();
            return lastReturned.getValue();
        }
    }

}
