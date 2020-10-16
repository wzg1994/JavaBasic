package concurrent;

/**
 * @author wangzhiguo
 */
public class MonitorDemo {

    int a = 0;

    public synchronized void writer() {
        a++;
    }

    public synchronized void reader() {
        int i = a;
        //...
    }
}
