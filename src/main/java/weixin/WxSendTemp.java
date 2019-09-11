//package weixin;
//
///**
// * @program: demo
// * @description:
// * @author: linjh
// * @create: 2019-09-03 15:17
// **/
//
//
//import net.sf.json.JSONObject;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 发送微信模板消息
// * @Author: PengKe
// * @CreateDate: 2018/8/7 15:55
// * @Version: 1.0
// */
//public class WxSendTemp {
//    final private String appid = WxParam.appid; //appid自己填下哦
//    final private String appSecret = WxParam.appSecret; // appSecret自己填下
//    private String accessToken;
//
//    /**
//     * 获取accessToken(根据业务量，不缓存)
//     */
//    public void sendTemp(){
//        String url = "https://api.weixin.qq.com/cgi-bin/token";
//        String param = "grant_type=client_credential"+"&appid="+appid+"&secret="+appSecret;
//        String accTemp = HttpSend.sendGet(url,param);
//        JSONObject jsonObject = JSONObject.fromObject(accTemp);
//        System.out.println("1--->"+jsonObject);
//        accessToken = jsonObject.getString("access_token"); // 获取到了access_token，调用接口都要用到的，有时效
//        // 封装要发送的json
//        Map<String,Object> map = new HashMap();
//        map.put("touser","otGbAjmSd1l3_U472fh1z6vepZ2A");//你要发送给某个用户的openid 前提是已关注该公众号,该openid是对应该公众号的，不是普通的openid
//        map.put("template_id","tHeERRgJhjR2WKXV1CknaLfRtvJaTs-GU30n4kCRtbA");//模板消息id
//        map.put("url","https://www.vipkes.cn");//用户点击模板消息，要跳转的地址
//        // 封装miniprogram 跳转小程序用,不跳不要填
//        Map<String,String> mapA = new HashMap<>();
//        mapA.put("appid",""); //小程序appid
//        mapA.put("pagepath",""); //小程序页面pagepath
//        map.put("miniprogram",mapA);
//
//        // 以下就是根据模板消息的格式封装好，我模板的是：问题反馈结果通知  可以和我一样试试
//        // 封装first
//        Map firstMap = new HashMap();
//        firstMap.put("value","您提交的问题有新的回复！"); //内容
//        firstMap.put("color","#173177"); //字体颜色
//
//        // 封装keyword1 提交的问题
//        Map keyword1Map = new HashMap();
//        keyword1Map.put("value","我司走廊上的花已经死了，请尽快派人过来，谢谢");
//        keyword1Map.put("color","#fff");
//
//        // 封装keyword2
//        Map keyword2Map = new HashMap();
//        keyword2Map.put("value","好的，我们马上派人过来！");
//        keyword2Map.put("color","#fff");
//
//        // 封装remark
//        Map remarkMap = new HashMap();
//        remarkMap.put("value","2018-08-07 16:16:16");
//        remarkMap.put("color","#fff");
//
//        // 封装data
//        Map dataMap = new HashMap();
//        dataMap.put("first",firstMap);
//        dataMap.put("keyword1",keyword1Map);
//        dataMap.put("keyword2",keyword2Map);
//        dataMap.put("remark",remarkMap);
//
//        map.put("data",dataMap);
//        String r = HttpUtil.getJsonData(JSONObject.fromObject(map),"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken); //发送模板消息，这里有个工具类，我给你哟
//        System.out.println("-->"+r);
//    }
//
//    //这main方法你认识不，嘻嘻  开个玩笑
//    public static void main(String[] args){
//        WxSendTemp wxSendTemp = new WxSendTemp();
//        wxSendTemp.sendTemp();
//    }
//}
