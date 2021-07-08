package io.netty.example.demo.withSpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created on 2021/7/8.
 *
 * @author xuebaopeng
 * Description
 */
@RestController
@RequestMapping(value = "/nettyserver", method = RequestMethod.GET)
public class NettyController {

    @Resource
    private NettyServer nettyServer;

    @RequestMapping("/localAddress")
    public String localAddress() {
        return "nettyServer localAddress " + nettyServer.getChannel().localAddress();
    }

    @RequestMapping("/isOpen")
    public String isOpen() {
        return "nettyServer isOpen " + nettyServer.getChannel().isOpen();
    }

}
