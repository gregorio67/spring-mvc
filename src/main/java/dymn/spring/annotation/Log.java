/**
 * @Project :  스마트톨링정보시스템 구축
 * @Class : LOGGER.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

	public static Logger LOGGER = null;
	public Log(String logger) {
		LOGGER = LoggerFactory.getLogger(logger);
	}
	public Log(Class<?> clazz) {
		LOGGER = LoggerFactory.getLogger(clazz);			
	}
	
}
