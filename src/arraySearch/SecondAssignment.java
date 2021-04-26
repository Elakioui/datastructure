package arraySearch;

import java.util.Arrays;

public class SecondAssignment {

    private SecondAssignment() {
    }

    public static int getNumberOfCars(int[] seats, int[] persons){

        Arrays.sort(seats);

        int totalOfPersons  = getPersonCount(persons);
        int numberOfCards = 0;

        for (int carSeats : seats) {

            int remainingPerson = totalOfPersons - carSeats;

            if (remainingPerson > 0)
                numberOfCards++;

            else if (remainingPerson < 0) {
                numberOfCards++;
                break;
            }
        }

        return numberOfCards;
    }

    private static int getPersonCount(int[] persons){

        int totalOfPersons = 0;

        for (int c : persons)
            totalOfPersons += c;

        return totalOfPersons;
    }
}
