/**
 * 
 */
package com.jd.testjsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title: <br>
 *
 * Description: <br>
 *
 * Company: <a href=www.jd.com>京东</a><br>
 * 
 * @author <a href=mailto:zhanggeng@jd.com>章耿</a>
 */
public class HelloServiceImpl implements HelloService {

	private static Logger logger = LoggerFactory
			.getLogger(HelloServiceImpl.class);

	@Override
	public String echoStr(String str) {
		logger.info("server get request : {}", str);
		return str;
	}
}
