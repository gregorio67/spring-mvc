package dymn.spring.service;

import java.util.List;
import java.util.Map;

import cmn.util.dao.CamelMap;
import dymn.spring.annotation.BindSQL;
import dymn.spring.annotation.StopWatch;

public interface DeployService {

	public Map<String, Object> selCodeList() throws Exception ;

	public List<Map<String, Object>> selDeployTargetList(Map<String, Object> param) throws Exception ;

	public int selDeployTargetListCnt(Map<String, Object> param) throws Exception ;

	public CamelMap selDeployTargetItem(Map<String, Object> param) throws Exception ;

}
