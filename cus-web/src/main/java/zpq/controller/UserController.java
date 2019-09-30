package zpq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import zpq.bean.Css;
import zpq.bean.Customer;
import zpq.bean.MainMan;
import zpq.bean.Manager;
import zpq.myConstants.Constrants;
import zpq.myConstants.Msg;
import zpq.service.cusServiceService;

@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
	@Qualifier("cusServiceService")
	private cusServiceService cusServiceService;

	private Log logger = LogFactory.getLog(getClass());

	/**
	 * 添加管理员
	 * 
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("addMANAGER")
	public ModelAndView addManager(Manager manager, HttpServletRequest request, HttpSession session, ModelAndView mv) {
		Msg msg = cusServiceService.addManager(manager);
		logger.info(msg.getExtend().get("msg"));
		request.setAttribute("msg", msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers");
		return mv;
	}

	/**
	 * 添加维修人员
	 * 
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("addMAINMAN")
	public ModelAndView addMainMan(MainMan mainMan, HttpSession session, HttpServletRequest request, ModelAndView mv) {
		Msg msg = cusServiceService.addMainMan(mainMan);
		logger.info(msg.getExtend().get("msg"));
		request.setAttribute("msg", msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers");
		return mv;
	}

	/**
	 * 添加客户
	 * 
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("addCUSTOMER")
	public ModelAndView addCustomer(Customer customer, HttpServletRequest request, HttpSession session,
			ModelAndView mv) {
		Msg msg = cusServiceService.addCustomer(customer);
		logger.info(msg.getExtend().get("msg"));
		request.setAttribute("msg", msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers");
		return mv;
	}

	/**
	 * 添加客服
	 * 
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("addCUSSERVICER")
	public ModelAndView addCss(Css css, HttpServletRequest request, HttpSession session, ModelAndView mv) {
		Msg msg = cusServiceService.addCss(css);
		logger.info(msg.getExtend().get("msg"));
		request.setAttribute("msg", msg.getExtend().get("msg"));

		mv.setViewName("redirect:/user/selectUsers");
		return mv;
	}

	/**
	 * 更新个人信息
	 * 
	 * @param manager
	 * @param request
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "updateMyInfo_Manager", method = RequestMethod.POST)
	public ModelAndView updateMyInfo_Manager(Manager manager, HttpServletRequest request, HttpSession session,
			ModelAndView mv) {
		Msg msg = cusServiceService.updateManager(manager, (String) session.getAttribute("account"));
		if (msg.getCode() == 100) {
			session.setAttribute("account", manager.getAccount());
			session.setAttribute("myInfo", manager);
			
			logger.info(msg.getExtend().get("msg"));
		} else {
			logger.info(msg.getExtend().get("msg"));
			request.setAttribute("msg", msg.getExtend().get("msg"));
		}
		mv.setViewName("user/myInfo");
		return mv;
	}
	/**
	 * 更新个人信息
	 * 
	 * @param customer
	 * @param request
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "updateMyInfo_Customer", method = RequestMethod.POST)
	public ModelAndView updateMyInfo_Customer(Customer customer, HttpServletRequest request, HttpSession session,
			ModelAndView mv) {
		Msg msg = cusServiceService.updateCustomer(customer, (String) session.getAttribute("account"));
		if (msg.getCode() == 100) {
			session.setAttribute("account", customer.getAccount());
			session.setAttribute("myInfo", customer);
			
			logger.info(msg.getExtend().get("msg"));
		} else {
			logger.info(msg.getExtend().get("msg"));
			request.setAttribute("msg", msg.getExtend().get("msg"));
		}
		mv.setViewName("user/myInfo");
		return mv;
	}
	/**
	 * 更新个人信息
	 * 
	 * @param css
	 * @param request
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "updateMyInfo_Css", method = RequestMethod.POST)
	public ModelAndView updateMyInfo_Css(Css css, HttpServletRequest request, HttpSession session,
			ModelAndView mv) {
		Msg msg = cusServiceService.updateCusService(css, (String) session.getAttribute("account"));
		if (msg.getCode() == 100) {
			session.setAttribute("account", css.getAccount());
			session.setAttribute("myInfo", css);
			
			logger.info(msg.getExtend().get("msg"));
		} else {
			logger.info(msg.getExtend().get("msg"));
			request.setAttribute("msg", msg.getExtend().get("msg"));
		}
		mv.setViewName("user/myInfo");
		return mv;
	}
	/**
	 * 更新个人信息
	 * 
	 * @param mainMan
	 * @param request
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "updateMyInfo_Mainman", method = RequestMethod.POST)
	public ModelAndView updateMyInfo_Mainman(MainMan mainMan, HttpServletRequest request, HttpSession session,
			ModelAndView mv) {
		Msg msg = cusServiceService.updateMainMan(mainMan, (String) session.getAttribute("account"));
		if (msg.getCode() == 100) {
			session.setAttribute("account", mainMan.getAccount());
			session.setAttribute("myInfo", mainMan);
			logger.info(msg.getExtend().get("msg"));
		} else {
			logger.info(msg.getExtend().get("msg"));
			request.setAttribute("msg", msg.getExtend().get("msg"));
		}
		mv.setViewName("user/myInfo");
		return mv;
	}

	/**
	 * 用户查询功能，根据账号与人员类别查询用户
	 * 
	 * @param mv
	 * @param account
	 * @param selectUserFormStatus
	 * @return
	 */
	@RequestMapping(value = "selectUsers")
	public ModelAndView selectUser(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(defaultValue = "") String selectUserAccount,
			@RequestParam(value = "selectUserHunmanType", defaultValue = Constrants.MANAGER) String selectUserHunmanType,
			ModelAndView mv) {

		PageHelper.startPage(pn, 8);
		List users = new ArrayList<>();
		users = cusServiceService.selectUsers(selectUserAccount, selectUserHunmanType);
		PageInfo pageInfo = new PageInfo<>(users, 5);
		logger.info(users);
		mv.addObject("selectUserAccount", selectUserAccount);
		mv.addObject("selectUserHunmanType", selectUserHunmanType);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("user/selectUser");
		return mv;
	}

	/**
	 * 删除单个用户
	 * 
	 * @param userId
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "deleteUser")
	public ModelAndView deleteUser(Integer id, ModelAndView mv,
			@RequestParam(value = "selectUserHunmanType", defaultValue = Constrants.MANAGER) String selectUserHunmanType,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn, String selectUserAccount) {

		Msg msg = cusServiceService.deleteUser(id, selectUserHunmanType);
		System.out.println("selectUserHunmanType-->" + selectUserHunmanType);
		logger.info(msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers?selectUserHunmanType=" + selectUserHunmanType + "&selectUserAccount="
				+ selectUserAccount + "&pn=" + pn);
		return mv;
	}

	/**
	 * 删除多个员工
	 * 
	 * @param ids
	 * @param mv
	 * @param pn
	 * @param selectUserHunmanType
	 * @param selectUserAccount
	 * @return
	 */
	@RequestMapping(value = "deleteManyUsers")
	public ModelAndView deletsManyUsers(String ids, ModelAndView mv,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "selectUserHunmanType", defaultValue = Constrants.MANAGER) String selectUserHunmanType,
			String selectUserAccount) {

		String[] ids_Arr = ids.split(",");
		List<Integer> ids_List = new ArrayList<Integer>();
		for (String id : ids_Arr) {
			ids_List.add(Integer.valueOf(id));
		}
		Msg msg = cusServiceService.deleteUsers(ids_List, selectUserHunmanType);
		logger.info(msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers?selectUserHunmanType=" + selectUserHunmanType + "&selectUserAccount="
				+ selectUserAccount + "&pn=" + pn);
		return mv;
	}

	/**
	 * 更新用户信息,此方法只是用来获取数据并返回更新页面，并未执行更新操作
	 * 
	 * @param mv
	 * @param id
	 * @param selectUserHunmanType
	 * @return
	 */
	@RequestMapping("updateUser")
	public ModelAndView updateUser(ModelAndView mv, @RequestParam Integer id,
			@RequestParam String selectUserHunmanType) {
		Msg msg = cusServiceService.findUserById(id, selectUserHunmanType);
		logger.info(msg.getExtend().get("msg"));
		mv.addObject("selectUserHunmanType", selectUserHunmanType);
		mv.addObject("user", msg.getExtend().get("user"));
		mv.setViewName("user/updateUser");
		return mv;
	}

	/**
	 * 更新Manager信息
	 * 
	 * @param mv
	 * @param manager
	 * @param oriAccount
	 * @return
	 */
	@RequestMapping("updateManager")
	public ModelAndView updateManager(ModelAndView mv, Manager manager, String oriAccount) {
		Msg msg = cusServiceService.updateManager(manager, oriAccount);
		logger.info(msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers");
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
	public ModelAndView updateCustomer(ModelAndView mv, Customer customer, String oriAccount) {
		Msg msg = cusServiceService.updateCustomer(customer, oriAccount);
		logger.info(msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers");
		return mv;
	}

	/**
	 * 更新MainMan信息
	 * 
	 * @param mv
	 * @param mainMan
	 * @param oriAccount
	 * @return
	 */
	@RequestMapping("updateMainman")
	public ModelAndView updateMainMan(ModelAndView mv, MainMan mainMan, String oriAccount) {
		Msg msg = cusServiceService.updateMainMan(mainMan, oriAccount);
		logger.info(msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers");
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
	@RequestMapping("updateCusService")
	public ModelAndView updateCss(ModelAndView mv, Css css, String oriAccount) {
		Msg msg = cusServiceService.updateCusService(css, oriAccount);
		logger.info(msg.getExtend().get("msg"));
		mv.setViewName("redirect:/user/selectUsers");
		return mv;
	}

	/********************************************/


	/**
	 * 结合订单页面的ajax查询客服使用
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectCssesRetJson", method = RequestMethod.GET)
	public List<Css> selectCssesRetJson() {
		List<Css> csses = cusServiceService.selectUsers(null, Constrants.CUSSERVICER);
		return csses;
	}

}
