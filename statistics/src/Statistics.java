import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-06-27
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public class Statistics {
    Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) {
        new Statistics();
    }

    public Statistics() {
        int caseIndex = 0;
        while(io.hasMoreTokens()) {
            caseIndex++;
            int[] sampleArray = handleInput();
            Arrays.sort(sampleArray);
            int minNum = sampleArray[0];
            int maxNum = sampleArray[sampleArray.length - 1];
            int range = maxNum - minNum;
            System.out.println("Case " + caseIndex + ": " + minNum + " " + maxNum + " " + range);
        }
    }

    int[] handleInput() {
        int numElements = io.getInt();
        int[] sampleArray = new int[numElements];
        for(int i = 0; i < numElements; i++)
            sampleArray[i] = io.getInt();
        return sampleArray;
    }

}
