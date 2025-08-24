package amazon.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] array = {3,4,5,9,8,7,2,5,9};

        System.out.println(findDuplicates(array));
        System.out.println(findDuplicatess(array));
    }

    // already contains
    public static List<Integer> findDuplicates(int[] array){
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for(int x : array){
            if(seen.contains(x)){
                duplicates.add(x);
            }
            seen.add(x);
        }

      return  duplicates.stream().toList();
    }

    // using Streams
    public static List<Integer> findDuplicatess(int[] array){
        Map<Integer, Long> map = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        return map.entrySet().stream().filter(entry -> entry.getValue()>1).map(Map.Entry::getKey).toList();
    }
}
