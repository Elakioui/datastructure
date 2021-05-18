package arraySearch;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class ThirdAssignment {
    public int solution(String S) {

        int n = S.length();

        if (n < 4 || n > 12)
            return -1;

        return convertIPAdress(S);

    }

    private int convertIPAdress(String s){

        int validAddress = 0;

        int size = s.length();

        String newString = s;

        for (int i = 1; i < size - 2;
             i++) {
            for (int j = i + 1;
                 j < size - 1; j++) {
                for (int k = j + 1;
                     k < size; k++) {
                    newString
                            = newString.substring(0, k) + "."
                            + newString.substring(k);
                    newString
                            = newString.substring(0, j) + "."
                            + newString.substring(j);
                    newString
                            = newString.substring(0, i) + "."
                            + newString.substring(i);

                    if (isValid(newString)) {
                        validAddress++;
                    }

                    newString = s;
                }
            }
        }

        return validAddress;

    }
    private static boolean isValid(String ipAddress)
    {
        String a[] = ipAddress.split("[.]");

        for (String s : a) {

            int i = Integer.parseInt(s);

            if (s.length() > 3 || i < 0 || i > 255) {
                return false;
            }

            if (s.length() > 1 && i == 0)
                return false;

            if (s.length() > 1
                    && i != 0
                    && s.charAt(0) == '0')

                return false;
        }

        return true;
    }




}

