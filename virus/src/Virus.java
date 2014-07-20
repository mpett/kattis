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
        System.out.println(getMinLengthChangeDNA());
        io.flush();

    }

    int getMinLengthChangeDNA () {


        if (normalDNA.length() >= virusDNA.length()) {
            for (int charIndex = 0; charIndex < virusDNA.length(); charIndex++) {
                if (!(normalDNA.charAt(charIndex) == virusDNA.charAt(charIndex))) {
                    normalDNA = normalDNA.substring(charIndex, normalDNA.length());
                    virusDNA = virusDNA.substring(charIndex, virusDNA.length());
                    break;
                }
            }

            int diff = normalDNA.length() - virusDNA.length();
            for (int charIndex = virusDNA.length() -1; charIndex >= 0; charIndex--) {
                if (virusDNA.charAt(charIndex) == normalDNA.charAt(charIndex + diff))
                    virusDNA = removeLastChar(virusDNA);
            }
        } else {
            for (int charIndex = 0; charIndex < normalDNA.length(); charIndex++) {
                if (!(normalDNA.charAt(charIndex) == virusDNA.charAt(charIndex))) {
                    normalDNA = normalDNA.substring(charIndex, normalDNA.length());
                    virusDNA = virusDNA.substring(charIndex, virusDNA.length());
                    break;
                }
            }
            int diff = virusDNA.length() - normalDNA.length();
            for (int charIndex = normalDNA.length() -1; charIndex >= 0; charIndex--) {
                if (virusDNA.charAt(charIndex + diff) == normalDNA.charAt(charIndex))
                    virusDNA = removeLastChar(virusDNA);
            }
        }

        return virusDNA.length();
    }

    void handleInput() {
        normalDNA = io.getWord();
        virusDNA = io.getWord();
    }

    String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
}
