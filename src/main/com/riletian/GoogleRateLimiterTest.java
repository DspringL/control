package main.com.riletian;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.Executors;

/**
 * remark:           谷歌单机版限流实现测试
 * author:           WIN10
 * date:             2018/9/27 15:14
 */
public class GoogleRateLimiterTest {
    public static void main (String[] args)throws Exception{
        ListeningExecutorService executorService =MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(100));
        //指定每秒产生10个令牌
        RateLimiter limiter = RateLimiter.create(1);
        for (int i = 0; i < 10; i++) {
            limiter.acquire();//阻塞式获取
            //limiter.tryAcquire(3,TimeUnit.SECONDS)；//非阻塞式获取
        }

    }
}
