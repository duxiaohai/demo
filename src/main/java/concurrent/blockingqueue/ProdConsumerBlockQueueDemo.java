package concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: demo
 * @description: 生产消费  阻塞队列版
 * @author: linjh
 * @create: 2019-05-31 11:57
 **/

class MyResource{

    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<Object> blockingQueue = null;

    public MyResource(BlockingQueue<Object> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProduce() throws Exception {
          String data = null;
          boolean result;
          while (FLAG){
              data = atomicInteger.incrementAndGet() + "";
              result = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
              if (result){
                  System.out.println(Thread.currentThread().getName() + "\t 添加队列成功:"+data);
              }else {
                  System.out.println(Thread.currentThread().getName() + "\t 添加队列失败");
              }
              //休眠1秒
              try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
          }

          System.out.println("生产者添加队列暂停----");
    }

    public void myConsumer() throws Exception {
        Object result = null;
        while (FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (result == null || result.equals("")){
                System.out.println(Thread.currentThread().getName()+ "消费者获取数据失败，退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+ "消费者消费队列:"+result);
        }

        System.out.println(Thread.currentThread().getName()+"消费者停止消费数据-------");
    }

    public void stop(){
        this.FLAG = false;
    }

}


public class ProdConsumerBlockQueueDemo {
      public static void main(String[] args){
          MyResource myResource = new MyResource(new ArrayBlockingQueue<>(3));
          new Thread(()->{
              try {
                  myResource.myProduce();
              } catch (Exception e) {
                  e.printStackTrace();
              }
          },"A").start();


          new Thread(()->{
              try {
                  myResource.myConsumer();
              } catch (Exception e) {
                  e.printStackTrace();
              }
          },"B").start();

          //休眠1秒
          try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
          myResource.stop();
          System.out.println("main:消费停止----------------");

      }

}
