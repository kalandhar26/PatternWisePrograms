package abc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {

       IntStream.rangeClosed(1, 100)
                .filter(PrimeNumber::isPrimeNumber)
                .boxed()
                .forEach(System.out::println);

        getBinaryValue(100);


    }

    public static boolean isPrimeNumber(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        double m = Math.sqrt(n);
        for (int i = 3; i <= m; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void getBinaryValue(int number){
        String result = "";

        while(number>0){
            int lastDigit = number % 2;
            result = String.valueOf(lastDigit)+result;
            number = number/2;
        }
        System.out.println(result);
    }
}
