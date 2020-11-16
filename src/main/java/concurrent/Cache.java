package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangzhiguo
 */
public class Cache {

    static Map<String, Object> map = new HashMap<>();

    static ReentrantReadWriteLock wrl = new ReentrantReadWriteLock();

    static Lock r = wrl.readLock();

    static Lock w = wrl.writeLock();

    public static Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

}
