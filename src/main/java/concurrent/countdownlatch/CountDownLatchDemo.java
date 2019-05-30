package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: demo
 * @description: CountDownLatch 示例
 * @author: linjh
 * @create: 2019-05-29 18:39
 **/
public class CountDownLatchDemo {
    
    public static void main(String[] args){

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for(int i = 1; i<= 6; i++){
          new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "被消灭！！");
            countDownLatch.countDown();
          },EnumDemo.forEach_CountryEnum(i).getMessage()).start();
        }

        try {
            countDownLatch.await();
            System.out.println("秦国统一");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
