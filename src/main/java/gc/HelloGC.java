package gc;

import java.util.UUID;

/**
 * @program: demo
 * @description:
 * @author: linjh
 * @create: 2019-06-12 10:11
 **/
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
      System.out.println("dddddd");
      //Thread.sleep(Integer.MAX_VALUE);

      /*
      * 查看改进程，某个参数是否存在
      * 1、jps -l 获取进程号
      * 2、jinfo -flag PrintGCDetails 进程号
      * */
//      System.out.println(UUID.randomUUID());
    }
}
