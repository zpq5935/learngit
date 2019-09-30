package zpq.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zpq.myConstants.Msg;
import zpq.service.cusServiceService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("cusServiceService")
	private cusServiceService cusServiceService;

	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * 登录功能
	 * @param account
	 * @param password
	 * @param type:登录人员类型：客服、客户、维修员、管理员
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("account") String account, @RequestParam("password") String password,
			@RequestParam("hunmanType") String hunmanType, HttpSession session, ModelAndView mv) {
		if (account == null || password == null || hunmanType == null) {
			logger.info("信息有空缺!请重新输入");
			mv.addObject("message", "信息有空缺!请重新输入");
			mv.setViewName("loginForm");
		}
		Msg msg = cusServiceService.login(account, password, hunmanType);
		if ( 100 == msg.getCode()) {
			logger.info("用户【" + account + "】登录成功");
			// 利用HttpSession保存登录状态
			session.setAttribute("account", account);
			session.setAttribute("hunmanType", hunmanType);
//			Constrants.setDomainClassByHunmanType(hunmanType);
			List list = (List) msg.getExtend().get("user");
			session.setAttribute("myInfo",  list.get(0));
			//mv.setViewName("main");
			mv.setViewName("redirect:/index");
		} else {
			logger.info("登录名或密码错误!请重新输入");
			mv.addObject("message", "登录名或密码错误!请重新输入");
			
			mv.setViewName("loginForm");
		}
		return mv;
	}

	/**
	 * 登出功能，弹出到登录界面并且移除session中的account
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		logger.info("用户【" + session.getAttribute("account") + "】登出");
		session.removeAttribute("account");
		session.removeAttribute("hunmanType");
		session.removeAttribute("myInfo");
		return "loginForm";
	}
}
