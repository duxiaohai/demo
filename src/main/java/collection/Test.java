package collection;

import com.alibaba.fastjson.JSON;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: linjh
 * @create: 2019-07-09 11:31
 **/
public class Test {

    public static void main(String[] args){

        TargetResources targetResources = new TargetResources();
        targetResources.setTargetResourceKey("1");
        targetResources.setTargetResourceValue("22,33");

        TargetResources targetResources2 = new TargetResources();
        targetResources2.setTargetResourceKey("11");
        targetResources2.setTargetResourceValue("221,331");

        List<TargetResources> list = new ArrayList<>();

        list.add(targetResources);
        list.add(targetResources2);

        System.out.println(JSON.toJSONString(list));


        List<Map> lists = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("stageId","1");
        map.put("resourceIds","1");

//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("stageId","1");
//        map2.put("resourceIds","1");
//        lists.add(map);
        lists.add(map);

        System.out.println(JSON.toJSONString(lists));

        String za = "{\"url\":\"http://10.15.15.171/devops10/devops\",\"commitId\":\"3f0aeacdd9363d6f12fd5be4b0b07c012eabfc8c\"}";
        String aa = URLEncoder.encode(za);
        System.out.println(aa);

    }

}
