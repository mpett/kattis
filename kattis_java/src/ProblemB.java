import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemB {

    public static void main(String[] args) throws IOException {
        validate();
    }

    private static void validate()
            throws IOException {
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader
                                (System.in));
        String s;
        while (!(s = in.readLine()).equals("0")) {
            int numberOfFiles = Integer.parseInt(s);
            byte[] outputs = new byte[numberOfFiles];
            for (int file = 0; file < numberOfFiles; file++) {
                String inputFile = in.readLine();
                System.err.println(inputFile);
                byte[] inputBytes = inputFile.getBytes();
                byte outputByte = inputBytes[0];
                for (int i = 1; i < inputBytes.length; i++) {
                    int a = (int) outputByte;
                    int b = (int) inputBytes[i];
                    byte xor = (byte) (a ^ b);
                    outputByte = (byte)(0xff & xor);
                }
                System.err.println("----");
                outputs[file] = outputByte;
            }
            for (byte b : outputs) {
                for (byte a : outputs) {
                    if (a == b) {
                        System.err.println("lol");
                    } else
                        System.err.println("false");
                }

            }
            System.err.println("---");
        }
    }
}
