package test;

/**
 * @program: demo
 * @description:
 * @author: linjh
 * @create: 2019-09-04 10:23
 **/
public class User {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    User(int age){
        this.age = age;
    }

    static void change(User user){
        user = new User(10);
    }

    public static void main(String[] args){
       User user = new User(20);
       change(user);
       System.out.println(user.getAge());
    }

}
