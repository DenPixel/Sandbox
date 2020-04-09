package level2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class UniqueName {

    public String getUniqueName(Collection<String> names){


//        String s1 = new HashSet<>(names)
//                .stream()
//                .findFirst()
//                .get();
//
//        return s1;

        return names.stream()
                .collect(Collectors.groupingBy(
                        s -> s,
                        HashMap::new,
                        Collectors.summingInt(s -> 1))
                ).entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        TreeMap::new,
                        mapping(Map.Entry::getKey,
                                toList())
                )).firstEntry()
                .getValue()
                .get(0);
    }

    public static void main(String[] args) {
        UniqueName un = new UniqueName();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");

        System.out.println(un.getUniqueName(list));

    }
}
