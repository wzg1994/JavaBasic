package concurrent;

/**
 * @author wangzhiguo
 */
public class Demo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        boolean interrupted = thread.isInterrupted();
        thread.interrupt();
    }
}
