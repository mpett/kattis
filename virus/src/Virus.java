/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-07-19
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
public class Virus {
    Kattio io = new Kattio(System.in, System.out);
    String normalDNA, virusDNA;

    public static void main(String[] args) {
        new Virus();
    }

    public Virus() {
        handleInput();
        io.flush();
        System.out.println(getMinLengthChangeDNA());
    }

    int getMinLengthChangeDNA () {
        if (normalDNA.equals(virusDNA)) return 0;
        int minChange = 0;
        for (int j = 0; j < virusDNA.length() + 1; j++) {
            for (int i = 0; i < virusDNA.length() - minChange + 1; i++) {
                String subsequence = virusDNA.substring(i, i + minChange);
                System.err.print(subsequence + " ");
                if (!normalDNA.contains(subsequence)) {
                    //System.err.println(subsequence);
                    return minChange;
                }
            }
            minChange++;
        }
        return 0;
    }

    void handleInput() {
        normalDNA = io.getWord();
        virusDNA = io.getWord();
    }
}
