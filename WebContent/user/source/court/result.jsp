<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/lawyer/js/laydate/laydate.js"></script>

<style type="text/css">
#bg{ display: none; position: absolute; top: 0%; left: 0%; width: 100%; height: 100%; background-color: black; z-index:1001; -moz-opacity: 0.7; opacity:.70; filter: alpha(opacity=70);}
#show{display: none; position: absolute; top: 20%; left: 22%; width: 53%; height: 49%; padding: 8px; border: 8px solid #E8E9F7; background-color: white; z-index:1002; overflow: auto;}
</style>
<script type="text/javascript">
	function yeshu(cp){
		document.getElementById("cp").value=cp;
		document.getElementById("fenye").submit();
	}
	function fenyebycourt(courtcode){
		document.getElementById("courtcode").value=courtcode;
		document.getElementById("fenye").submit();
	}
	
	function resultopt(){
		var executestep = document.getElementById("step").value;
	//	var status = document.getElementById("status").value;
		
		if(executestep==""){
			alert("请选择案源当前执行步骤!");
			return;
		}
		/* if(status==""){
			alert("请选择企业状态!");
			return;
		} */

		if(executestep=="2"||executestep=="4"||executestep=="5"){
			alert("暂无操作!");
			return;
		}
		var mes = "";
		var strTimeEvection = document.getElementById("strTimeEvection").value;
		var endTimeEvection = document.getElementById("endTimeEvection").value;
		if(strTimeEvection=="" && endTimeEvection==""){
				mes="所有时间段,";
		}else if(strTimeEvection!="" && endTimeEvection==""){
				mes=strTimeEvection+"以后,";
		}else if(endTimeEvection!="" && strTimeEvection==""){
				mes=endTimeEvection+"以前,";
		}else{
				mes="时间段"+strTimeEvection+"至"+endTimeEvection+"期间,";
		}
		mes+="当前操作为 \"";
		if(executestep=="1"){
			mes+="被执行人执行信息";
		}else if(executestep=="2"){
			mes+="被执行人企业信息";
		}else if(executestep=="3"){
			mes+="申请执行人企业信息";
		}else if(executestep=="4"){
			mes+="申请执行人网络信息";
		}else if(executestep=="5"){
			mes+="申请执行人自有信息";
		}
		mes+="\"的";
		var courtcode = document.getElementById("courtcode").value;//法院编号
		if(courtcode==""){
			mes+="所有案源,";
		}else{
			mes+="编号为"+courtcode+"法院下所有案源,";
		}
		mes+="将被系统生成文件,是否继续?";
		//入库时间
		var instrTimeEvection=document.getElementById("instrTimeEvection").value;
		var inendTimeEvection = document.getElementById("inendTimeEvection").value;
		//执行标的
		var minMoney = document.getElementById("minMoney").value;
		var maxMoney = document.getElementById("maxMoney").value;
		
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/createData.action",
				data:"court.courtcode="+courtcode+"&court.executestep="+executestep+"&startDate="+strTimeEvection+"&endDate="+endTimeEvection+"&instartDate="+instrTimeEvection+"&inendDate="+inendTimeEvection+"&minMoney="+minMoney+"&maxMoney="+maxMoney,
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	
	//改变案源信息的执行步骤
	function changeStep(){
		var executestep = document.getElementById("step").value;
		var courtStep = document.getElementById("courtStep").value;
		if(executestep==""){
			alert("请选择案源当前执行步骤!");
			return;
		}
		if(courtStep==""){
			alert("填写要改变的执行步骤!");
			return;
		}
		var mes = "";
		var courtcode = document.getElementById("courtcode").value;//法院编号
		var strTimeEvection = document.getElementById("strTimeEvection").value;
		var endTimeEvection = document.getElementById("endTimeEvection").value;
		if(strTimeEvection=="" && endTimeEvection==""){
				mes="所有时间段,";
		}else if(strTimeEvection!="" && endTimeEvection==""){
				mes=strTimeEvection+"以后,";
		}else if(endTimeEvection!="" && strTimeEvection==""){
				mes=endTimeEvection+"以前,";
		}else{
				mes="时间段"+strTimeEvection+"至"+endTimeEvection+"期间,";
		}	
		mes="将改变所查询出数据的执行步骤，是否继续?";
		//入库时间
		var instrTimeEvection=document.getElementById("instrTimeEvection").value;
		var inendTimeEvection = document.getElementById("inendTimeEvection").value;
		//执行标的
		var minMoney = document.getElementById("minMoney").value;
		var maxMoney = document.getElementById("maxMoney").value;
		
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/changeCourtStep.action",
				data:"court.courtcode="+courtcode+"&court.executestep="+executestep+"&startDate="+strTimeEvection+"&endDate="+endTimeEvection+"&instartDate="+instrTimeEvection+"&inendDate="+inendTimeEvection+"&minMoney="+minMoney+"&maxMoney="+maxMoney+"&courtStep="+courtStep,
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	
	//裁判文书批处理
	function insertRefereeDocument(){
		var mes = "确定进行裁判文书批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertRefereeDocument.action",
				beforeSend:function(){
					document.getElementById("bg").style.display ="block";
					document.getElementById("show").style.display ="block";
				},
				success:function(msg){
					alert(msg);
				},
				complete: function(XMLHttpRequest, textStatus){
					document.getElementById("bg").style.display ='none';
					document.getElementById("show").style.display ='none';
             	}
			});
		}
	}
	//被执行人执行信息批处理
	function insertCourts(){
		var mes = "确定进行被执行人执行信息批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertCourts.action",
				beforeSend:function(){
					document.getElementById("bg").style.display ="block";
					document.getElementById("show").style.display ="block";
				},
				success:function(msg){
					alert(msg);
				},
				complete: function(XMLHttpRequest, textStatus){
					document.getElementById("bg").style.display ='none';
					document.getElementById("show").style.display ='none';
             	}
			});
		}
	}
	//被执行人公告信息
	function insertNoteCourts(){
		var mes = "确定进行被执行人（债务人）公告信息导入操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertNoteCourts.action",
				beforeSend:function(){
					document.getElementById("bg").style.display ="block";
					document.getElementById("show").style.display ="block";
				},
				success:function(msg){
					alert(msg);
				},
				complete: function(XMLHttpRequest, textStatus){
					document.getElementById("bg").style.display ='none';
					document.getElementById("show").style.display ='none';
             	}
			});
		}
	}
	//被执行人失信信息
	function insertDishonestyCourts(){
		var mes = "确定进行被执行人（债务人）失信信息导入操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertDishonestyCourts.action",
				beforeSend:function(){
					document.getElementById("bg").style.display ="block";
					document.getElementById("show").style.display ="block";
				},
				success:function(msg){
					alert(msg);
				},
				complete: function(XMLHttpRequest, textStatus){
					document.getElementById("bg").style.display ='none';
					document.getElementById("show").style.display ='none';
             	}
			});
		}
	}
	//被执行人企业信息批处理
	function insertEbs(){
		var mes = "确定进行被执行人企业信息批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertExecutes.action",
				beforeSend:function(){
					document.getElementById("bg").style.display ="block";
					document.getElementById("show").style.display ="block";
				},
				success:function(msg){
					alert(msg);
				},
				complete: function(XMLHttpRequest, textStatus){
					document.getElementById("bg").style.display ='none';
					document.getElementById("show").style.display ='none';
             	}
			});
		}
	}
	
	//申请执行人企业信息
	function insertApplierinfos(){
		var mes = "确定进行申请执行人企业信息批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertApplierinfos.action",
				beforeSend:function(){
					document.getElementById("bg").style.display ="block";
					document.getElementById("show").style.display ="block";
				},
				success:function(msg){
					alert(msg);
				},
				complete: function(XMLHttpRequest, textStatus){
					document.getElementById("bg").style.display ='none';
					document.getElementById("show").style.display ='none';
             	}
			});
		}
	}
	//申请执行人企业网络信息
	function insertApplierinfoNets(){
		var mes = "确定进行申请执行人企业网络信息批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertAppNets.action",
				beforeSend:function(){
					document.getElementById("bg").style.display ="block";
					document.getElementById("show").style.display ="block";
				},
				success:function(msg){
					alert(msg);
				},
				complete: function(XMLHttpRequest, textStatus){
					document.getElementById("bg").style.display ='none';
					document.getElementById("show").style.display ='none';
             	}
			});
		}
	}
	function tiao(){
		var cp = document.getElementById("tiaoye").value;
		if(isNaN(cp)){
			alert("请输入正确数字！");
			return;
		}
		document.getElementById("cp").value=cp;
		document.getElementById("fenye").submit();
	}
	
	$(document).ready(function () { $("#loadgif").hide();});
	
</script>
</head>
<body>
<div id="bg"></div>
<div id="show"><span style="font-size:16px;position:absolute; z-index:2; left:100px; top:10px">数据处理中...</span><img alt="数据处理中..." src="/lawyer/images/loading.gif" /></div>
<table cellspacing="0" cellpadding="0" border="0" width="98%"
	height="100%" class="content_table" style="float: left;">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="/lawyer/images/view_16x16.gif" />&nbsp;<span
			class="title">查询案源信息</span></td>
	</tr>
	<tr>
		<td colspan="2">
		<table cellpadding="0" cellspacing="0" width="100%" align="center"
			class="search_table" border="0">
			<tr>
				<td align="center" colspan="2">
				<form id="fenye" action="findCourts.action" method="post">
				案源当前执行步骤: <select name="court.executestep" id="step">
					<option value="">请选择执行步骤</option>
					<option value="1"
						<s:if test="%{court.executestep==1}" >selected</s:if>>1.被执行人执行信息</option>
					<option value="2"
						<s:if test="%{court.executestep==2}" >selected</s:if>>2.被执行人企业信息</option>
					<option value="3"
						<s:if test="%{court.executestep==3}" >selected</s:if>>3.申请执行人企业信息</option>
					<option value="4"
						<s:if test="%{court.executestep==4}" >selected</s:if>>4.申请执行人网络信息</option>
					<option value="5"
						<s:if test="%{court.executestep==5}" >selected</s:if>>5.申请执行人自有信息</option>
					<option value="6"
						<s:if test="%{court.executestep==6}" >selected</s:if>>6.与申请人联系信息</option>
					<option value="7"
						<s:if test="%{court.executestep==7}" >selected</s:if>>7.已签约</option>
				</select>&nbsp;&nbsp;&nbsp; 
				立案时间从：<input name="startDate"
					value="${startDate }" type="text" id="strTimeEvection" size="20" onClick="laydate()"
					readonly="readonly" /> 至：<input
					name="endDate" value="${endDate }" type="text" readonly="readonly" onClick="laydate()"
					id="endTimeEvection" size="20" /> <br />
				入库时间从：<input name="instartDate" value="${instartDate }" type="text"
					id="instrTimeEvection" size="20" readonly="readonly" onClick="laydate()"/> 
					至：<input name="inendDate" value="${inendDate }" type="text"
					readonly="readonly" id="inendTimeEvection" size="20" onClick="laydate()"/> 
					执行标的:<input
					type="text" id="minMoney" name="minMoney" value="${minMoney }" />元----<input
					type="text" id="maxMoney" name="maxMoney" value="${maxMoney }" />元
				<input type="hidden" name="cp" id="cp" /> <input type="hidden"
					name="court.courtcode" id="courtcode" value="${court.courtcode }"><br />
				企业状态: <select name="exb.EStatus" id="status">
					<option value="">请选择企业状态</option>
					<option value="吊销" <c:if test="${'吊销' eq exb.EStatus}">selected</c:if> >吊销</option>
					<option value="注销" <c:if test="${'注销' eq exb.EStatus}">selected</c:if> >注销</option>
					<option value="开业" <c:if test="${'开业' eq exb.EStatus}">selected</c:if> >开业</option>
				</select>&nbsp;&nbsp;&nbsp;
				<input type="submit" value="查询" />
				<c:if test="${userlp.lp_query_casesource_resultopts==1}">
					<input type="button" value="查询结果批量操作" onclick="resultopt()">&nbsp;&nbsp;&nbsp;
				</c:if>
				<input type="button" value="改变执行步骤：" onclick="changeStep()">
				<input type="text" id="courtStep" name="courtStep" />（填写要改变的步骤）
				</form>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<table cellpadding="0" cellspacing="0" border="0" align="center"
	width="98%" class="result_table">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="/lawyer/images/view_16x16.gif" />&nbsp;
		<span class="title">案源信息</span></td>
	</tr>
	<tr class="title" align="center">
		<td>案源信息编号</td>
		<td>被执行人姓名/名称</td>
				<td>执行法院</td>
				<td>立案时间</td>
				<td>案号</td>
				<td>操作</td>
	</tr>
	<s:iterator id="c" value="courts" status="courtstatus">
		<tr align="center">
			<td><s:property value="#c.casecodeself" /></td>
				<td><s:property value="#c.pname" /></td>
				<td><s:property value="#c.execCourtName" /></td>
				<td><s:property value="#c.caseCreateTime" /></td>
				<td><s:property value="#c.caseCode" /></td>
				<td>
				<c:if test="${userlp.lp_query_casesource_detail==1}">
					<a href="selectCourtById?users.id=${admin.UId}&court.casecodeself=<s:property value="#c.casecodeself"/>&court.caseId=<s:property value="#c.caseId"/>" target="content">查看详细信息</a>&nbsp;&nbsp; 
				</c:if>
				<c:if test="${userlp.lp_del==1}">
					<a href="#">删除</a>
				</c:if>
				</td>
		</tr>
	</s:iterator>
	<tr>
		<td colspan="6">第${cp }页/共${tp }页&nbsp;&nbsp;<a
			href="javascript:yeshu(1)">首页</a>&nbsp;<a
			href="javascript:yeshu('${cp-1 }')">上一页</a>&nbsp;<a
			href="javascript:yeshu('${cp+1 }')">下一页</a>&nbsp;<a
			href="javascript:yeshu('${tp }')">尾页</a>
			<input type="text" id="tiaoye" style="width: 40px;"/>
			<input type="button" onclick="tiao()" value="go" />	
		</td>
	</tr>
</table>
<c:if test="${userlp.lp_query_casesource_resultopts==1}">
	&nbsp;&nbsp;&nbsp;
	<div id="loadgif" style="width:66px;height:66px;position:absolute;top:50%;left:50%;">
　　		<img  alt="数据处理中..." src="/lawyer/images/loading.gif"/>
	</div>
	<table cellpadding="0" cellspacing="0" border="0" align="center"
		width="98%" class="result_table">
		<tr>
			<td colspan="2">&nbsp;&nbsp;<img src="images/view_16x16.gif" />&nbsp;
			<span class="title">批处理操作</span></td>
		</tr>
			<tr class="title">
				<td colspan="6">&nbsp;&nbsp;<img
					src="/lawyer/images/flag2_16x16.gif" />&nbsp;裁判文书查询</td>	
			</tr>
			<tr>
				<td align="center"><input type="button" value="裁判文书导入"
					onclick="insertRefereeDocument()" /></td>
			</tr>
			<tr class="title">
				<td colspan="6">&nbsp;&nbsp;<img
					src="/lawyer/images/flag2_16x16.gif" />&nbsp;被执行人(债务人)执行信息</td>
			</tr>
			<tr>
				<td align="center"><input type="button" value="被执行人执行信息"
					onclick="insertCourts()" /></td>
				<td align="center"><input type="button" value="被执行人公告信息"
					onclick="insertNoteCourts()" /></td>
				<td align="center"><input type="button" value="被执行人失信信息"
					onclick="insertDishonestyCourts()" /></td>
			</tr>
			<tr class="title">
				<td colspan="6">&nbsp;&nbsp;<img
					src="/lawyer/images/flag2_16x16.gif" />&nbsp;被执行人企业信息</td>	
			</tr>
			<tr>
				<td align="center"><input type="button" value="被执行人企业信息"
					onclick="insertEbs()" /></td>
			</tr>
			<tr class="title">
				<td colspan="6">&nbsp;&nbsp;<img
					src="/lawyer/images/flag2_16x16.gif" />&nbsp;申请执行人企业信息</td>
			</tr>
			<tr>
				<td ><input type="button" value="申请执行人企业信息"
					onclick="insertApplierinfos()" /></td>
			</tr>
			<tr class="title">
				<td colspan="6">&nbsp;&nbsp;<img
					src="/lawyer/images/flag2_16x16.gif" />&nbsp;申请执行人企业网络信息</td>
			</tr>
			<tr>
				<td align="center"><input type="button" value="申请执行人企业网络信息"
					onclick="insertApplierinfoNets()" /></td>
			</tr>
	</table>
</c:if>
</body>
</html>