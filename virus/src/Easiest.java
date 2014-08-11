/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-08-12
 * Time: 01:29
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
public class Easiest {

    Kattio io = new Kattio(System.in, System.out);
    private static ArrayList<Integer> numbers;

    public static void main(String[] args) {
        new Easiest();
    }

    public Easiest() {
        handleInput();
        multiplyAndCheckSum();
        io.close();
    }

    void multiplyAndCheckSum() {
        for(int N : numbers) {
            int p = 11;
            boolean solutionFound = false;
            while (!solutionFound) {
                int m = N * p;
                if (digitSum(N) == digitSum(m)) {
                    System.out.println(p);
                    solutionFound = true;
                }
                p++;
            }
        }
    }

    int digitSum(int number) {
        String numberString = Integer.toString(number);
        int result = 0;
        for (int charIndex = 0; charIndex < numberString.length(); charIndex++) {
            int tmp = Integer.parseInt(numberString.charAt(charIndex) + "");
            result += tmp;
        }
        return result;
    }

    void handleInput() {
        numbers = new ArrayList<Integer>();
        while (true) {
            int number = io.getInt();
            if(number == 0)
                break;
            numbers.add(number);
        }
    }
}
