package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangzhiguo
 */
public class JoinCountDownLatchTest {

//    public static void main(String[] args) throws InterruptedException {
//
//        Thread thread1 = new Thread(() -> {
//            System.out.println("do something..");
//        });
//
//        Thread thread2 = new Thread(() -> {
//            System.out.println("do something..");
//        });
//
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println("all finished");
//    }

    static CountDownLatch c = new CountDownLatch(2);

    //使用CountDownLatch可以达到同样的效果
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("do something..");
            c.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("do something..");
            c.countDown();
        }).start();

        c.await();
        System.out.println("all finished");
    }
}
