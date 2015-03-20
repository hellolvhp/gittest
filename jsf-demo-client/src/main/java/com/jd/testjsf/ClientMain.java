package com.jd.testjsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: 使用spring集成的方式调用JSF服务<br>
 *
 * Description: <br>
 *
 * Company: <a href=www.jd.com>京东</a><br>
 * 
 * @author <a href=mailto:zhanggeng@jd.com>章耿</a>
 */
public class ClientMain {

	/**
	 * SLF4J logger
	 */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(ClientMain.class);

	/**
	 * Method Name main
	 * 
	 * @param args
	 *            Return Type void
	 */
	public static void main(String[] args) {

		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                "/jsf-consumer.xml");

		HelloService service = (HelloService) appContext
				.getBean("helloService");
		LOGGER.info("得到调用端代理：{}", service);

		while (true) {
			try {
				String result = service.echoStr("zhanggeng put");
				LOGGER.info("response msg from server :{}", result);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}

		// SAFContext.destroy();
	}
}
