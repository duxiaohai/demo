package concurrent.countdownlatch;

/**
 * @program: demo
 * @description:
 * @author: linjh
 * @create: 2019-05-29 19:05
 **/
public enum EnumDemo {

    one(1,"赵国"),two(2,"齐国"),
    three(3,"燕国"),four(4,"楚国"),
    five(5,"魏国"),six(6,"韩国");

    private int num;
    private String message;


    public static EnumDemo forEach_CountryEnum(int num){
       EnumDemo[] enumDemos = EnumDemo.values();
        for (EnumDemo enumDemo : enumDemos) {
            if (num == enumDemo.getNum()){
                return enumDemo;
            }
        }
        return null;
    }

    public int getNum() {
        return num;
    }


    public String getMessage() {
        return message;
    }


    EnumDemo(int num, String message){
        this.num = num;
        this.message = message;
    }
}
