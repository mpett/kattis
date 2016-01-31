import java.util.Calendar;

/**
 * Created by martinpettersson on 28/01/16.
 */
public class Spavanac {
    Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        new Spavanac();
    }

    public Spavanac() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, io.getInt());
        calendar.set(Calendar.MINUTE, io.getInt());
        calendar.add(Calendar.MINUTE, -45);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + " " + calendar.get(Calendar.MINUTE));
    }
}
