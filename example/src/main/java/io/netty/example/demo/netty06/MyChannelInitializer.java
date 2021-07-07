package io.netty.example.demo.netty06;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Created on 2021/7/7.
 *
 * @author xuebaopeng
 * Description
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println("链接报告开始");
        System.out.println("链接报告信息：本客户端链接到服务端。channelId：" + ch.id());
        System.out.println("链接报告完毕");
    }
}
