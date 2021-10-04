package in.ashokit.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MobileRestControllerAspect {

	Logger logger = LoggerFactory.getLogger(MobileRestControllerAspect.class);

	@Pointcut("execution(public * in.ashokit.rest.MobileResource.*(..))")
	public void p1() {
	}

	@Before("p1()")
	public void beginRestControllerMethods() {
		logger.info("begin");
	}
	/*
	 * @Around("p1()") public void beginRestControllerMethods(ProceedingJoinPoint p)
	 * { String methodName = p.getSignature().getName(); String className =
	 * p.getTarget().getClass().toString(); logger.info(methodName + "() from " +
	 * className + " executed"); }
	 */
}
