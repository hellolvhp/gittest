package com.jd.testjsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: <br>
 *
 * Description: <br>
 *
 * Company: <a href=www.jd.com>京东</a><br>
 * 
 * @author <a href=mailto:zhanggeng@jd.com>章耿</a>
 */
public class ServerMain {

	/**
	 * SLF4J logger
	 */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(ServerMain.class);

	/**
	 * Method Name main
	 * 
	 * @param args
	 *            Return Type void
	 */
	public static void main(String[] args) {

		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                "/jsf-provider.xml");

		LOGGER.info("服务端启动完成！");

		// 关闭服务
		// appContext.close();

		// 启动本地服务，然后hold住本地服务
		synchronized (ServerMain.class) {
			while (true) {
				try {
					ServerMain.class.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
}