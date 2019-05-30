package concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: 可重入锁（递归锁）示例
 * @author: linjh
 * @create: 2019-05-28 16:08
 **/   


class Demo implements Runnable{

    public synchronized void get(){
        System.out.println(Thread.currentThread().getName() + "\t 进入get()");
        set();
    }

    public synchronized void set(){
        System.out.println(Thread.currentThread().getName() + "\t 进入set()");
    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        getLock();
    }

    public void getLock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"\t 进入getLock()");
            setLock();
        }finally {
            lock.unlock();
        }
    }

    public void setLock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"\t 进入setLock()");
        }finally {
            lock.unlock();
        }
    }

}



public class Fair {
    public static void main(String[] args){
        Demo demo = new Demo();
        new Thread(()->{
            demo.get();
         },"t1").start();

         new Thread(()->{
             demo.get();
          },"t2").start();

        //休眠1秒
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}

        Thread thread1 = new Thread(demo,"t3");
        Thread thread2 = new Thread(demo,"t4");
        thread1.start();
        thread2.start();


    }

}
