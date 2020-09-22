package zpq.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zpq.bean.Customer;
import zpq.constants.Constrants;
import zpq.constants.Msg;
import zpq.service.ICusServiceService;

@RequestMapping("customer")
@Controller
public class CustomerController {

	@Autowired
	@Qualifier("cusServiceService")
	ICusServiceService cusServiceService;

	// private Log logger = LogFactory.getLog(getClass());
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/******************************************************************************/

	/**
	 * 查询客户
	 * 
	 * @param mv
	 * @param pn
	 * @param account
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("selectCustomer")
	public ModelAndView selectCustomer(ModelAndView mv, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "onelevelAddress", defaultValue = "") String onelevelAddress) {
		PageHelper.startPage(pn, 8);
		logger.info("onelevelAddress=" + onelevelAddress);
		List<Customer> customers = cusServiceService.selectCustomer(account, onelevelAddress);
		PageInfo<Customer> pageInfo = new PageInfo<>(customers);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("account", account);
		mv.addObject("onelevelAddress", onelevelAddress);
		mv.setViewName("customer/selectCustomer");
		return mv;
	}

	/**
	 * 添加客户
	 * 
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("addCustomer")
	public ModelAndView addCustomer(Customer customer, ModelAndView mv) {
		Msg msg = cusServiceService.addCustomer(customer);
		logger.info(msg.getExtend().get("msg").toString());
		mv.addObject("msg", msg.getExtend().get("msg"));

		mv.setViewName("redirect:/customer/selectCustomer");
		return mv;
	}

	/**
	 * 更新Customer信息
	 * 
	 * @param mv
	 * @param customer
	 * @param oriAccount
	 * @return
	 */
	@RequestMapping("updateCustomer")
	public ModelAndView updateCustomer(@RequestParam Integer flag, Integer id, Customer customer, String oriAccount,
			ModelAndView mv) {
		// 执行获取数据并跳转更新页面
		if (flag == 1) {
			Msg msg = cusServiceService.findUserById(id, Constrants.CUSTOMER);
			logger.info(msg.getExtend().get("msg").toString());
			mv.addObject("customer", msg.getExtend().get("user"));
			mv.setViewName("customer/updateCustomer");
		} else {// 更新数据
			Msg msg = cusServiceService.updateCustomer(customer, oriAccount);
			logger.info(msg.getExtend().get("msg").toString());
			mv.setViewName("redirect:/customer/selectCustomer");
		}

		return mv;
	}

	/**
	 * 删除单个客户
	 * 
	 * @param id
	 * @param mv
	 * @param pn
	 * @param account
	 * @param onelevelAddress
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "deleteCustomer")
	public ModelAndView deleteCustomer(Integer id, ModelAndView mv,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "onelevelAddress", defaultValue = "") String onelevelAddress)
			throws UnsupportedEncodingException {
		Msg msg = cusServiceService.deleteUser(id, Constrants.CUSTOMER);
		logger.info(msg.getExtend().get("msg").toString());

		String url = "redirect:/customer/selectCustomer?" + "account=" + URLEncoder.encode(account, "UTF-8")
				+ "&onelevelAddress=" + URLEncoder.encode(onelevelAddress, "UTF-8") + "&pn=" + pn;
		mv.setViewName(url);
		return mv;
	}

	/**
	 * 批量删除客户
	 * 
	 * @param ids
	 * @param mv
	 * @param pn
	 * @param account
	 * @param onelevelAddress
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "deleteCustomers")
	public ModelAndView deletsCustomers(String ids, ModelAndView mv,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "onelevelAddress", defaultValue = "") String onelevelAddress)
			throws UnsupportedEncodingException {

		String[] ids_Arr = ids.split(",");
		List<Integer> ids_List = new ArrayList<Integer>();
		for (String id : ids_Arr) {
			ids_List.add(Integer.valueOf(id));
		}
		Msg msg = cusServiceService.deleteUsers(ids_List, Constrants.CUSTOMER);
		logger.info(msg.getExtend().get("msg").toString());

		mv.setViewName("redirect:/customer/selectCustomer?" + "account=" + URLEncoder.encode(account, "UTF-8")
				+ "&onelevelAddress=" + URLEncoder.encode(onelevelAddress, "UTF-8") + "&pn=" + pn);
		return mv;
	}

	/**
	 * 结合订单页面的ajax使用
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectCustomerRetJson", method = RequestMethod.GET)
	public List<Customer> selectCustomerRetJson() {
		List<Customer> customers = cusServiceService.selectCustomer(null, null);
		return customers;
	}
}
