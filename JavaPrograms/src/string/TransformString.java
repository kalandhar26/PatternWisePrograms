package string;

import java.util.HashMap;
import java.util.Map;

public class TransformString {

    public static void main(String[] args) {
        String s = "aabbcccdddd";
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            Character currentCharacter = s.charAt(i);
            if(!map.containsKey(currentCharacter)){
                map.put(currentCharacter,1);
            }else{
                map.put(currentCharacter, map.getOrDefault(currentCharacter,1)+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            sb.append(entry.getKey()).append(entry.getValue());
        }

        System.out.println(sb);
    }
}
