package level2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class UniqueName {

    public String getUniqueName(Collection<String> names){
//        Map<String, Integer> frequency = new HashMap<>();
//
//        for (String name : names) {
//            frequency.merge(name, 1, Integer::sum);
//        }
//
//        Optional<Integer> min = frequency.values().stream().min(Integer::compareTo);
//
//        HashMap<String, Long> collect = names.stream()
//                .collect(Collectors.groupingBy(
//                        s -> s,
//                        HashMap::new,
//                        Collectors.summingInt(s -> 1))
//                );
//
//        frequency.entrySet().stream()
//                .filter(e -> e.getValue());
//        TreeMap<Integer, List<String>> collect1 =
//
//        return frequency.entrySet()
//                .stream()
//                .collect(Collectors.groupingBy(
//                        Map.Entry::getValue,
//                        TreeMap::new,
//                        mapping(Map.Entry::getKey,
//                                toList())
//                )).firstEntry()
//                .getValue()
//                .get(0);

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
