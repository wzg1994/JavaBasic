package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangzhiguo
 */
public class ReentrantLockDemo {

    ReentrantLock lock = new ReentrantLock();

    public void test(){

        lock.lock();


    }

}
