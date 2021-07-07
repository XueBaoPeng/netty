package io.netty.example.demo.netty08;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created on 2021/7/7.
 *  自定义编码器
 * @author xuebaopeng
 * Description
 */
public class MyEncoder  extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) throws Exception {
        String msg = in.toString();
        byte[] bytes = msg.getBytes();

        byte[] send = new byte[bytes.length + 2];
        System.arraycopy(bytes, 0, send, 1, bytes.length);
        send[0] = 0x02;
        send[send.length - 1] = 0x03;

        out.writeInt(send.length);
        out.writeBytes(send);
    }
}
