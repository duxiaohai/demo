package concurrent.lock;


import java.util.HashMap;
import java.util.Map;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: demo
 * @description: 读写锁 示例
 * @author: linjh
 * @create: 2019-05-29 17:11
 **/

class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在获取:" + key);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 获取完成:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void put(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入:" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成----------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

}


public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> {
                myCache.put(num + "", num + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> {
                myCache.get(num + "");
            }, String.valueOf(i)).start();
        }


    }


}
