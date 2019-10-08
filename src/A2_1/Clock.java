package A2_1;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Clock {
    private static SimpleDateFormat timeFormatter =
            new SimpleDateFormat("kk:mm:ss");
    private static SimpleDateFormat dateFormatter =
            new SimpleDateFormat("dd.MM.YYYY");
    private static Date d = new Date();

    public static String date() {
        d.setTime(System.currentTimeMillis());
        return dateFormatter.format(d);
    }

    public static String time() {
        d.setTime(System.currentTimeMillis());
        return timeFormatter.format(d);
    }
}

