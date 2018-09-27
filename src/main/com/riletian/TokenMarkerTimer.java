package main.com.riletian;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * remark:           令牌定时器类
 * author:           WIN10
 * date:             2018/9/27 12:59
 */
public class TokenMarkerTimer {

    private static String name = "apple";//令牌容器名称
    private static Integer size = 10;//令牌数量为10
    private static Integer second = 10000;//生产令牌的速度为10秒

    //按照指定时间生产令牌
    public static void main (String[] args)throws Exception{
        //定时任务1秒后开始执行，并按照second秒速度重复执行
       new Timer().schedule(new TimerTask() {
           @Override
           public void run() {
               TokenProviderUtils.makeToken(name,size);
           }
       },1,second);
        Thread.sleep(3000);//给生产一点时间
       //模拟消费
       while (true){
           for (int i = 0; i < 15; i++) {
               String app = TokenProviderUtils.getToken("apple");
               if(null ==app){
                   System.err.println(new Date().toLocaleString()+" 获取令牌失败，已无令牌可用");
               }else{
                   System.out.println(new Date().toLocaleString()+" 获取令牌成功，获取的令牌为： "+app);
               }
           }
           Thread.sleep(3000);//间隔
       }
    }
}
