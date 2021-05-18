package arraySearch;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class FourthAssignment {

    private final String[] days = {
            "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
    };

    public String solution(String S, int K) {

        if(K < 0 || K > 500)
            return "-1";

        int position = getPosition(S);

        if(position == -1)
            return "-1";

        else
            return getKDaysAfter( position, K );
    }

    private int getPosition(String S){

        int position = -1;

        for (int i = 0; i < days.length; i++ )

            if (days[i].equals(S)) {

                position = i;
                break;

            }

        return position;
    }

    private String getKDaysAfter(int position, int k) {

        int daysAfter = k % 7;

        int remainingdaysInTheWeek = days.length - position;

        if (remainingdaysInTheWeek > daysAfter)
            return days[position + daysAfter];

        else
            return  days[ daysAfter - remainingdaysInTheWeek];

    }
}