package io.netty.example.demo.netty07;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created on 2021/7/7.
 *Netty开发中，客户端与服务端需要保持同样的；半包粘包处理，编码解码处理、收发数据方式，这样才能保证数据通信正常。在前面NettyServer的章节中我们也同样处理了；
 * 半包粘包、编码解码等，为此在本章节我们可以把这些知识模块开发到NettyClient中。本章节涉及到的知识点有；
 * LineBasedFrameDecoder、StringDecoder、StringEncoder、ChannelInboundHandlerAdapter等
 * @author xuebaopeng
 * Description
 */
public class NettyClient {
    public static void main(String[] args) {
        new  NettyClient().connect("127.0.0.1", 7397);
    }

    private void connect(String inetHost, int inetPort) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new MyChannelInitializer());
            ChannelFuture f = b.connect(inetHost, inetPort).sync();
            System.out.println("itstack-demo-netty client start done. {关注公众号：bugstack虫洞栈，获取源码}");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

}
