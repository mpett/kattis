/**
 * Created by martinpettersson on 10/11/14.
 */
public class TrainPassengers {
    Kattio io = new Kattio(System.in);
    private static int totalCapacity, numberOfStations;

    public static void main(String[] args) {
        new TrainPassengers();
    }

    public TrainPassengers() {
        String result = consistentInput() ? "possible" : "impossible";
        System.out.println(result);
        io.close();
    }

    boolean consistentInput() {
        totalCapacity = io.getInt(); numberOfStations = io.getInt();
        int currentCapacity = 0;
        int numLeftTrain, numEnteredTrain, numWaited = 0;
        for (int station = 0; station < numberOfStations; station++) {
            numLeftTrain = io.getInt(); numEnteredTrain = io.getInt();
            numWaited = io.getInt();
            currentCapacity -= numLeftTrain;
            currentCapacity += numEnteredTrain;
            if (currentCapacity < 0
                || (currentCapacity < totalCapacity && numWaited > 0)
                || (station == numberOfStations - 1 && (numWaited > 0 || currentCapacity > 0)) )
                return false;

        }
        return true;
    }

}
