package concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: lock condition
 * @author: linjh
 * @create: 2019-05-31 10:57
 **/

class ShareResource {

    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5A() {
        lock.lock();
        try {
            //1.判断
            while (num != 1) {
                c1.await();
            }
            //2.工作
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() +"开始工作，次数:" + i);
            }
            //3.通知
            num = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print5B() {
        lock.lock();
        try {
            //1.判断
            while (num != 2) {
                c2.await();
            }
            //2.工作
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() +"开始工作，次数:" + i);
            }
            //3.通知
            num = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print5C() {
        lock.lock();
        try {
            //1.判断
            while (num != 3) {
                c3.await();
            }
            //2.工作
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() +"开始工作，次数:" + i);
            }
            //3.通知
            num = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SyncLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.print5A();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.print5B();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.print5C();
            }
        },"C").start();
    }
}
