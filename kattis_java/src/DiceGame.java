import java.util.ArrayList;

/**
 * Solution for Kattis problem-id: dicegame
 * https://open.kattis.com/problems/dicegame
 *
 * Author: Martin Pettersson
 */
public class DiceGame {
    Kattio io = new Kattio(System.in);
    private static int gunnar, emma;

    public static void main(String[] args)  {
        new DiceGame();
    }

    public DiceGame()  {
        // Handle the input from stdin and determine the most probable winner by
        // comparing their dice sum.
        handleInput(); printWinner();
        // Flush io.
        io.flush();
    }

    void printWinner() {
        if (emma > gunnar) System.out.println("Emma");
        else if (gunnar > emma) System.out.println("Gunnar");
        else System.out.println("Tie");
    }

    void handleInput() {
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        while (io.hasMoreTokens())
            numberList.add(io.getInt());
        int listSize = numberList.size();
        for (int numberIndex = 0; numberIndex < listSize / 2; numberIndex++)
            gunnar += numberList.get(numberIndex);
        for (int numberIndex = listSize / 2; numberIndex < listSize; numberIndex++)
            emma += numberList.get(numberIndex);
    }
}
