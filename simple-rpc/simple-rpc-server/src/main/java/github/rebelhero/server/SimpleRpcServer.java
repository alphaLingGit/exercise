package github.rebelhero.server;

import github.rebelhero.provider.ServiceProvider;
import github.rebelhero.provider.impl.ServiceProviderImpl;
import github.rebelhero.serializer.Serializer;
import github.rebelhero.util.IPUtils;
import github.rebelhero.util.ThreadPoolFactoryUtils;
import github.rebelhero.zk.util.ZkCuratorUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.Console;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * netty 启动类，同时将服务注册到zk上。
 *
 * @author rebelhero
 * @date 2020/11/30
 */
@Slf4j
public class SimpleRpcServer {

    /**
     * 服务提供端口
     */
    private final int port;

    /**
     * 序列化方式
     */
    private final Serializer serializer;

    private final ServiceProvider serviceProvider;

    private final InetSocketAddress inetSocketAddress;

    public SimpleRpcServer(int port, Serializer serializer) {
        this.port = port;
        this.serializer = serializer;
        serviceProvider = new ServiceProviderImpl();
        String hostAddress;
        try {
            hostAddress = IPUtils.getLocalIp4Address().get().getHostAddress();
        } catch (Exception e) {
            log.error("获取本地ip异常", e);
            hostAddress = "127.0.0.1";
        }
        log.info("本机ip： {}", hostAddress);
        this.inetSocketAddress = new InetSocketAddress(hostAddress, port);
//        this.inetSocketAddress = new InetSocketAddress(port);
    }

    public <T> void registry(T service, Class<T> serviceClass) {

        String serviceName = serviceClass.getCanonicalName();
        ZkCuratorUtils.createPersistentNode(serviceName, inetSocketAddress);
        serviceProvider.addProvider(serviceName, service);
        startService();
    }


    private void startService() {
        // 埋一个钩子方法，在jvm 关闭前会将其关闭。
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ZkCuratorUtils.clearRegistry(inetSocketAddress);
            ThreadPoolFactoryUtils.shutDownAllThreadPool();
        }));


        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new SimpleChannelInitializer(serializer));
            ChannelFuture cf = serverBootstrap.bind(port).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("启动netty 时发生异常", e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


}
