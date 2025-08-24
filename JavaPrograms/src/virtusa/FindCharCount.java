package virtusa;

import java.util.function.Function;
import java.util.stream.Collectors;

public class FindCharCount {
    public static void main(String[] args) {
        String s = "abcdkjajdasjjhgdjjdjshgjahkhkdjsahkhsadkajhhdkahashhajsdhdh @abcs #";
        s.chars().mapToObj(c -> (char) c).filter(Character::isSpaceChar).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v)->System.out.println(k+" -> "+v));
    }
}
