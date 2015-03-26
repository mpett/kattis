/**
 * Created by martinpettersson on 26/03/15.
 */
public class Parking {
    private Kattio io = new Kattio(System.in, System.out);
    private int[] waitingCars; private int a, b, c;

    public static void main(String [] args) {
        new Parking();
    }

    public Parking() {
        handleInput();

        int cost = 0;
        for (int numberOfTrucks : waitingCars) {
            System.err.print(numberOfTrucks + " ");
            switch (numberOfTrucks) {
                case 1:
                    cost += a;
                    break;
                case 2:
                    cost += b;
                    break;
                case 3:
                    cost += c;
                    break;
                default:
                    break;
            }
        }
        System.out.println(cost);
        io.close();
    }

    void handleInput() {
        waitingCars = new int[100];
        a = io.getInt(); b = io.getInt(); c = io.getInt();
        for (int truck = 0; truck < 3; truck++) {
            int startTime = io.getInt() - 1; int stopTime = io.getInt() - 1;
            for (int timeIndex = startTime; timeIndex <= stopTime; timeIndex++)
                waitingCars[timeIndex]++;
        }
    }
}
