package com.jd.testjsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jd.jsf.gd.config.ConsumerConfig;
import com.jd.jsf.gd.config.RegistryConfig;

/**
 * Title: <br>
 *
 * Description: <br>
 *
 * Company: <a href=www.jd.com>京东</a><br>
 * 
 * @author <a href=mailto:zhanggeng@jd.com>章耿</a>
 */
public class ClientMainAPI {

	/**
	 * SLF4J logger
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(ClientMainAPI.class);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	    RegistryConfig jsfRegistry = new RegistryConfig();
        jsfRegistry.setIndex("index.saf.jd.com"); // 测试环境192.168.209.74 index.saf.jd.com
        // safRegistry.setProtocol("safRegistry");
        // safRegistry.setAddress("192.168.209.74:40660");
		LOGGER.info("实例RegistryConfig");

		// 服务提供者连接注册中心，设置属性
		ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>();
		consumerConfig.setInterfaceId("com.jd.testjsf.HelloService");
		consumerConfig.setAlias("CHANGE-IT");
		consumerConfig.setProtocol("jsf");
		consumerConfig.setRegistry(jsfRegistry);
		// consumerConfig.setUrl("jsf://127.0.0.1:20880;jsf://127.0.0.1:20881"); //直连
		LOGGER.info("实例ConsumerConfig");

		HelloService service = consumerConfig.refer();
		LOGGER.info("得到调用端代理：{}", service);
		
		while (true) {
			try {
				String result = service.echoStr("zhanggeng put");
				LOGGER.info("response msg from server :{}", result);
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}
	}

}
