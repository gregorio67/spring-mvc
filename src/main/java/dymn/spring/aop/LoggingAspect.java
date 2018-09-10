/**
 * @Project :  스마트톨링정보시스템 구축
 * @Class : LoggingAspect.java
 * @Description : 
 *
 * @Author : LGCNS
 * @Since : 2017. 4. 20.
 *
 * @Copyright (c) 2018 EX All rights reserved.
 *-------------------------------------------------------------
 *              Modification Information
 *-------------------------------------------------------------
 * 날짜            수정자             변경사유 
 *-------------------------------------------------------------
 * 2018. 9. 4.        LGCNS             최초작성
 *-------------------------------------------------------------
 */

package dymn.spring.aop;

import org.slf4j.Logger;

import dymn.spring.annotation.Logging;

//@Aspect
//@Component
//@Order(3)
//
////@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class LoggingAspect {


//	private Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Logging
	private Logger LOGGER;
	
//	@Pointcut("execution(* sehati.bi..*Controller.*(..))")
//	private void logAround() {}
	
//	@Pointcut("@annotation(sehati.bi.annotation.StopWatch)")
//	private void stopWatch() {}

	
//	@Around("logAround()")
//	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//		StopWatch stopWatch = new StopWatch();
//		String className = joinPoint.getSignature().getName();
//		try {
//			stopWatch.start();
//			
//			joinPoint.proceed();
//		}
//		finally {
//			stopWatch.stop();
//			LOGGER.info("{} elapsed time :: {}", className, stopWatch.getTotalTimeMillis());
//		}
//	}

	
//	@Resource(name = "sqlSessionFactory")
//	private SqlSessionFactory sqlSessionFactory;
//
//	
//	@Before("@annotation(sehati.bi.annotation.BindSQL)")
//	public void bindingSql(JoinPoint joinPoint) throws Throwable {
//
//		
//		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//		String methodName = signature.getMethod().getName();
//		Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
//		Annotation[][] annotations = joinPoint.getTarget().getClass().getMethod(methodName,parameterTypes).getParameterAnnotations();
//		
//		/** Get annotation values **/
//	    Method method = signature.getMethod();
//
//	    BindSQL sqlAnnotation = method.getAnnotation(BindSQL.class);
//	    if (sqlAnnotation == null) {
//	    	return;
//	    }
//	    String[] sqlIds = sqlAnnotation.sqlIds();
//	    String paramType = sqlAnnotation.paramType();
//	    
//	    /** Get parameter for binding SQL **/
//	    Object sqlBindParam = null;
//		Object[] methodParams = joinPoint.getArgs();
//		if (!"".equals(paramType)) {
//			for (Object obj : methodParams) {
//				if ("Map".equals(paramType)) {
//					if (obj instanceof Map) {
//						sqlBindParam = obj;
//						break;
//					}
//				}
//				if ("String".equals(paramType)) {
//					if (obj instanceof String) {
//						sqlBindParam = obj;
//						break;
//					}
//				}
//				if ("int".equals(paramType)) {
//					if (obj instanceof Integer) {
//						sqlBindParam = obj;
//						break;
//					}
//				}
//			}
//		}
//		
//		/** Binding SQL with parameter **/
//		for (String sqlId : sqlIds) {
//			MappedStatement statement = sqlSessionFactory.getConfiguration().getMappedStatement(sqlId);
//			BoundSql boundSql = statement.getBoundSql(sqlBindParam);
//			String sql = boundSql.getSql().trim();
//			
//			LOGGER.info("Execute SQL :: {}", sql);
//		}
//		
////		/** Call method **/	
////		Object proceed = joinPoint.proceed();
////		
////		return proceed;
//	}

}
