package test;

/**
 * @author wangzhiguo
 */
public class Main  {

    private static final SafeCount SAFE_COUNT = new SafeCount();

    public static void main(String[] args) throws InterruptedException {

//        for (int i = 0; i < 1000; i++) {
//            Thread thread = new Thread(() -> {
//                SAFE_COUNT.inc();
//                System.out.println(SAFE_COUNT.getI());
//            });
//            thread.start();
//        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SAFE_COUNT.inc();
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                SAFE_COUNT.getI();
            }
        }).start();

    }

//    public static void main(String[] args) {
//        Thread th1 = new Thread(new Main(), "th1");
//        Thread th2 = new Thread(new Main(), "th2");
//        Thread th3 = new Thread(new Main(), "th3");
//        Thread th4 = new Thread(new Main(), "th4");
//        th1.start();
//        th2.start();
//        th3.start();
//        th4.start();
//    }
//
//    @Override
//    public void run() {
//        SAFE_COUNT.inc();
//        int i = SAFE_COUNT.getI();
////        System.out.println(i);
//    }
}
