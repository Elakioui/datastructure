package codewars;

import java.util.stream.IntStream;

public class PowerOfTwo {

    public static long[] getV2( int n ) {
        return IntStream.range(0, n + 1)
                 .mapToLong( i -> (long) Math.pow(2, i))
                 .toArray();
    }

    public static long[] get( int n ) {
        long[] result = new long[ n + 1];

        for (int i = 0; i < result.length ; i++)
            result[i] = (long) Math.pow(2, i);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(get(0)[0]);
        System.out.println(getV2(0)[0]);
    }
}
