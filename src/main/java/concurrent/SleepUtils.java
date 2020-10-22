package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzhiguo
 */
public class SleepUtils {

    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
