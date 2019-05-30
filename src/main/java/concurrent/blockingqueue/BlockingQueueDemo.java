package concurrent.blockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: demo
 * @description:
 * @author: linjh
 * @create: 2019-05-30 17:09
 **/
public class BlockingQueueDemo {

    public static void main(String[] args){
        BlockingQueue BlockingQueue = new LinkedBlockingQueue();//Integer.MAX_VALUE

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //1.会抛异常
        blockingQueue.add("a");
        blockingQueue.remove();
        blockingQueue.element();

        //2.不会抛异常
        blockingQueue.offer("a");
        blockingQueue.poll();
        blockingQueue.peek();

        //3.阻塞
        //blockingQueue.put("a");
        //blockingQueue.take();

        //4.超时阻塞
        //blockingQueue.offer("a",2L, TimeUnit.SECONDS);
        //blockingQueue.poll(2L,TimeUnit.SECONDS);


    }
}
