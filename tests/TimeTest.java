import java.util.TimeZone;

public class TimeTest {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.country"));
        System.out.println(System.getProperty("user.language"));
        System.out.println(TimeZone.getDefault());
    }
}
