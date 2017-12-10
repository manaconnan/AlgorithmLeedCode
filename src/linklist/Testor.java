package linklist;

import java.util.Iterator;

public class Testor {

    public static void main(String[] args) {
        
        LinkedIntegerList<String> list = new LinkedIntegerList<>();
        for(int i=0;i<10;i++){
            list.add("s"+i);
        }
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }


    }

}
