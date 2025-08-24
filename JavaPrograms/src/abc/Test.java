package abc;

import common.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        int[] array= { 11,12,14,34,27};

        Arrays.stream(array).filter (number -> String.valueOf(number).startsWith("1")).forEach(System.out::println);

    }
}
