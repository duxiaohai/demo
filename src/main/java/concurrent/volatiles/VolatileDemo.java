package concurrent.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description: volatile测试
 * @author: linjh
 * @create: 2019-05-24 15:56
 **/
public class VolatileDemo {

    volatile int num = 0;

    public void changeNum(){
        this.num = 60;
    }

    public static void main(String[] args){

        VolatileDemo volatileDemo = new VolatileDemo();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(3);
                volatileDemo.changeNum();
                System.out.println(Thread.currentThread().getName() + " num value:" + volatileDemo.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();


        while (volatileDemo.num == 0){

        }


        System.out.println(Thread.currentThread().getName() + " num value:" + volatileDemo.num);

    }


}
