package concurrent.valuepass;

/**
 * @program: demo
 * @description: 值传递问题
 * @author: linjh
 * @create: 2019-05-28 14:15
 **/
public class ValuePassDemo {

    public void changeInt(int num){
        num = 22;
    }

    public void changeName(Person person){
       person.setName("name222");
    }

    public void changeValue(String value){
        value = "value2222";
    }

    public static void main(String[] args){
     ValuePassDemo valuePassDemo = new ValuePassDemo();
      int num = 11;
      valuePassDemo.changeInt(num);
      System.out.println("num:"+ num);

      Person person = new Person("name111");
      valuePassDemo.changeName(person);
      System.out.println("personName:"+person.getName());

      String value = "value111";
      valuePassDemo.changeValue(value);
      System.out.println("value:"+value);


    }

}
