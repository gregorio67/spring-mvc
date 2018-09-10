<%----------------------------------------------------------------------------%>
<%-- NAME : jobschedule.jsp													--%>
<%-- DESC : The purpose of search deploy source screen		     			--%>
<%-- VER  : v1.0                                                            --%>
<%-- Copyright ⓒ 2018 D.Y KIM                                              --%>
<%-- All rights reserved.                                                   --%>
<%----------------------------------------------------------------------------%>
<%--                           Change History                               --%>
<%----------------------------------------------------------------------------%>
<%--    DATE     AUTHOR                      DESCRIPTION                    --%>
<%-- ----------  ------------  -----------------------------------------------%>
<%-- 2016.04.22  Gregorio Kim  Initial creation                             --%>
<%----------------------------------------------------------------------------%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/include/header.jspf" %>
	<title>Source Deploy</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#naver").load('http://www.sehati.gov.bh');
		});
	
	
		/*----------------------------------------------------------------------------*/
		/* NAME : fn_init()															  */
		/* DESC : Main Business Code Search											  */
		/* DATE : 2018.05.11                                                          */
		/* AUTH : Gregorio Kim														  */
		/*----------------------------------------------------------------------------*/
		function fn_init() {
			debugger;
			sendParam = {};
			sendParam.command="getBizCode";
			restAjax.setUrl("<c:url value='/deploy/searchCodeList' />");
			restAjax.setCallback("fn_initCallBack");
			restAjax.setAsync(false);
			restAjax.setParam(sendParam);
			restAjax.call();
			
		}
	</script>
</head>
<body>
	<H3> This is BI portal</H3>
	<div>
		<table border="0">
			<colgroup>
				<col width="50%"/>
				<col width="50%"/>
			</colgroup>
			<tbody>
				<tr height="150px">
					<td>
						<div id="naver">
							
						</div>
					</td>
					<td>
						<div id="daum">
						</div>
					</td>
				</tr>
				<tr height="150px">
					<td>
						<div id="ccss">
						</div>
					</td>
					<td>
						<div id="bbbb">
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	
	<%@ include file="/WEB-INF/include/tailer.jspf" %>
</body>
</html>