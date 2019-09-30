package zpq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorizationInterceptor implements HandlerInterceptor{

	private static final String[] IGNORE_URL = {"/login","/logout"};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		String servletPath = request.getServletPath();
		for(String s:IGNORE_URL){
			if(servletPath.contains(s)){
				//不拦截
				flag = true;
				break;
			}
		}
		if (!flag){
			/*System.out.println("拦截校验："+servletPath);*/
        	/** 1.获取session中的用户  */
//        	String account =  (String) request.getSession().getAttribute("account");
			Object user = request.getSession().getAttribute("myInfo");
        	/** 2.判断用户是否已经登录 */
        	if(user == null){
        		 /** 如果用户没有登录，跳转到登录页面 */
        		System.out.println("--------------------用户尚未登录--------------------");
        		request.setAttribute("message", "请先登录再访问网站!");
        		request.getRequestDispatcher("/loginForm").forward(request, response);
        		return flag;
        	}else{
        		System.out.println("--------------------"+"用户已登录："+user+"--------------------");
        		 flag = true;
        	}
        }
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
