package io.netty.example.demo.netty01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created on 2021/7/6.
 *
 * @author xuebaopeng
 * Description 一个简单的Netty服务端示例
 */
public class NettyServer {

    public static void main(String[] args) {
        new NettyServer().bing(7397);
    }

    private void bing(int port){
        //配置服务端NIO线程组
        EventLoopGroup parentGroup=new NioEventLoopGroup();//NioEventLoopGroup extends MultithreadEventLoopGroup Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2))
        EventLoopGroup childGroup = new NioEventLoopGroup();
     try{
         ServerBootstrap bootstrap=new ServerBootstrap();
         bootstrap.group(parentGroup,childGroup)
                 .channel(NioServerSocketChannel.class) //非阻塞模式
             .option(ChannelOption.SO_BACKLOG,128)
                 .childHandler(new MyChannelInitializer());
         ChannelFuture channelFuture=bootstrap.bind(port).sync();
         channelFuture.channel().closeFuture().sync();
     }catch (InterruptedException e){
         e.printStackTrace();
     }finally {
         childGroup.shutdownGracefully();
         parentGroup.shutdownGracefully();
     }
    }


    class MyChannelInitializer extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            System.out.println("链接报告开始");
            System.out.println("链接报告信息：有一客户端链接到本服务端");
            System.out.println("链接报告IP:" + ch.localAddress().getHostString());
            System.out.println("链接报告Port:" + ch.localAddress().getPort());
            System.out.println("链接报告完毕");
        }
    }
}
