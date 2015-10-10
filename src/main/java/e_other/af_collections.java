package e_other;

import java.util.*;

class CollectionMethods {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(Arrays.asList(3, 2, 1, 2, 5));
        ints.forEach(System.out::println);
        System.out.println("---");
        System.out.println(ints.removeIf(x -> x < 2));
        System.out.println(ints);
        System.out.println("---");
        ints.sort(Integer::compare);
        System.out.println(ints);
        ints.replaceAll(x -> x == 2 ? 4 : x);
        System.out.println(ints);
        System.out.println("---");
        Iterator it = ints.iterator();
        it.next();
        it.next();
        it.forEachRemaining(System.out::println);
        System.out.println("---");
        Map<String, Integer> map = new HashMap<>();
        map.computeIfAbsent("c1", x -> 1);
        System.out.println(map);
        map.compute("c1", (key, oldValue) -> oldValue * 2);
        System.out.println(map);
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("---");
        map.remove("c1", 1);
        System.out.println(map);
        map.remove("c1", 2);
        System.out.println(map);
    }
}
