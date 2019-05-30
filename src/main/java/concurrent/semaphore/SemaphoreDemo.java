package concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description:  Semaphore 信号量
 * @author: linjh
 * @create: 2019-05-30 16:14
 **/
public class SemaphoreDemo {
    
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3);

        for(int i = 0; i< 10; i++){
          new Thread(()->{
              try {
                  semaphore.acquire();
                  System.out.println(Thread.currentThread().getName() + "\t 抢到停车位----");
                  //休眠3秒
                  try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
                  System.out.println(Thread.currentThread().getName() + "\t 离开停车位");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }finally {
                   semaphore.release();
              }
          },String.valueOf(i)).start();
        }

    }
}
