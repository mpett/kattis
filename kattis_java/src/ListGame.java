public class ListGame {
    Kattio io = new Kattio(System.in, System.out);


    public static void main(String[] args) {
        new ListGame();

    }

    public ListGame() {
        // Read input and output the number of factors.
        System.out.println(score2(io.getInt()));
        io.close();
    }

    // Returns the number of factors of an integer.
    int score(int X) {
        int n = X;
        int factors = 0;
        int current = 2;
        while(n > 1) {
            if(n % current == 0) {
                n /= current;
                factors++;
            } else
                current++;
        }
        return factors;
    }
    // Returns the number of factors of an integer.
    int score2(int X) {
        int n = X;
        int factors = 0;
        int current = 2;

        for(int i = 0; i*i <= X; i++) {
            if(n % current == 0) {
                n /= current;
                factors++;
            } else
                current++;

        }
        if(n>1)
            factors++;
        return factors;
    }
}