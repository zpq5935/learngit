package zpq.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zpq.bean.MyOrder;
import zpq.myConstants.Msg;
import zpq.service.cusServiceService;

@RequestMapping("order")
@Controller
public class OrderController {

	@Autowired
	@Qualifier("cusServiceService")
	cusServiceService cusServiceService;

	private Log logger = LogFactory.getLog(getClass());

	/**
	 * 查询多个订单
	 * @param mv
	 * @param pn
	 * @param cssAccount
	 * @param customerAccount
	 * @param prodName
	 * @param id
	 * @return
	 */
	@RequestMapping("selectOrder")
	public ModelAndView selectOrder(ModelAndView mv, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			String cssNickname, String cusNickname, String prodName, Integer id) {
		PageHelper.startPage(pn, 8);
		List<MyOrder> myOrders = new ArrayList<>();
		myOrders = cusServiceService.selectOrder(cssNickname, cusNickname, prodName);
		if (cssNickname != null)
			mv.addObject("cssNickname", cssNickname);
		if (cusNickname != null)
			mv.addObject("cusNickname", cusNickname);
		if (prodName != null)
			mv.addObject("prodName", prodName);
		PageInfo<MyOrder> pageInfo = new PageInfo<>(myOrders);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("order/selectOrder");
		return mv;
	}
	/**
	 * 客户查询自己的订单
	 * @param mv
	 * @param pn
	 * @param prodName
	 * @param id
	 * @return
	 */
	@RequestMapping("selectOrderByCusidAndProdname")
	public ModelAndView selectOrderByCusidAndProdname(ModelAndView mv, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			 String prodName, Integer cusid) {
		PageHelper.startPage(pn, 8);
		List<MyOrder> myOrders = new ArrayList<>();
		myOrders = cusServiceService.selectOrderByCusidAndProndame(cusid, prodName);
		
		if (prodName != null)
			mv.addObject("prodName", prodName);
		PageInfo<MyOrder> pageInfo = new PageInfo<>(myOrders);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("order/selectOrder");
		return mv;
	}

	/**
	 * 删除单个订单
	 * 
	 * @param id
	 * @param mv
	 * @param pn
	 * @param account
	 * @param onelevelAddress
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "deleteOrder")
	public ModelAndView deleteProduct(Integer id, ModelAndView mv,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		Msg msg = cusServiceService.deleteOrder(id);
		logger.info(msg.getExtend().get("msg"));

		String url = "redirect:/order/selectOrder?" + "pn=" + pn;
		mv.setViewName(url);
		return mv;
	}

	/**
	 * 批量删除订单
	 * 
	 * @param ids
	 * @param mv
	 * @param pn
	 * @param account
	 * @param onelevelAddress
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "deleteOrders")
	public ModelAndView deleteProducts(String ids, ModelAndView mv,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {

		String[] ids_Arr = ids.split(",");
		List<Integer> ids_List = new ArrayList<Integer>();
		for (String id : ids_Arr) {
			ids_List.add(Integer.valueOf(id));
		}
		Msg msg = cusServiceService.deleteOrders(ids_List);
		logger.info(msg.getExtend().get("msg"));

		String url = "redirect:/order/selectOrder?" + "pn=" + pn;
		mv.setViewName(url);
		return mv;
	}
	/**
	 * 更新订单
	 * @param flag
	 * @param id
	 * @param myOrder
	 * @param mv
	 * @return
	 */
	@RequestMapping("updateOrder")
	public ModelAndView updateOrder(@RequestParam Integer flag, Integer id, MyOrder myOrder, ModelAndView mv) {
		// 执行获取数据并跳转更新页面
		if (flag == 1) {
			Msg msg = cusServiceService.findOrderById(id);
			logger.info(msg.getExtend().get("msg"));
			mv.addObject("myOrder", msg.getExtend().get("myOrder"));
//			logger.info(((MyOrder)msg.getExtend().get("myOrder")).getAmount());
			mv.setViewName("order/updateOrder");
		} else {// 更新数据
			Msg msg = cusServiceService.updateOrder(myOrder);
			logger.info(msg.getExtend().get("msg"));
			mv.setViewName("redirect:/order/selectOrder");
		}
		return mv;
	}
	/**
	 * 添加订单信息
	 * 
	 * @param product
	 * @param mv
	 * @return
	 */
	@RequestMapping("addOrder")
	public ModelAndView addOrder(MyOrder myOrder, ModelAndView mv) {
		Date date = new Date();
		String messsage = null;
		myOrder.setDatetime(date);
		if(myOrder.getCusid()==null){
			messsage = "添加表单时客服不能为空！";
			mv.addObject("msg", messsage);
			logger.info(messsage);
			mv.setViewName("redirect:/order/addOrder");
			return mv;
		}
		Msg msg = cusServiceService.addOrder(myOrder);
		logger.info(msg.getExtend().get("msg"));
		mv.addObject("msg", msg.getExtend().get("msg"));
		mv.setViewName("redirect:/order/selectOrder");
		return mv;
	}
	
	/**
	 * 返回JSON，用于ajax查询
	 * @param cusid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selectOrderRetJson")
	public List<MyOrder> selectOrderRetJson(Integer cusid) {
		List<MyOrder> myOrders = new ArrayList<>();
		myOrders = cusServiceService.selectOrderByCusid(cusid);
		
		return myOrders;
	}
}
