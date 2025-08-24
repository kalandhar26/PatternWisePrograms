package amazon.array;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = {"bat", "tab", "eat", "tea", "tan", "nat"};
        List<List<String>> result = groupAnagrams(input);

        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] words){
        Map<String, List<String>> map = new LinkedHashMap<>();
        for(String word : words){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
