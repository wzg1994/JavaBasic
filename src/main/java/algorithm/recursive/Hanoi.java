package algorithm.recursive;

/**
 * @author wangzhiguo
 */
public class Hanoi {
    //移动n层汉诺塔  从最左边移动到最右边
    public static void hanoi(int n){
        if(n <= 0) return;
        move(n, "left", "mid", "right");
    }
    public static void move(int n, String left, String mid, String right){
        if(n == 1){
            System.out.println("move from " + left + " to " + right);
            return;
        }
        move(n - 1, left, right, mid);
        move(1, left, mid, right);
        move(n - 1, mid, left, right);
    }
    public static void main(String[] args){
        hanoi( 4 );
    }
}
