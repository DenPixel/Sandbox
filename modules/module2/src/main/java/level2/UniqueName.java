package level2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class UniqueName {

    public String getUniqueName(Collection<String> names){

       return names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new,
                        Collectors.summingInt(s -> 1)
                ))
                .entrySet()
                .stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .get()
                .getKey();

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
