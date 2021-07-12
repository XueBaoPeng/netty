package io.netty.example.demo.withFile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created on 2021/7/12.
 *
 * @author xuebaopeng
 * Description
 */
public class CacheUtil {
    public static Map<String, FileBurstInstruct> burstDataMap = new ConcurrentHashMap<>();
}
