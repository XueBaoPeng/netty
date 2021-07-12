package io.netty.example.demo.withJavaObj;

/**
 * Created on 2021/7/12.
 *
 * @author xuebaopeng
 * Description
 */
public class MsgUtil {
    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId,msgContent);
    }

}
