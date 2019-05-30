package concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: demo
 * @description: 自旋锁 示例
 * @author: linjh
 * @create: 2019-05-28 17:54
 **/
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t 进入");
        while (!atomicReference.compareAndSet(null,thread)){}
        System.out.println(thread.getName()+"\t 获得锁");
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"\t 解锁");
    }


   public  static void main(String[] args){
      SpinLockDemo spinLockDemo = new SpinLockDemo();

         new Thread(()->{
             spinLockDemo.myLock();
             //休眠1秒
             try { TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}

             spinLockDemo.myUnLock();

          },"t1").start();


          new Thread(()->{
              spinLockDemo.myLock();
              //休眠1秒
              try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
              spinLockDemo.myUnLock();
           },"t2").start();
   }

}
