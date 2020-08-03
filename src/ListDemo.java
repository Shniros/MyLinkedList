import java.util.Iterator;
//Проект был создан для тренировки написания односвязного и двусвязного списка
//Проект не закончен поэтому некоторые решения могут показаться странными
public class ListDemo {
    public static void main(String [] args){
        OnePathList p = new OnePathList();
        p.addValueToHead(10);
        p.addValueToTail(147);
        p.addValueToTail(445);
        p.addValueToTail(255);
        p.Insert(2,15);
        Iterator<Node> it = p.iterator();
        while (it.hasNext()){
            Node cur = it.next();
            System.out.println(cur.getIndex() + "|"+ cur.getValue());
        }

    }
}
