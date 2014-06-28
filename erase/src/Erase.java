/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-06-28
 * Time: 08:10
 * To change this template use File | Settings | File Templates.
 */
public class Erase {
    Kattio io = new Kattio(System.in, System.out);
    String beforeDel, afterDel;
    int N;

    public static void main(String[] args) {
        new Erase();
    }

    public Erase() {
        handleInput(); String result;
        if(N % 2 == 0)
            result = beforeDel.equals(afterDel) ? "Deletion succeeded" : "Deletion failed";
        else
            result = afterDel.equals(reverseBinary(beforeDel)) ? "Deletion succeeded" : "Deletion failed";
        System.out.println(result);
    }

    String reverseBinary(String binary) {
        StringBuilder builder = new StringBuilder();
        for(int character = 0; character < binary.length(); character++) {
            if(binary.charAt(character) == '0')
                builder.append('1');
            else builder.append('0');
        }
        return builder.toString();
    }

    void handleInput() {
        N = io.getInt();
        beforeDel = io.getWord();
        afterDel = io.getWord();
    }
}
 