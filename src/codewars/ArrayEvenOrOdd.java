package codewars;

import java.util.stream.IntStream;

public class ArrayEvenOrOdd {

    public static String evenOrOdd ( final int[] array ) {
        int sum = IntStream.of(array)
                .sum();

        return sum % 2 == 0 ? "even" : "odd" ;
    }

    public static void main(String[] args) {
        System.out.println(evenOrOdd(new int[] {2, 3, 5, 1}));
    }
}
