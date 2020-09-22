package zpq.interceptor;

import java.util.Collection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {

	private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	@Around("execution (* zpq..*.*(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object[] args = point.getArgs();
		logger.info("enter-->" + point.getSignature());
		for (int i = 0; i < args.length; i++) {
			Object arg = args[i];
			if (arg instanceof Collection<?>) {
				if (arg != null) {
					Collection<?> collection = (Collection<?>) arg;
					if (collection.size() > 100) {
						logger.info("arg[" + i + "]:" + "Collection and Size=" + collection.size());
					} else {
						logger.info("arg[" + i + "]:" + collection);
					}
				}
			} else {
				logger.info("arg[" + i + "]:" + arg);
			}
		}

		//
		Object object = point.proceed();
		logger.info("exit<--" + point.getSignature());
		
		if (logger.isInfoEnabled()) {
			if (object instanceof Collection<?>) {
				Collection<?> collection = (Collection<?>) object;
				if (collection != null) {
					if (collection.size() < 100) {
						logger.info("return object[" + object + "]");
					} else {
						logger.info("return object is Collection and size: " + collection.size());
					}
				}

			} else {
				logger.info("return object[" + object + "]");
			}

		}

		return object;
	}
}
