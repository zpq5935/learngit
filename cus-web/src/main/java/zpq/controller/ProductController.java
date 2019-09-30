package zpq.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import zpq.bean.Product;
import zpq.myConstants.Msg;
import zpq.service.cusServiceService;

@RequestMapping("product")
@Controller
public class ProductController {

	@Autowired
	@Qualifier("cusServiceService")
	cusServiceService cusServiceService;

	private Log logger = LogFactory.getLog(getClass());

	/********************************* 方法 **************************************/
	/**
	 * 查询产品
	 * 
	 * @param mv
	 * @param pn
	 * @param proName
	 * @return
	 */
	@RequestMapping("selectProduct")
	public ModelAndView selectProduct(ModelAndView mv, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			String prodname) {

		PageHelper.startPage(pn, 8);
		List<Product> products = cusServiceService.selectProducts(prodname);
		PageInfo<Product> pageInfo = new PageInfo<>(products);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("prodname", prodname);
		mv.setViewName("product/selectProduct");
		return mv;
	}

	/**
	 * 添加产品信息
	 * 
	 * @param product
	 * @param mv
	 * @return
	 */
	@RequestMapping("addProduct")
	public ModelAndView addProduct(Product product, ModelAndView mv) {
		Msg msg = cusServiceService.addProduct(product);
		logger.info(msg.getExtend().get("msg"));
		mv.addObject("msg", msg.getExtend().get("msg"));
		mv.setViewName("redirect:/product/selectProduct");
		return mv;
	}

	/**
	 * 更新Product信息
	 * 
	 * @param mv
	 * @param customer
	 * @param oriAccount
	 * @return
	 */
	@RequestMapping("updateProduct")
	public ModelAndView updateProduct(@RequestParam Integer flag, Integer id, Product product, String oriProductName,
			ModelAndView mv) {
		// 执行获取数据并跳转更新页面
		if (flag == 1) {
			Msg msg = cusServiceService.findProductById(id);
			logger.info(msg.getExtend().get("msg"));
			mv.addObject("product", msg.getExtend().get("product"));
			mv.setViewName("product/updateProduct");
		} else {// 更新数据
			Msg msg = cusServiceService.updateProduct(product, oriProductName);
			logger.info(msg.getExtend().get("msg"));
			mv.setViewName("redirect:/product/selectProduct");
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
	@RequestMapping(value = "deleteProduct")
	public ModelAndView deleteProduct(Integer id, ModelAndView mv,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "prodname", defaultValue = "") String prodname) throws UnsupportedEncodingException {
		Msg msg = cusServiceService.deleteProduct(id);
		logger.info(msg.getExtend().get("msg"));

		String url = "redirect:/product/selectProduct?" + "prodname" + URLEncoder.encode(prodname, "UTF-8") + "&pn="
				+ pn;
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
	@RequestMapping(value = "deleteProducts")
	public ModelAndView deleteProducts(String ids, ModelAndView mv,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "prodname", defaultValue = "") String prodname) throws UnsupportedEncodingException {

		String[] ids_Arr = ids.split(",");
		List<Integer> ids_List = new ArrayList<Integer>();
		for (String id : ids_Arr) {
			ids_List.add(Integer.valueOf(id));
		}
		Msg msg = cusServiceService.deleteProducts(ids_List);
		logger.info(msg.getExtend().get("msg"));

		String url = "redirect:/product/selectProduct?" + "prodname" + URLEncoder.encode(prodname, "UTF-8") + "&pn="
				+ pn;
		mv.setViewName(url);
		return mv;
	}
	/**
	 * 
	 * @param pn
	 * @param prodname
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="selectProductRetJson",method=RequestMethod.GET)
	public List<Product> selectProductRetJson() {
		List<Product> products = cusServiceService.selectProducts(null);
		return products;
	}
}
