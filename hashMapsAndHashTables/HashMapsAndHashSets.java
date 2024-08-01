package hashMapsAndHashTables;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapsAndHashSets {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); // java hashmap implementation
        map.put("Rajneesh", 69);
        map.put("Sachin", 68);
        System.out.println(map.get("Rajneesh"));

        HashSet<Integer> set = new HashSet<>(); // java hashset implementation
        set.add(36);
        set.add(36);
        System.out.println(set);
    }
}
