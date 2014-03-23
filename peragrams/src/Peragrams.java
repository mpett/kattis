
public class Peragrams {
    Kattio io = new Kattio(System.in, System.out);
    String inputString;
    boolean peragramFound = false;

    public static void main(String[] args) {
        new Peragrams();
    }

    public Peragrams() {
        handleInput();
     //   System.err.println(possiblePalindrome(inputString));
        for(int i = 0; i < inputString.length(); i++) {
            String test = inputString.substring(0, inputString.length()-i);
            boolean pp = possiblePalindrome(test);

            if(!pp) continue;
            permutation(test);
            if(peragramFound) {
                System.out.println(i);
                break;
            }
        }
        io.close();
    }

    boolean possiblePalindrome(String str) {

        char character = 'a';
        int[] alph = new int[26];
        for(int j = 0; j < 26; j++) {
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == character)
                    alph[j]++;
            }
            character++;
        }
        int unique = 0;
        boolean valFound = false;
        int val = 0;
        int zeroes = 0;
      //  for(int i : alph) {
     //       System.err.print(i + " ");
     //   }
        for(int i : alph) {
            if(unique > 1) return false;

            if(i==1) {
                unique++;
                continue;
            }

            if(i > 1 && !valFound) {
                val = i;
                valFound = true;
                continue;
            }

            if(i > 1 && valFound) {
                if(i == val)
                    continue;
                else return false;
            }
        }
        return true;
    }

    void handleInput() {
        inputString = io.getWord();
    }

    void permutation(String str) {
       if(peragramFound) return;
       permutation("", str);
    }

    void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            if(new StringBuilder(prefix).reverse().toString().equals(prefix)) {
                peragramFound = true;
                return;
            }
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}