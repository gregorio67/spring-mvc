/**
 * @Project :  스마트톨링정보시스템 구축
 * @Class : Logging.java
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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.Order;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,  ElementType.FIELD})
public @interface Logging {
	String loggerName() default "";
}
