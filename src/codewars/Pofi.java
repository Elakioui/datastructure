package codewars;

public class Pofi {

    public static String pofiv2(int n) {
        return new String[] {"1","i","-1","-i"}[n%4];
    }

    public static String pofi(int n) {

        int sign = getTheSign(n);

        if( n % 2 == 0)
            //it's 1 to be displayed
            return sign == 1 ? "1" : "-1";
        else
            //it's i to be displayed
            return sign == 1 ? "i" : "-i";

    }

    private static int getTheSign( int n ) {

        int value = 1;
        int counter = 0;

        for (int i = 0; i <= n; i++ ){

            if(counter == 2){
                value *= -1;
                counter = 0;
            }

            counter++;
        }

        return value < 0 ? -1 : 1;
    }

    public static void main(String[] args) {
        System.out.println(pofi(10));
        System.out.println(pofiv2(10));
    }
}
