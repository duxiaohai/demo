package test;

/**
 * @program: demo
 * @description: 测试类
 * @author: linjh
 * @create: 2019-09-04 10:20
 **/
public class Test {

    static void change(int age){
        age = 10;
    }

    public static void main(String[] args){
      int age = 20;
      change(age);
      System.out.println(age);
    }

}
