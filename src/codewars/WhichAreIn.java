package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2){

        return Arrays.stream(array1)
              .filter( s -> Arrays.stream(array2).anyMatch( value -> value.contains(s)))
              .distinct()
              .sorted()
              .toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(
                WhichAreIn.inArray(
                        new String[]{"test1", "test2"},
                        new String[]{"atest1", "btest2", "ctest3"})
                        .length
        );
    }
}
