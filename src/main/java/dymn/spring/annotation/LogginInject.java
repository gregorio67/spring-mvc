/**
 * @Project :  스마트톨링정보시스템 구축
 * @Class : LogginInject.java
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
 * 2018. 9. 3.        LGCNS             최초작성
 *-------------------------------------------------------------
 */

package dymn.spring.annotation;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import cmn.util.common.NullUtil;


@Component
@Order(1)
public class LogginInject implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
//		if (bean.getClass().getAnnotation(Logging.class) != null) {
//			String loggerName = bean.getClass().getAnnotation(Logging.class).loggerName();
//			if (!NullUtil.isNull(loggerName)) {
//				return new Log(loggerName);
//			}
//			else {
//				return new Log(bean.getClass());
//			}
//		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
	 	ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {			
			@Override
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);
				if (field.getAnnotation(Logging.class) != null) {
					Logger LOGGER = null;
					String logger = field.getAnnotation(Logging.class).loggerName();
					if (!NullUtil.isNull(logger)) {
						LOGGER = LoggerFactory.getLogger(logger);
					}
					else {
						LOGGER = LoggerFactory.getLogger(bean.getClass());
					}
					field.set(bean, LOGGER);						
				}
				
			}
		});
		
		return bean;
	}

}
