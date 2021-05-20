package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintingArray {

    public static String printStream(Stream<?> stream) {

        return stream.map(Object::toString)
                     .collect(Collectors.joining(",")) ;
    }

    public static String printArray(int[] array){
        return printStream(IntStream.range(0, array.length).boxed());
    }

    public static String printArray(float[] array){
        return printStream(IntStream.range(0, array.length).mapToObj( i -> array[i]));
    }

    public static String printArray(double[] array){
        return printStream(IntStream.range(0, array.length).mapToObj( i -> array[i]));
    }

    public static String printArray(short[] array){
        return printStream(IntStream.range(0, array.length).mapToObj( i -> array[i]));
    }

    public static String printArray(long[] array){
        return printStream(IntStream.range(0, array.length).mapToObj( i -> array[i]));
    }

    public static String printArray(Object[] array){

        Stream<Object> stream = Arrays.stream(array);

        return printStream(stream);
    }



    public static void main(String[] args) {
        System.out.println(printArray(new int[]{1, 2, 3}));
        System.out.println(printArray(new double[]{10, 20, 30}));
        System.out.println(printArray(new float[]{10.2f, 20.3f, 30.4f}));
        System.out.println(printArray(new Object[]{new String("Test1"), new String("Test2")}));
    }
}
