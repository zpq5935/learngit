package zpq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONConverter;
import cn.hutool.json.JSONString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zpq.constants.Constrants;
import zpq.util.CacheUtil;

public class AuthorizationInterceptor implements HandlerInterceptor {
    // 日志对象
    private Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);
    // 忽略的url
    private static final String[] IGNORE_URL = {"/login", "/logout", ".css", ".js", ".jpg"};

    public boolean isEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(boolean enableFlag) {
        this.enableFlag = enableFlag;
    }

    // 是否启用拦截
    private boolean enableFlag = true;


    // 缓存接口
    private CacheUtil cacheUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!enableFlag) {
            return true;
        }
        // 判断请求是否属于忽略url
        String servletPath = request.getServletPath();
        for (String s : IGNORE_URL) {
            if (servletPath.contains(s)) {
                // 不拦截
                return true;
            }
        }

        /** 1.获取session中的用户 */
//        Object user = request.getSession().getAttribute("myInfo");
        Object user = cacheUtil.get(Constrants.REDIS_USER_ACCOUNT);
        /** 2.判断用户是否已经登录 */
        if (user == null) {
            /** 如果用户没有登录，跳转到登录页面 */
            logger.info("--------------------用户{}尚未登录--------------------");
            request.setAttribute("message", "请先登录再访问网站!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
        } else {
//                logger.info("--------------------" + "用户已登录：" + user + "--------------------");
            if (request.getSession().getAttribute("myInfo") == null)
                request.getSession().setAttribute("myInfo", user);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    public void setCacheUtil(CacheUtil cacheUtil) {
        this.cacheUtil = cacheUtil;
    }

    public CacheUtil getCacheUtil() {
        return cacheUtil;
    }
}
