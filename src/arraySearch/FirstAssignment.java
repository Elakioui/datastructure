package arraySearch;

public class FirstAssignment {

    private static final String[] days = {"Mon", "Tue", "Wed", "Thursd", "Fri", "Sat", "Sun"};

    private FirstAssignment() {
    }

    public static String search(String day, int k){

        int position = -1;

        for (int i = 0; i < days.length; i++ )
            if (days[i].equals(day)) {
                position = i;
                break;
            }

        if (position == -1)
            throw new IllegalArgumentException("Argument not valid");

        return getKDaysAfter( position, k );
    }

    private static String getKDaysAfter(int position, int k) {

        int daysAfter = k % 7;

        int remainingdaysInTheWeek = days.length - position;

        if (remainingdaysInTheWeek > daysAfter)
            return days[position + daysAfter];

        else
            return  days[ daysAfter - remainingdaysInTheWeek];

    }
}
