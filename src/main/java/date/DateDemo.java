package date;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: demo
 * @description:
 * @author: linjh
 * @create: 2019-06-15 22:16
 **/
public class DateDemo {

    public static void main(String[] args){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(simpleDateFormat.format(new Date().getTime()));


    }
}
