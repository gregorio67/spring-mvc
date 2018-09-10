/**
 * @Project :  스마트톨링정보시스템 구축
 * @Class : AnnotationInterceptor.java
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
 * 2018. 9. 5.        LGCNS             최초작성
 *-------------------------------------------------------------
 */

package dymn.spring.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AnnotationInterceptor extends HandlerInterceptorAdapter{

	 @Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		 HandlerMethod handlerMethod = (HandlerMethod) handler;
		 CheckSkip checkSkip = handlerMethod.getMethodAnnotation(CheckSkip.class);
		 if (checkSkip != null) {
			 if (checkSkip.skip()) {
				 return true;
			 }			 
		 }
		 return true;
	 }
}
