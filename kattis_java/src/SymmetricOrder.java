/**
 * Created by martinpettersson on 28/01/16.
 */
public class SymmetricOrder {
    private static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int set = 1;
        while (true) {
            int n = io.getInt();
            if (n == 0) return;
            String[] symmetricNames = new String[n];
            int pivotFirst = 0; int pivotLast = n-1;
            for (int word = 0; word < n/2; word++) {
                String first = io.getWord();
                String second = io.getWord();
                symmetricNames[pivotFirst] = first;
                symmetricNames[pivotLast] = second;
                pivotFirst++; pivotLast--;
            }
            if (n % 2 != 0)
                symmetricNames[n/2] = io.getWord();
            System.out.println("SET " + set);
            for (String line : symmetricNames)
                System.out.println(line);
            set++;
        }
    }
}
