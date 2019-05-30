package concurrent.valuepass;

/**
 * @program: demo
 * @description:
 * @author: linjh
 * @create: 2019-05-28 14:17
 **/
public class Person {
   int age;
   String name;

   public Person(String name){
       this.name = name;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
