/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-07-15
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Timebomb {
    String[] ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, inputStrings;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new Timebomb();
    }

    public Timebomb() {
        ZERO = new String[5];
        ZERO[0] = "*** ";
        ZERO[1] = "* * ";
        ZERO[2] = "* * ";
        ZERO[3] = "* * ";
        ZERO[4] = "*** ";

        ONE = new String[5];
        ONE[0] = "  * ";
        ONE[1] = "  * ";
        ONE[2] = "  * ";
        ONE[3] = "  * ";
        ONE[4] = "  * ";

        TWO = new String[5];
        TWO[0] = "*** ";
        TWO[1] = "  * ";
        TWO[2] = "*** ";
        TWO[3] = "*   ";
        TWO[4] = "*** ";

        THREE = new String[5];
        THREE[0] = "*** ";
        THREE[1] = "  * ";
        THREE[2] = "*** ";
        THREE[3] = "  * ";
        THREE[4] = "*** ";

        FOUR = new String[5];
        FOUR[0] = "* * ";
        FOUR[1] = "* * ";
        FOUR[2] = "*** ";
        FOUR[3] = "  * ";
        FOUR[4] = "  * ";

        FIVE = new String[5];
        FIVE[0] = "*** ";
        FIVE[1] = "*   ";
        FIVE[2] = "*** ";
        FIVE[3] = "  * ";
        FIVE[4] = "*** ";

        SIX = new String[5];
        SIX[0] = "*** ";
        SIX[1] = "*   ";
        SIX[2] = "*** ";
        SIX[3] = "* * ";
        SIX[4] = "*** ";

        SEVEN = new String[5];
        SEVEN[0] = "*** ";
        SEVEN[1] = "  * ";
        SEVEN[2] = "  * ";
        SEVEN[3] = "  * ";
        SEVEN[4] = "  * ";

        EIGHT = new String[5];
        EIGHT[0] = "*** ";
        EIGHT[1] = "* * ";
        EIGHT[2] = "*** ";
        EIGHT[3] = "* * ";
        EIGHT[4] = "*** ";

        NINE = new String[5];
        NINE[0] = "*** ";
        NINE[1] = "* * ";
        NINE[2] = "*** ";
        NINE[3] = "  * ";
        NINE[4] = "*** ";

        inputStrings = new String[5];

        int inputNumber = handleInput();

        if(inputNumber % 6 == 0)
            System.out.println("BEER!!");
        else
            System.out.println("BOOM!!");

    }

    int handleInput() {
        for(int lines = 0; lines < inputStrings.length; lines++) {
            inputStrings[lines] = input.nextLine();
        }

        int numChars = inputStrings[0].length() / 4 + 1;

        String[][] stringInputMatrices = new String[5][numChars];

        for(int i = 0; i < 5; i++) {
            stringInputMatrices[i] = splitStringEvery(inputStrings[i], 4);
        }

        for(int i = 0; i < 5; i++) {
            stringInputMatrices[i][numChars-1] += " ";
        }


        String result = "";

        for(int i = 0; i < stringInputMatrices[0].length; i++) {
            String[] tmp = new String[5];
            for (int j = 0; j < 5; j++){
                tmp[j] = stringInputMatrices[j][i];
            }

            if(Arrays.equals(tmp, ZERO)) {
                result += "0";
            }
            else if(Arrays.equals(tmp, ONE)) {
                result += "1";
            }
            else if(Arrays.equals(tmp, TWO)) {
                result += "2";
            }
            else if(Arrays.equals(tmp, THREE)) {
                result += "3";
            }
            else if(Arrays.equals(tmp, FOUR)) {
                result += "4";
            }
            else if(Arrays.equals(tmp, FIVE)) {
                result += "5";
            }
            else if(Arrays.equals(tmp, SIX)) {
                result += "6";
            }
            else if(Arrays.equals(tmp, SEVEN)) {
                result += "7";
            }
            else if(Arrays.equals(tmp, EIGHT)) {
                result += "8";
            }
            else if(Arrays.equals(tmp, NINE)) {
                result += "9";
            } else {
                result = "-1"; break;
            }
        }

        return new Integer(result);
    }

    public String[] splitStringEvery(String s, int interval) {
        int arrayLength = (int) Math.ceil(((s.length() / (double)interval)));
        String[] result = new String[arrayLength];

        int j = 0;
        int lastIndex = result.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            result[i] = s.substring(j, j + interval);
            j += interval;
        } //Add the last bit
        result[lastIndex] = s.substring(j);

        return result;
    }
}
