import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PolygonArea {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in));
        while (true) {
            String input = reader.readLine();
            if (input.equals("0")) {
                reader.close();
                System.exit(0);
            }
            int n = Integer.parseInt(input);
            ArrayList<PolygonPoint> points = new ArrayList<>();
            for (int index = 0; index < n; index++) {
                String[] pointInput =
                        reader.readLine().split(" ");
                int x = Integer.parseInt(pointInput[0]);
                int y = Integer.parseInt(pointInput[1]);
                PolygonPoint point = new PolygonPoint(x,y);
                points.add(point);
            }
            int sum = 0;
            for (int index = 0; index < n-1; index++) {
                PolygonPoint firstPoint =
                        points.get(index);
                PolygonPoint secondPoint =
                        points.get(index+1);
                sum += firstPoint.distance(secondPoint);
            }

            PolygonPoint firstPoint
                    = points.get(0);
            PolygonPoint secondPoint
                    = points.get(n-1);
            sum += firstPoint        .distance(secondPoint);

            System.err.println("");
            double area
                    = 0.5 * Math.abs((double) sum);
            System.err.println(area);
        }
    }
}

class PolygonPoint {
    private int x;
    private int y;

    public PolygonPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int distance(PolygonPoint point) {
        int distance = (this.x * point.y)
                    - (point.x * this.y);
        System.err.println(this.x + "*" + point.y
                            + " - " + point.x + "*" + this.y);
        return distance;
    }
}