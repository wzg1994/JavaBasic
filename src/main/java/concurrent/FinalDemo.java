package concurrent;

/**
 * @author wangzhiguo
 */
public class FinalDemo {

    int i;

    final int j;

    static FinalDemo obj;

    public static void writer() {
        obj = new FinalDemo();
    }

    public static void reader() {
        FinalDemo object = obj;
        int a = obj.i;
        int b = obj.j;
    }

    public FinalDemo() {
        i = 1;
        j = 2;
    }
}
