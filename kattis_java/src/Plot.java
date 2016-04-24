/**
 * Created by martinpettersson on 28/01/16.
 */
public class Plot {
    Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        new Plot();
    }

    public Plot() {
        int[] inputVector = handleInput();
        int[] t = reverse(inputVector);
        int n = t.length;
        int[] p = new int[n];
        p[0] = t[0];
        for (int i = 1; i < n-1; i++) {
            p[i] = p[i-1] + t[1];
            for (int j = 2; j < n; j++)
                t[j-1] = t[j-1] + t[j];
        }
        for (int element : t)
            System.out.println(element);
    }

    int[] reverse(int[] validData) {
        for(int i = 0; i < validData.length / 2; i++)
        {
            int temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
        return validData;
    }

    int[] handleInput() {
        int n = io.getInt();
        int[] a_values = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            a_values[i] = io.getInt();
        return a_values;
    }
}
