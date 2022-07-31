import java.lang.reflect.Array;
import java.util.*;

public class TestBuild {
    public static void main(String[] args) {
        /*
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"One");map.put(2,"Two");
        System.out.println(map);

        for (Map.Entry<Integer,String> entry: map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }*/
        List<Integer> mas = new ArrayList<>();
        mas.add(1);
        mas.add(2);
        mas.add(3);
        mas.add(4);
        mas.add(5);

        Iterator<Integer> iterator = mas.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Collections.sort(mas, new ArrayComparator());
        System.out.println(mas);
    }
}

class ArrayComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2){
            return -1;
        }else if(o1 < o2){
            return 1;
        }else{
            return 0;
        }
    }
}