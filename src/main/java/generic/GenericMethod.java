package generic;

/**
 *
 * 泛型方法
 * @author wangzhiguo
 */
public class GenericMethod {

    public <T> void method1(T a, T b) {
        System.out.println("a " + a);
        System.out.println("b " + b);
    }

    public static <T> void method2(T a, T b) {
        System.out.println("a " + a);
        System.out.println("b " + b);
    }

    public static <T extends Comparable<T>> T getMin(T a, T b) {
        return (a.compareTo(b) < 0) ? a : b;
    }

}
