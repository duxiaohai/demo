package threadPool;

import java.util.concurrent.*;

/**
 * @program: demo
 * @description: 线程池
 * @author: linjh
 * @create: 2019-05-31 15:11
 **/
public class MyThreadPoolDemo {
    public static void main(String[] args){
       bb();
    }


    //自定义线程池(线程配置策略)
    public static void bb(){
        //cpu核数
        Runtime.getRuntime().availableProcessors();


        ExecutorService pools = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i <20 ; i++) {
                final int a = i;
                pools.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "-----"+a);
                });
            }
        } catch (Exception e){
           e.printStackTrace();
        }finally {
            pools.shutdown();
        }
    }





    //JDK 自带线程池
    public void aa(){
        // cpu核数
        // System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1线程
        //ExecutorService threadPool = Executors.newCachedThreadPool();//一池N线程


        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 执行操作");
                });
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
