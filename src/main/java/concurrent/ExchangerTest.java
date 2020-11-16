package concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzhiguo
 */
public class ExchangerTest {

    private static final Exchanger<String> EXCHANGER = new Exchanger<>();

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            String A = "A数据";
            try {
                EXCHANGER.exchange(A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            String B = "A数据";
            try {
                String A = EXCHANGER.exchange(B);
                System.out.println("是否一致：" + A.equals(B) + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.shutdown();
    }
}
