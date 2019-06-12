package concurrent;

import jnr.ffi.annotations.In;
import org.python.modules.thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description:  Callable 返回值  示例
 * @author: linjh
 * @create: 2019-05-31 14:20
 **/

class FutureTakeCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        //休眠1秒
        try {
            TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}

        return 122;
    }
}

public class CallableDemo {
   public static void main(String[] args) throws ExecutionException, InterruptedException {
       FutureTask<Integer> futureTask = new FutureTask<Integer>(new FutureTakeCallable());
       new Thread(futureTask,"t1").start();

       int num = futureTask.get();
       System.out.println("num:"+num);

   }
}
