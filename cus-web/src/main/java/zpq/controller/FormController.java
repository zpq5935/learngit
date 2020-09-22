package zpq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态页面跳转控制器
 */
@Controller
public class FormController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 响应根目录页面跳转请求
	 * 
	 * @param formName
	 * @return
	 */
	@RequestMapping(value = "/{formName}")
	public String indexForm(@PathVariable String formName) {
		// 动态跳转页面
		// logger.info("响应页面"+formName);
		return formName;
	}

	/**
	 * 响应客户页面跳转请求
	 * 
	 * @param formName
	 * @return
	 */
	@RequestMapping(value = "/customerPage/{formName}")
	public String customerForm(@PathVariable String formName) {
		formName = "customer/" + formName;
		// logger.info("响应页面"+formName);
		return formName;
	}

	/**
	 * 响应订单页面跳转请求
	 * 
	 * @param formName
	 * @return
	 */
	@RequestMapping(value = "/orderPage/{formName}")
	public String orderForm(@PathVariable String formName) {
		formName = "order/" + formName;
		// logger.info("响应页面"+formName);
		return formName;
	}

	/**
	 * 响应产品页面跳转请求
	 * 
	 * @param formName
	 * @return
	 */
	@RequestMapping(value = "/productPage/{formName}")
	public String productForm(@PathVariable String formName) {
		formName = "product/" + formName;
		// logger.info("响应页面"+formName);
		return formName;
	}

	/**
	 * 响应报表页面跳转请求
	 * 
	 * @param formName
	 * @return
	 */
	@RequestMapping(value = "/reportPage/{formName}")
	public String reportForm(@PathVariable String formName) {
		formName = "report/" + formName;
		// logger.info("响应页面"+formName);
		return formName;
	}

	/**
	 * 响应售后服务页面跳转请求
	 * 
	 * @param formName
	 * @return
	 */
	@RequestMapping(value = "/servicePage/{formName}")
	public String serviceForm(@PathVariable String formName) {
		formName = "service/" + formName;
		// logger.info("响应页面"+formName);
		return formName;
	}

	/**
	 * 响应用户页面跳转请求
	 * 
	 * @param formName
	 * @return
	 */
	@RequestMapping(value = "/userPage/{formName}")
	public String userForm(@PathVariable String formName) {
		formName = "user/" + formName;
		// logger.info("响应页面"+formName);
		return formName;
	}

}