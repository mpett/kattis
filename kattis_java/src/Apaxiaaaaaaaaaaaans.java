import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apaxiaaaaaaaaaaaans {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));
        StringBuilder stringBuilder
                = new StringBuilder();
        stringBuilder.append(reader.readLine());
        while (true) {
            int tmp = 0;
            for (int index = 1;
                 index < stringBuilder.length();
                 index++) {
                if (stringBuilder.charAt(index)
                        == stringBuilder.charAt(index-1)) {
                    stringBuilder.deleteCharAt(index);
                    break;
                }
                tmp = index;
            }
            if (tmp == stringBuilder.length()-1)
                break;
        }
        System.out.println(stringBuilder);
    }
}
