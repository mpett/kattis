/**
 * Created by martinpettersson on 05/01/15.
 */
public class Pet {
    Kattio io = new Kattio(System.in);
    private int winner = -1;
    private final int DINNERS = 4; private final int NUMBER_OF_CONTESTANTS = 5;
    public static void main(String[] args) {
        new Pet();
    }

    public Pet() {
        int[] contestantPoints = handleInput();
        int winnerPoints = maxPoints(contestantPoints);
        System.out.println((winner + 1) + " " + winnerPoints);
        io.close();
    }

    int[] handleInput() {
        int[] pointArray = new int[NUMBER_OF_CONTESTANTS];
        for (int contestant = 0; contestant < NUMBER_OF_CONTESTANTS; contestant++) {
            int point = 0;
            for (int dinner = 0; dinner < DINNERS; dinner++) {
                point += io.getInt();
            }
            pointArray[contestant] = point;
        }
        return pointArray;
    }

    int maxPoints(int[] myArray) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < myArray.length; i++) {
            if(myArray[i] > max) {
                max = myArray[i];
                winner = i;
            }
        }
        return max;
    }
}
