/**
 * @Project :  스마트톨링정보시스템 구축
 * @Class : DeployCtr.java
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
 * 2018. 7. 6.        LGCNS             최초작성
 *-------------------------------------------------------------
 */

package dymn.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dymn.spring.annotation.Logging;
import dymn.spring.service.DeployService;

//@Logging(logger=Log.class)
@Controller

public class PageController {


	@Logging()
	private static Logger LOGGER;
	
	@Resource(name = "deployIService")
	private DeployService deployIService;
	
	@RequestMapping(value = "/bi/mainpage.do")
	public String mainPageView(HttpServletRequest request, String id) throws Exception {
		LOGGER.info("Called :: {}", request.getRequestURL());
		Map<String, Object> result = deployIService.selCodeList();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pageRowCount", 10);
		param.put("curRowCount", 1);
		param.put("systemName", "PORTAL");
		deployIService.selDeployTargetList(param);
		LOGGER.info("result :: {}", result);
		return "main";
	}

}
