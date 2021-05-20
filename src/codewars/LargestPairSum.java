package codewars;

import java.util.Comparator;
import java.util.stream.IntStream;

public class LargestPairSum {

    public static int getLargestPairSum( int [] numbers) {
        return IntStream.of(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum();

    }

    public static void main(String[] args) {
        int [] numbers = {1, 12, 13, 14};

        System.out.println(getLargestPairSum( numbers ) );
    }
}
