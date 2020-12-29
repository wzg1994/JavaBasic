package test;

/**
 * @author wangzhiguo
 */
public class SafeCount {

    private int i;

    public synchronized int getI() {
        System.out.println(Thread.currentThread().getName() + " -> get...");
//        System.out.println(i);
        return i;
    }

    public synchronized void inc() {
        System.out.println(Thread.currentThread().getName() + " -> inc...");
        i++;
//        System.out.println(getI());
    }
}
