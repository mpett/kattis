import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class VariableArithmetic {
    private static HashMap<String, Integer> definitions;
    private static final String ADDITION_OPERATOR = "+";
    private static final String EQUALITY_OPERATOR = "=";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        definitions = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line.equals("0")) {
                reader.close();
                System.exit(0);
            }
            String[] splitInput = line.split(" ");
            int numericSum = 0;

            if (splitInput.length == 3) {
                System.err.println("lol");
                if (isNumeric(splitInput[0])
                        && splitInput[1].equals(ADDITION_OPERATOR)) {
                    numericSum += Integer.parseInt(splitInput[0]);
                    sb.append(numericSum);
                    sb.append("\n");
                    numericSum = 0;
                } else if (splitInput[1].equals(EQUALITY_OPERATOR)) {
                    definitions.put(splitInput[0], Integer.parseInt(splitInput[2]));
                }
            } else {
                System.err.println("lol2");
                for (int index = 1; index < splitInput.length-1; index += 2) {
                    if (splitInput[index].equals(ADDITION_OPERATOR)) {
                        if (isNumeric(splitInput[index-1])) {
                            numericSum += Integer.parseInt(splitInput[index-1]);
                        }
                        if (isNumeric(splitInput[index+1])) {
                            numericSum += Integer.parseInt(splitInput[index+1]);
                        }
                        if (!isNumeric(splitInput[index-1])) {
                            if (definitions.containsKey(splitInput[index-1])) {
                                numericSum += definitions.get(splitInput[index-1]);
                            } else {
                                sb.append(splitInput[index-1] + " + ");
                            }
                        }
                        if (!isNumeric(splitInput[index+1])) {
                            if (definitions.containsKey(splitInput[index+1])) {
                                numericSum += definitions.get(splitInput[index+1]);
                            } else {
                                sb.append(splitInput[index+1] + " + ");
                            }
                        }
                    }
                }
                sb.append(numericSum);
                sb.append("\n");
            }
            System.out.println();
            System.out.println(sb);
        }


    }

    private static boolean isNumeric(String str)
    {
        try {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
