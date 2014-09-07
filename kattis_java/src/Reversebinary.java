public class Reversebinary {
    Kattio io;
    long inputInteger, outInteger;
    String binary, reverseBinary;

    public Reversebinary() {
        io = new Kattio(System.in, System.out);
        inputInteger = io.getInt();
        binary = Long.toBinaryString(inputInteger);
        StringBuffer buffer = new StringBuffer(binary);
        buffer = buffer.reverse();
        reverseBinary = buffer.toString();
        outInteger = Long.parseLong(reverseBinary, 2);
        io.println(outInteger);
        io.close();
    }

    public static void main(String[] args) {
        new Reversebinary();
    }
}