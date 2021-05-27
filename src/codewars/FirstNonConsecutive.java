package codewars;

import java.util.stream.IntStream;

public class FirstNonConsecutive {

    public static Integer firstNonConsecutive(final int[] array) {

        return IntStream.range( 1, array.length)
                .filter( i -> array[ i - 1 ] != array[ i ] - 1)
                .mapToObj( i -> array[i])
                .findFirst()
                .orElse(null);

    }

    public static void main(String[] args) {
        System.out.println(firstNonConsecutive(new int[] { 1, 2, 3, 5, 6}));
    }
}
