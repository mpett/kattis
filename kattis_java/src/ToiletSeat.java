

/**
 * Created by martinpettersson on 05/12/14.
 */
public class ToiletSeat {
    Kattio io = new Kattio(System.in);
    private final static char UP = 'U';
    private final static char DOWN = 'D';

    public static void main(String[] args) {
        new ToiletSeat();
    }

    public ToiletSeat() {
        // Some basic input handling.
        String inputString = handleInput();
        char currentSeatPosition = inputString.charAt(0);
        String peopleWaiting = inputString.substring(1);
        //System.err.println(inputString);
        System.err.println(peopleWaiting);
        int numberOfPeopleWaiting = peopleWaiting.length();
        char firstPerson = peopleWaiting.charAt(0);
        int policyOne= 0; int policyTwo = 0;
        if (currentSeatPosition == UP && firstPerson == UP)
            policyTwo++;
        else if (currentSeatPosition == UP && firstPerson == DOWN)
            policyTwo+=2;
        else if (currentSeatPosition == DOWN && firstPerson == DOWN)
            policyOne++;
        else if (currentSeatPosition == DOWN && firstPerson == UP)
            policyOne+=2;

        char preferredPosition;
        for (int person = 1; person < numberOfPeopleWaiting; person++) {
            preferredPosition = peopleWaiting.charAt(person);
            System.err.print(preferredPosition + "" + policyTwo);
            if (preferredPosition == UP) policyTwo += 2; else policyOne += 2;
        }
        System.out.println(policyOne + "\n" + policyTwo);
        // Policy Three: When you leave, always leave the seat as you would like to find it
        int policyThree = 0;
        for (int person = 0; person < numberOfPeopleWaiting; person++) {
            preferredPosition = peopleWaiting.charAt(person);
            if (currentSeatPosition != preferredPosition) {
                policyThree++;
                currentSeatPosition = preferredPosition;
            }
        }
        System.out.println(policyThree);
        // Flush io stream.
        io.close();

    }

    String handleInput() {
        return io.getWord();
    }
}
