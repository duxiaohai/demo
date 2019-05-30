package concurrent.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @program: demo
 * @description: CyclicBarrier 示例    （可循环屏障）
 * @author: linjh
 * @create: 2019-05-30 15:28
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("----召唤神龙----");
        });


        for(int i = 1; i<= 7; i++){
          final int num = i;
          new Thread(()->{
              System.out.println("第" + num + "颗龙珠被找到");
              try {
                  cyclicBarrier.await();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              } catch (BrokenBarrierException e) {
                  e.printStackTrace();
              }
          },String.valueOf(i)).start();
        }
    }
}
