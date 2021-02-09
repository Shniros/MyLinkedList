import exception.NoSuchElementException;

import java.util.Iterator;

public class LList<E>{
    private Node head;
    private Node tail;

    transient int size = 0;
    public void addValueToHead(E value){
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
    public void delete(E value){
        if(head == null){
            throw new NoSuchElementException();
        }
        else if(head == tail && tail.getValue() == value){
            this.head = null;
            this.tail = null;
            size--;
        }
        else if(head.getValue() == value){
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
        else if(tail.getValue() == value){
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        }
        else{
            Node current = this.head;
            while(current != null){
                if(current.getValue() == value){
                    Node next = current.getNext(); // делаем шаг вперед
                    current = current.getPrev();//возвращаемся на шаг назад
                    current.setNext(next); // связыем пред -> next
                    next.setPrev(current); // пред <- next
                }
                current = current.getNext();
                size--;
            }
        }
    }
    public void addValueToTail(E value){
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
    public int getSize() {
        return size;
    }

}
