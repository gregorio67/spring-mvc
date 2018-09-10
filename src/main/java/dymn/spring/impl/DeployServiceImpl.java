package dymn.spring.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.springframework.stereotype.Service;

import cmn.util.dao.CamelMap;
import cmn.util.spring.BaseService;
import dymn.spring.annotation.BindSQL;
import dymn.spring.annotation.StopWatch;
import dymn.spring.service.DeployService;

@Service("deployIService")
public class DeployServiceImpl extends BaseService implements DeployService {

	@BindSQL(sqlIds ={"deploy.target.selSystemNameList", "deploy.target.selSubSystemList"})
	@StopWatch
	public Map<String, Object> selCodeList() throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> systemNameList = baseDao.selectList("deploy.target.selSystemNameList", null);
		
		List<Map<String, Object>> subSystemList = baseDao.selectList("deploy.target.selSubSystemList", null);
		
		resultMap.put("systemNameList", systemNameList);
		resultMap.put("subSystemList", subSystemList);
		return resultMap;
	}

	@BindSQL(sqlIds ={"deploy.target.selDeployTargetList"}, paramType = "Map")
	public List<Map<String, Object>> selDeployTargetList(Map<String, Object> param) throws Exception {
		
		return baseDao.selectList("deploy.target.selDeployTargetList", param);
	}

	public int selDeployTargetListCnt(Map<String, Object> param) throws Exception {
		
		return baseDao.select("deploy.target.selDeployTargetCnt", param);
	}

	public CamelMap selDeployTargetItem(Map<String, Object> param) throws Exception {
		
		return baseDao.select("deploy.target.selDeployTargetItem", param);
	}


}
