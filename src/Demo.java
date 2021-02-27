
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Проект был создан для тренировки написания односвязного и двусвязного списка
//Проект не закончен поэтому некоторые решения могут показаться странными
public class Demo {
    public static void main(String [] args){
        MyLinkedList<Integer> p = new MyLinkedList();
        p.addToHead(10);
        p.addToTail(147);
        p.addToTail(445);
        p.addToTail(255);
        for(Integer n:p){
            System.out.println(n);
        }
    }
}
