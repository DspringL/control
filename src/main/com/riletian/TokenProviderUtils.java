package main.com.riletian;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * remark:           令牌生产者
 * author:           WIN10
 * date:             2018/9/27 12:51
 */
public class TokenProviderUtils {
    //令牌桶容器
    private static Map<String, List<String>> containerMap = new ConcurrentHashMap<String, List<String>>();

    /**
     * remark:               生产令牌
     * author:               WIN10
     * date:                 2018/9/27 12:55
     * @param key           容器中令牌容器名称
     * @param size          令牌容器的数量
     */
    public static void makeToken(String key, Integer size){
        //对指定的令牌容器进行判断
        List<String> tokenList = containerMap.get(key);
        if(null !=containerMap.get(key)){
            //判断令牌容器的数量是否需要填充
            if(tokenList.size()<size){
                for (int i = 0; i < size-tokenList.size(); i++) {
                    tokenList.add(UUID.randomUUID().toString());
                }
            }
        }else{
            //令牌容器不存在就进行创建
            tokenList = new ArrayList<String>();
            for (int i = 0; i < size; i++) {
                tokenList.add(UUID.randomUUID().toString());
            }
            containerMap.put(key, tokenList);
        }
    }

    /**
     * remark:               获取令牌
     * author:               WIN10
     * date:                 2018/9/27 12:57
     * @param key           容器中令牌容器名称
     * @return
     */
    public static String getToken(String key){
        //对指定的令牌容器进行判断
        List<String> tokenList = containerMap.get(key);
        if(null !=tokenList){
            if(tokenList.size()==0){
                //没有令牌了
                return null;
            }else{
                return tokenList.remove(0);
            }
        }else{
            return null;
        }
    }
}
