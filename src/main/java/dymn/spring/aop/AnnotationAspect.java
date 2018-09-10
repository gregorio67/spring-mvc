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

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import dymn.spring.annotation.BindSQL;
import dymn.spring.annotation.Logging;

@Aspect
@Component
@Order(2)
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AnnotationAspect {
	
	
	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Logging()
	private Logger LOGGER;

//	@Pointcut("@annotation(StopWatch)")
//	public void stopWatchPoint() {};
//		
//	@Pointcut("@annotation(BindSQL)")
//	public void bindingSqlPoint() {};
	
	@Around("@annotation(dymn.spring.annotation.StopWatch)")
	private Object stopWatch(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		Object proceed = null;
		String className = joinPoint.getSignature().getName();
		try {
			stopWatch.start();
			
			proceed = joinPoint.proceed();
		}
		finally {
			stopWatch.stop();
			LOGGER.info("#{}({}): {} in {}[msec]s", className, joinPoint.getArgs(), proceed, stopWatch.getTotalTimeMillis());
		}
		
		return proceed;
	}

//	@AfterReturning("@annotation(sehati.bi.annotation.BindSQL)")
	@Before("@annotation(dymn.spring.annotation.BindSQL)")
	public void bindingSql(JoinPoint joinPoint) throws Throwable {

		/** Get annotation values **/
	    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	    Method method = signature.getMethod();

	    BindSQL sqlAnnotation = method.getAnnotation(BindSQL.class);
	    String[] sqlIds = sqlAnnotation.sqlIds();
	    String paramType = sqlAnnotation.paramType();
	    
	    /** Get parameter for binding SQL **/
	    Object sqlBindParam = null;
		Object[] methodParams = joinPoint.getArgs();
		if (!"".equals(paramType)) {
			for (Object obj : methodParams) {
				if ("Map".equals(paramType)) {
					if (obj instanceof Map) {
						sqlBindParam = obj;
						break;
					}
				}
				if ("String".equals(paramType)) {
					if (obj instanceof String) {
						sqlBindParam = obj;
						break;
					}
				}
				if ("int".equals(paramType)) {
					if (obj instanceof Integer) {
						sqlBindParam = obj;
						break;
					}
				}
			}
		}
		
		/** Binding SQL with parameter **/
		for (String sqlId : sqlIds) {
			Configuration configuration = sqlSessionFactory.getConfiguration();
			MappedStatement statement = configuration.getMappedStatement(sqlId);
			TypeHandlerRegistry typeHandlerRegistry = statement.getConfiguration().getTypeHandlerRegistry();
			BoundSql boundSql = statement.getBoundSql(sqlBindParam);
			String sql = boundSql.getSql().trim();

			/** Binding SQL with parameter **/
			List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
			if (parameterMappings != null) {
		        for (int i = 0; i < parameterMappings.size(); i++) {
		            ParameterMapping parameterMapping = parameterMappings.get(i);
		            if (parameterMapping.getMode() != ParameterMode.OUT) {
		                Object value;
		                String propertyName = parameterMapping.getProperty();
		                if (boundSql.hasAdditionalParameter(propertyName)) {
		                    value = boundSql.getAdditionalParameter(propertyName);
		                } else if (sqlBindParam == null) {
		                    value = null;
		                } else if (typeHandlerRegistry.hasTypeHandler(sqlBindParam.getClass())) {
		                    value = sqlBindParam;
		                } else {
		                    MetaObject metaObject = configuration.newMetaObject(sqlBindParam);
		                    value = metaObject.getValue(propertyName);
		                }
		                JdbcType jdbcType = parameterMapping.getJdbcType();
		                if (value == null && jdbcType == null) {
		                	jdbcType = configuration.getJdbcTypeForNull();
		                }
		                sql = replaceParameter(sql, value, jdbcType, parameterMapping.getJavaType());
		            }
		        }
		    }			
			LOGGER.info("Execute SQL :: [{}] :: [{}]", sql, sqlBindParam);
		}
		
	}	
	
    private static String replaceParameter(String sql, Object value, JdbcType jdbcType, Class javaType) {
        String strValue = String.valueOf(value);
        if (jdbcType != null) {
            switch (jdbcType) {
                case BIT:
                case TINYINT:
                case SMALLINT:
                case INTEGER:
                case BIGINT:
                case FLOAT:
                case REAL:
                case DOUBLE:
                case NUMERIC:
                case DECIMAL:
                    break;
                case DATE:
                case TIME:
                case TIMESTAMP:
                default:
                    strValue = "'" + strValue + "'";
            }
        } else if (Number.class.isAssignableFrom(javaType)) {
        } else {
            strValue = "'" + strValue + "'";
        }
        
        return sql.replaceFirst("\\?", strValue);
    }
}
