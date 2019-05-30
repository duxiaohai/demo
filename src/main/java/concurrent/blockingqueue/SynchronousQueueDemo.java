package concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description:
 * @author: linjh
 * @create: 2019-05-30 17:59
 **/
public class SynchronousQueueDemo {
    
    public static void main(String[] args){
        BlockingQueue synchronousQueue = new SynchronousQueue();

         new Thread(()->{
             try {
                 synchronousQueue.put("1");
                 System.out.println(Thread.currentThread().getName() + "\t put 1");
                 synchronousQueue.put("2");
                 System.out.println(Thread.currentThread().getName() + "\t put 2");
                 synchronousQueue.put("3");
                 System.out.println(Thread.currentThread().getName() + "\t put 3");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }).start();


          new Thread(()->{
              try {
                  //休眠2秒
                  try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
                  synchronousQueue.take();

                  //休眠2秒
                  try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
                  synchronousQueue.take();

                  //休眠2秒
                  try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
                  synchronousQueue.take();

              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }).start();
    }
}
