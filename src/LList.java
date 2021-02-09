import java.util.Iterator;

public class LList{
    private Node head;
    private Node tail;
    public void addValueToHead(int value){
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
    }
    public void delete(int value){
        if(head == null){
            return;
        }
        else if(head == tail && tail.getValue() == value){
            this.head = null;
            this.tail = null;
            return;
        }
        else if(head.getValue() == value){
            head = head.getNext();
            head.setPrev(null);
        }
        else if(tail.getValue() == value){
            tail = tail.getPrev();
            tail.setNext(null);
        }
        else{
            Node current = this.head;
            while(current != null){
                if(current.getValue() == value){
                    //temp.prev | temp | temp.getNext()
                    Node next = current.getNext(); // делаем шаг вперед
                    current = current.getPrev();//возвращаемся на шаг назад
                    current.setNext(next); // связыем пред -> next
                    next.setPrev(current); // пред <- next
                }
                current = current.getNext();
            }
        }
    }
    public void addValueToTail(int value){
        Node n = new Node(value);
        //System.out.println("dick");
        if(head == null){
            head = n;
            tail = head;
        }
        else{
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
    }

    public class Iter implements Iterator {
        private Node pos;
        public Iter(){
            pos = head;
        }
        @Override
        public boolean hasNext() {
            return pos != null;
        }

        @Override
        public Object  next() {
            if(pos == null){
                return null;
            }
            else {
                Node temp = pos;
                pos = pos.getNext();
                return temp;
            }
        }
    }

}
