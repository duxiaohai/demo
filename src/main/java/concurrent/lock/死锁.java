package concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description:  死锁  并排查流程
 * @author: linjh
 * @create: 2019-06-11 16:59
 **/


class HostLock implements Runnable{
    private String lockA;
    private String lockB;

    public HostLock(String lockA,String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"获得锁lockA,尝试获得lockB");

            //休眠1秒
            try {
                TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"获得锁lockB,尝试获得lockA");

            }

        }
    }
}

public class 死锁 {
    public static void main(String[] args){
       String lockA = "lockA";
       String lockB = "lockB";

        new Thread(new HostLock(lockA,lockB),"ThreadAAA").start();
        new Thread(new HostLock(lockB,lockA),"ThreadBBB").start();


        //排查流程
        /*
        * linux  ps -ef | grep xxxx  查看进程
        *
        * windows下的java运行程序，查看相关java 进程用 jps,,  jstack 进程号，查看堆栈信息
        *
        * jps -l
        * jstack xxxx
        *
        * */

    }
    
}
