package codewars;

public class GrowthPopulation {
    public static int nbYear(int p0, double percent, int aug, int p) {

        int yearsCounter = 0;

        while( p0 < p){

            p0 = calculateCurrentYearPopulation( p0, percent, aug );

            yearsCounter++;

        }

        return yearsCounter;
    }

    private static int calculateCurrentYearPopulation(int p0, double percent, int aug){
        double increasedNumber =  (double) p0 * percent * 0.01 ;
        double currentYearPopulation = Math.floor(increasedNumber + (double) p0 + (double) aug);

        return (int)  currentYearPopulation;

    }

    public static void main(String[] args) {
        GrowthPopulation.nbYear(1500, 5, 100, 5000);
    }
}
