package codewars;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GreenWallet {

    public static int[] makeValley(int[] arr) {

        /**
                - the minimum is in the middle
                - all elements left of the middle are decreasing
                - all elements right of the middle are increasing
                - if there is an even number of elements, the left hand side should have more elements
                - if we define `a[-i]` as `a[a.length - i - 1]`, i.e. the `i`th element from the end, then `a[i] >= a[-i]` has to hold. In other words if you go from both sides to the middle, the elements on the left hand side have to be greater or equal to their right counterpart
                - the difference between both sides must be minimal
         **/

        return checkAndSort(arr, getTheBottomIndex(arr), isEven(arr));
    }

    private static boolean isEven(int[] arr){
        return arr.length % 2 == 0;
    }

    private static int getTheBottomIndex(int[] arr) {
        return arr.length / 2;
    }

    private static int[] checkAndSort(int[] arr, int bottomIndex, boolean isEven) {

        if ( isEven )
            return sortEvenArray(arr, bottomIndex);
        else
            return sortOddArray(arr, bottomIndex);

    }

    private static int[] sortEvenArray(int[] arr, int bottomIndex) {


        int[] leftSide = sort(arr, 0, bottomIndex, false);
        int[] rightSide = sort(
                                arr,
                                bottomIndex,
                                (arr.length - bottomIndex + 1),
                                true
                            );

        return IntStream.concat(
                IntStream.of(leftSide), IntStream.of(rightSide)
                )
                .toArray();
    }

    private static int[] sortOddArray(int[] arr, int bottomIndex) {

        int[] leftSide = sort(arr, 0, bottomIndex, false);
        int[] rightSide = sort(
                arr,
                bottomIndex + 1,
                (arr.length - (bottomIndex) + 1),
                true
        );

        return IntStream.concat(
                    IntStream.of(leftSide), IntStream.of(rightSide)
                )
                .toArray();

    }

    private static int[] sort(int[] arr, int start, int numberOfElements, boolean asc) {

        Stream<Integer> numbers = IntStream.of(arr)
                                            .boxed();

        numbers = (start == 0 ) ? numbers.limit(numberOfElements) : numbers.skip(start).limit(numberOfElements) ;

        numbers = (asc == true) ? numbers.sorted() : numbers.sorted(Comparator.reverseOrder());

        return numbers.mapToInt( i -> i).toArray() ;
    }


    public static void main(String[] args) {
        int[] result = makeValley(new int[] { 79, 35, 54, 19, 35, 25 });

        IntStream.of(result)
                  .forEach( n -> System.out.println(n));
    }
}
