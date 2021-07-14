package io.netty.example.demo.netty02;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * Created on 2021/7/6.
 *
 * @author xuebaopeng
 * Description
 */
public class MyServerHandler  extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收mes消息
        ByteBuf buf= (ByteBuf) msg;
        byte[] msgByte=new byte[buf.readableBytes()];
        buf.readBytes(msgByte);
        System.out.print(new Date() + "接收到消息：");
        System.out.println(new String(msgByte, Charset.forName("UTF-8")));
    }
}