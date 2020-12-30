package test;

/**
 * @author wangzhiguo
 */
public class SafeCount {

    private int i = 0;

    public synchronized int getI() {
        System.out.println(Thread.currentThread().getName() + " -> get...");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(i);
        return i;
    }

    public synchronized void inc() {
        System.out.println(Thread.currentThread().getName() + " -> inc...");
        i++;
//        System.out.println(Thread.currentThread().getName() + " -> inc sleep...");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + " -> inc end...");
//        System.out.println(getI());
    }
}
