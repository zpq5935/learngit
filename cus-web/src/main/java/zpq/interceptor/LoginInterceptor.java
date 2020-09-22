package zpq.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试MethodInterceptor
 * 
 * @author zpq5935
 *
 */
public class LoginInterceptor implements MethodInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object proceed = invocation.proceed();
		logger.info("拦截登录" );
		return proceed;
	}

}
