package com.jd.testjsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jd.jsf.gd.config.ProviderConfig;
import com.jd.jsf.gd.config.RegistryConfig;
import com.jd.jsf.gd.config.ServerConfig;

/**
 * Title: <br>
 *
 * Description: <br>
 *
 * Company: <a href=www.jd.com>京东</a><br>
 * 
 * @author <a href=mailto:zhanggeng@jd.com>章耿</a>
 */
public class ServerMainAPI {

    /**
     * SLF4J logger
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerMainAPI.class);

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        HelloService helloService = new HelloServiceImpl();

        // 注册中心实现（必须）
        RegistryConfig safRegistry = new RegistryConfig();
        safRegistry.setIndex("i.jsf.jd.com"); // 测试环境192.168.209.74 i.jsf.jd.com
        // safRegistry.setProtocol("jsfRegistry");
        // safRegistry.setAddress("192.168.209.74:40660");
        LOGGER.info("实例RegistryConfig");

        // 服务端配置（必须）
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.setProtocol("jsf");
        // serverConfig.setHost("0.0.0.0"); 可以判定到全部网卡
        // serverConfig.setPort(20880); // 可以指定端口
        LOGGER.info("实例ServerConfig");

        // 服务提供者属性
        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>();
        providerConfig.setInterfaceId("com.jd.testjsf.HelloService");
        providerConfig.setAlias("CHANGE-IT");
        providerConfig.setRef(helloService);
        providerConfig.setServer(serverConfig); // 多个server用list
        providerConfig.setRegistry(safRegistry); // 多个registry用list
        // providerConfig.setRegister(false);//打开注释表示不走注册中心
        LOGGER.info("实例ProviderConfig");

        // 暴露及注册服务
        providerConfig.export();
        LOGGER.info("服务端发布服务完成！");

        // providerConfig.unexport();
        // LOGGER.info("取消发布服务完成");

        // 启动本地服务，然后hold住本地服务
        synchronized (ServerMainAPI.class) {
            while (true) {
                try {
                    ServerMainAPI.class.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}