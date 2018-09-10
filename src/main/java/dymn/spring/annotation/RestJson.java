/**
 * @Project :  스마트톨링정보시스템 구축
 * @Class : RestJson.java
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

package dymn.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public @interface RestJson {
//	@AliasFor(annotation = RequestMapping.class)
//	String name() default "";
//
//	@AliasFor(annotation = RequestMapping.class)
//	String[] value() default {};
//
//	@AliasFor(annotation = RequestMapping.class)
//	String[] path() default {};
//
//	@AliasFor(annotation = RequestMapping.class)
//	String[] params() default {};
//
//	@AliasFor(annotation = RequestMapping.class)
//	String[] headers() default {};
//
//	@AliasFor(annotation = RequestMapping.class)
//	String[] consumes() default {};
//
//	@AliasFor(annotation = RequestMapping.class)
//	String[] produces() default {};
}
