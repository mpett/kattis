/**
 * Created by martinpettersson on 07/12/14.
 */
public class Heliocentric {
    Kattio io = new Kattio(System.in);
    static int earthDay, marsDay;
    final static int NEW_YEAR_EARTH = 365; final static int NEW_YEAR_MARS = 687;
    final static int FIRST_DAY_OF_YEAR = 0;
    public static void main(String[] args) {
        new Heliocentric();
    }

    public Heliocentric() {
        int caseNumber = 1;
        while (io.hasMoreTokens()) {
            handleInput();
            System.out.println("Case " + caseNumber + ": " + findMatchingDay());
            caseNumber++;
        }
        io.close();
    }

    int findMatchingDay() {
        int totalNumberOfDays = 0;
        while (true) {
            if (marsDay == FIRST_DAY_OF_YEAR && earthDay == FIRST_DAY_OF_YEAR)
                break;
            earthDay++; marsDay++; totalNumberOfDays++;
            if (earthDay == NEW_YEAR_EARTH)
                earthDay = FIRST_DAY_OF_YEAR;
            if (marsDay == NEW_YEAR_MARS)
                marsDay = FIRST_DAY_OF_YEAR;
        }
        return totalNumberOfDays;
    }

    void handleInput() {
        earthDay = io.getInt(); marsDay = io.getInt();
    }
}
