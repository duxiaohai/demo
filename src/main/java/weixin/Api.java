//package weixin;
//
//import me.chanjar.weixin.common.api.WxConsts;
//import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
//import me.chanjar.weixin.common.exception.WxErrorException;
//import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @program: demo
// * @description:
// * @author: linjh
// * @create: 2019-09-02 17:46
// **/
//public class Api {
//
//    public static void main(String[] args){
//        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        Orders orders = this.ordersMapper.selectByPrimaryKey(orderId);
//        ArrayList<OrderDetails> orderDetails = this.orderDetailMapper.selectByOrderId
//                (orders.getOrderId());
//        // 生成订单小票
//        OrderBillUtils orderBillUtils = new OrderBillUtils(0);
//        orders.setGroupName("克拉玛依新华书店");
//        orders.setPayDate(new Date());
//        String printInfo = orderBillUtils.getOrderBillText1(orders, orderDetails);
//        // 根据str,font的样式以及输出文件目录
//        Integer width = 400;
//        Font font = new Font("宋体", Font.BOLD, 20);
//        logger.info(font.toString());
//        String[] ss = printInfo.split("/");
//        logger.info("小票：" + printInfo);
//        logger.info("数组长度" + ss.length);
//        Integer height = 35 * ss.length;
//        // 创建图片
//        BufferedImage image = new BufferedImage(width, height,
//                BufferedImage.TYPE_INT_BGR);
//        Graphics g = image.getGraphics();
//        g.setClip(0, 0, width, height);
//        g.setColor(Color.white);
//        g.fillRect(1, 1, width, height);// 先用黑色填充整张图片,也就是背景
//        g.setColor(Color.black);// 在换成黑色
//        g.setFont(font);// 设置画笔字体
//        for (int j = 0; j < ss.length; j++) {
//            g.drawString(ss[j], 20, 30 * (j + 2));// 画出字符串
//        }
//        g.dispose();
//        String path = System.getProperty("web.root") + "orderBills" + File.separator + "electronic_" + df1.format(new Date().getTime()) + ".png";
//        File file = new File(path);
//        try {
//            ImageIO.write(image, "png", file);// 输出png图片
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        logger.info("电子小票地址：" + path);
//
//
//
//        try {
//            /*
//             *给支付成功用户发送电子小票二维码
//             */
//            String openId = (String) session.getAttribute(CURRENT_OPEN_ID);
//            logger.info("openId：" + openId);
//
//            //1. 上传图片，返回结果
//            WxMediaUploadResult result = wxMpService.getMaterialService().mediaUpload(WxConsts.MediaFileType.IMAGE, file);
//            logger.info("上传图片结果：" + request);
//
//            if (result != null) {
//                String media_id = result.getMediaId();
//
//                WxMpKefuMessage wxMpKefuMessage = new WxMpKefuMessage();
//                wxMpKefuMessage.setToUser(openId);
//                wxMpKefuMessage.setMsgType(WxConsts.KefuMsgType.IMAGE);
//                wxMpKefuMessage.setMediaId(media_id);
//                //  2. 发送图片
//                boolean result1 = wxMpService.getKefuService().sendKefuMessage(wxMpKefuMessage);
//            }
//
//            orders.setOrderBill(printInfo);
//        } catch (
//                WxErrorException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
