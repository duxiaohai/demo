package arrayList;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: demo
 * @description: arrayList 集合类不安全问题
 * @author: linjh
 * @create: 2019-05-28 12:13
 **/
public class ArrayListDemo {

    public static void main(String[] args){
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        //List<String> list = new Vector<>();
//        List<String> list = new CopyOnWriteArrayList<>();
//
//        Set<String> set = new CopyOnWriteArraySet<>();
//
//        Map map = new ConcurrentHashMap();
//
//
//
//
//         for(int i = 0; i< 30; i++){
//           new Thread(()->{
//              list.add(UUID.randomUUID().toString().substring(0,8));
//              System.out.println(list.toString());
//
//           },String.valueOf(i)).start();
//         }

        Map<String,Object> map = new HashMap<>();
        map.put("467","1,22");
        map.put("481","41,61");

        System.out.println(JSON.toJSONString(map));

    }
}
