class Coordinate {
    double x; double y; double z;
    double distance;
}

public class Aquarium {
    Kattio io = new Kattio(System.in, System.out);
    Coordinate[] coordinates;
    int numberOfCoordinates;

    public static void main(String[] args) {
        new Aquarium();
    }

    public Aquarium() {
        handleInput();
        calculateDistance();
        System.out.printf("%1$.2f", outputTotalDistance());
        io.close();
    }

    void handleInput() {
        numberOfCoordinates = io.getInt();
        coordinates = new Coordinate[numberOfCoordinates];
        for(int i = 0; i < numberOfCoordinates; i++) {
            coordinates[i] = new Coordinate();
            coordinates[i].x = io.getDouble();
            coordinates[i].y = io.getDouble();
            coordinates[i].z = io.getDouble();
        }
    }

    void calculateDistance() {
        for(int i = 1; i < numberOfCoordinates; i++) {
            coordinates[i].distance = Math.sqrt( ((coordinates[i-1].x - coordinates[i].x) * (coordinates[i-1].x - coordinates[i].x)) +
                    ((coordinates[i-1].y - coordinates[i].y) * (coordinates[i-1].y - coordinates[i].y)) +
                    ((coordinates[i-1].z - coordinates[i].z) * (coordinates[i-1].z - coordinates[i].z)) );
        }
    }

    double outputTotalDistance() {
        double totalDistance = 0;
        for(int i = 1; i < numberOfCoordinates; i++) {
            totalDistance += coordinates[i].distance;
        }
        return totalDistance;
    }
}