import java.util.Iterator;

public class OnePathList implements Iterable{
    private Node head;
    private Node tail;
    public void addValueToHead(int value){
        Node n = new Node(value);
        if(head == null){
            n.setIndex(0);
            head = n;
            tail = head;
        }
        else{
            head.setPrev(n);
            n.setNext(head);
            head = n;
            loading();//установка индексов
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
        loading();
    }
    private void loading(){
        Iterator<Node> it = iterator();
        int index = 0;
        while(it.hasNext()){
            Node p = it.next();
            p.setIndex(index);
            index++;
        }
    }
    public void addValueToTail(int value){
        Node n = new Node(value);
        //System.out.println("dick");
        if(head == null){
            n.setIndex(1);
            head = n;
            tail = head;
        }
        else{
            tail.setNext(n);
            n.setPrev(tail);
            n.setIndex(tail.getIndex() + 1);
            tail = n;
        }
    }
    public void Insert(int index, int value){
        if(head == null){
            return;
        }
        else if(tail.getIndex() == index){
            Node p = new Node(value);
            p.setPrev(tail);
            tail.setNext(p);
            tail = p;
            loading();
            return;
        }
        else{
            Node curr = head;
            Node p = new Node(value);
            while(curr != null){
                if(curr.getIndex() == index){
                    Node temp = curr.getNext();
                    temp.setPrev(p);
                    p.setPrev(curr);
                    p.setNext(temp);
                    curr.setNext(p);
                    loading();
                    return;
                }
                curr = curr.getNext();
            }
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

    @Override
    public Iterator iterator() {
        return new Iter();
    }
}
