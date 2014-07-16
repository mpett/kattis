/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-07-16
 * Time: 12:09
 * To change this template use File | Settings | File Templates.
 */
import java.lang.StringBuilder;
public class Doorman {
    Kattio io = new Kattio(System.in, System.out);
    String clubLine; int maxDifference;
    final static char WOMAN = 'W';

    public static void main(String[] args) {
        new Doorman();
    }

    public Doorman() {
        handleInput();
        System.err.println("Max Diff: " + maxDifference + "\nLine: " + clubLine);
        boolean brunoHasControl = true; int currentDifference= 0; int peopleInClub = 0;
        int numWomen = 0; int numMen = 0;
        char firstPersonInLine = clubLine.charAt(0);
        if (firstPersonInLine == WOMAN) numWomen++; else numMen++;
        peopleInClub++;
        clubLine = clubLine.substring(1);
        System.err.println("FIRST PERSON CHOSEN + " + clubLine);

        while (brunoHasControl) {
            if(clubLine.length() == 1) {
                firstPersonInLine = clubLine.charAt(0);
                if (firstPersonInLine == WOMAN) numWomen++; else numMen++;
                currentDifference = Math.abs(numWomen - numMen);
                if (currentDifference > maxDifference) {
                    brunoHasControl = false; continue;
                }

                else {
                    peopleInClub++;
                    brunoHasControl = false;
                    continue;
                }
            }
            firstPersonInLine = clubLine.charAt(0);
            char secondPersonInLine = clubLine.charAt(1);

            if (firstPersonInLine == WOMAN) numWomen++; else numMen++;
            currentDifference = Math.abs(numWomen - numMen);
            if (currentDifference > maxDifference) {
                if (firstPersonInLine == WOMAN) numWomen--; else numMen--;
                if (secondPersonInLine == WOMAN) numWomen++; else numMen++;
                currentDifference = Math.abs(numWomen - numMen);
                if (currentDifference > maxDifference)
                    brunoHasControl = false;
                else {
                    peopleInClub++; clubLine = clubLine.substring(2);
                    StringBuilder sb = new StringBuilder(clubLine);
                    sb.insert(0, firstPersonInLine);
                    clubLine = sb.toString();
                    System.err.println("SECOND PERSON CHOSEN + " + clubLine);
                }
            } else {
                peopleInClub++;
                clubLine = clubLine.substring(1);
                System.err.println("FIRST PERSON CHOSEN + " + clubLine);
            }
            System.err.println("CurrDiff " + currentDifference);
        }

        System.out.println(peopleInClub);
    }

    void handleInput() {
        maxDifference = io.getInt();
        clubLine = io.getWord();
        //StringBuilder sb  = new StringBuilder(clubLine).reverse();
        //clubLine = sb.toString();
    }
}
