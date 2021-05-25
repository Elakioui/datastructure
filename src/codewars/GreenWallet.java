package codewars;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GreenWallet {

    public static int[] makeValley(int[] arr) {

        return checkAndSort(arr, getTheBottomIndex(arr), isEven(arr));
    }

    private static boolean isEven(int[] arr){
        return arr.length % 2 == 0;
    }

    private static int getTheBottomIndex(int[] arr) {
        return (arr.length -1)  / 2;
    }

    private static int[] checkAndSort(int[] arr, int bottomIndex, boolean isEven) {

        if ( isEven )
            return sortEvenArray(arr, bottomIndex);
        else
            return sortOddArray(arr, bottomIndex);

    }

    private static int[] sortEvenArray(int[] arr, int bottomIndex) {

        int[] leftSideSorted = sort(arr, 0, bottomIndex, false);
        return sort(
                leftSideSorted,
                bottomIndex + 1,
                (leftSideSorted.length - (bottomIndex + 1) + 1),
                true
        );

    }

    private static int[] sortOddArray(int[] arr, int bottomIndex) {

        int[] leftSideArray = sort(arr, 0, bottomIndex - 1, false);
        return sort(
                leftSideArray,
                bottomIndex,
                (leftSideArray.length - (bottomIndex) + 1),
                true
        );

    }

    private static int[] sort(int[] arr, int start, int numberOfElements, boolean asc) {
        Stream<Integer> numbers= IntStream.of(arr)
                .boxed();

        numbers = (asc == true) ? numbers.sorted() : numbers.sorted(Comparator.reverseOrder());

        return numbers.skip(start)
                .limit(numberOfElements)
                .mapToInt( i -> i)
                .toArray();
    }


    public static void main(String[] args) {
        int[] result = makeValley(new int[] { 17, 17, 15, 14, 8, 7, 7, 5, 4, 4, 1 });

        IntStream.of(result)
                  .forEach( n -> System.out.println(n));
    }
}
