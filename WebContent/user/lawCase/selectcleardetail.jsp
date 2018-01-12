<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.net.URLEncoder"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看案件详细信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/lawyer/js/laydate/laydate.js"></script>
<style type="text/css">
#bg {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.7;
	opacity: .70;
	filter: alpha(opacity = 70);
}

#show {
	display: none;
	position: absolute;
	top: 25%;
	left: 22%;
	width: 53%;
	height: 49%;
	padding: 8px;
	border: 8px solid #E8E9F7;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>

<script type="text/javascript">
	
	function sendSms() {
		var lawyername = document.getElementById("lawyername").value;
		var lawyermobile = document.getElementById("lawyermobile").value;
		var remindTime = document.getElementById("remindTime").value;
		var content = document.getElementById("content").value;

		$.ajax({
			type : "POST",
			cache : false,
			url : "/lawyer/insertTasks.action",
			data : "lawyername=" + lawyername + "&lawyermobile=" + lawyermobile
					+ "&remindTime=" + remindTime + "&content=" + content,
			success : function(msg) {
				var obj = eval('(' + msg + ')');
				if (obj.result == 1) {
					alert(obj.message);
					hidediv();
				} else {
					alert(obj.message);
				}
			}
		});
	}

	function showdiv(lawyername, lawyermobile) {
		document.getElementById("lawyername").value = lawyername;
		document.getElementById("lawyermobile").value = lawyermobile;

		document.getElementById("bg").style.display = "block";
		document.getElementById("show").style.display = "block";
	}
	function hidediv() {
		document.getElementById("bg").style.display = 'none';
		document.getElementById("show").style.display = 'none';
	}
</script>

</head>
<body>
	<div id="bg"></div>
	<div id="show">
		<form name="smsform" method="post" action="smsremind">
			<table>
				<tr>
					<td>办案律师：</td>
					<td><input type="text" id="lawyername" name="lawyername" /></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" id="lawyermobile" name="lawyermobile" />
					</td>
				</tr>
				<tr>
					<td>提醒内容：</td>
					<td><textarea rows="8" cols="40" id="content" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td>日期：</td>
					<td><input type="text" id="remindTime" name="remindTime"
						onClick="laydate()" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="button" value="发送"
						onclick="sendSms()" />&nbsp;&nbsp; <input type="button" value="取消"
						onclick="hidediv();" /></td>
				</tr>
			</table>
		</form>
	</div>

	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr>
			<td>&nbsp;&nbsp;<img src="/lawyer/images/view_16x16.gif" />&nbsp;
				<span class="title">编号为${cont.csCasecodeself }的案件信息详情</span></td>
		</tr>
		<tr>
			<td>
				<table cellpadding="0" cellspacing="0" width="98%" align="center"
					class="result_table" border="0">
					<tr class="title">
						<td colspan="3">&nbsp;&nbsp;<img
							src="/lawyer/images/flag2_16x16.gif" />&nbsp;签约信息</td>
						<td colspan="3">&nbsp;&nbsp;<img
							src="/lawyer/images/flag2_16x16.gif" />&nbsp;材料整理信息</td>
					</tr>
					<tr>
						<td class="padding_td" valign="top" colspan="3">
							<table cellpadding="0" cellspacing="0" width="100%" border="0"
								class="step_table">
								<tr>
									<td align="right" class="td">签约号：</td>
									<td class="td">${ cont.csNo }</td>
								</tr>
								<tr>
									<td align="right" width="15%" class="td">签约时间：</td>
									<td class="td">${cont.csDate}</td>
								</tr>
								<tr>
									<td align="right" class="td">对方联系人名称：</td>
									<td class="td">${cont.csName }</td>
								</tr>
								<tr>
									<td align="right" class="td">电话：</td>
									<td class="td">${cont.csTel }</td>
								</tr>
								<tr>
									<td align="right" class="td">备注：</td>
									<td class="td">${cont.csRemark}</td>
								</tr>
								<tr>
									<td align="right" class="td">记录人员：</td>
									<td class="td">${cont.users.UName }</td>
								</tr>
								<tr>
									<td align="right" class="td">记录时间：</td>
									<td class="td">${cont.csSavetime }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">附件：</td>
									<td class="td"><a
										href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.csAttach }">
										${cont.csAttach }</a></td>
								</tr>
								<tr>
									<td class="td" align="right"><b>可执行操作</b>：</td>
									<td class="td"><a href="javascript:alert('业务不支持修改操作');">修改</a>&nbsp;&nbsp;
										<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a>
									</td>
								</tr>
							</table>
						</td>
						<s:if test="cont.material!=null">
							<td class="padding_td" valign="top" colspan="3">
								<table cellpadding="0" cellspacing="0" width="100%" border="0"
									class="step_table">
									<tr>
										<td align="right" class="td" width="40%">材料是否邮寄：</td>
										<td class="td">
											<s:if test="%{cont.material.isMail==0 }">未邮寄</s:if>
											<s:if test="%{cont.material.isMail==1 }">已邮寄</s:if>
										</td>
									</tr>
									<tr>
										<td align="right" class="td">邮寄人：</td>
										<td class="td">${cont.material.sender }</td>
									</tr>
									<tr>
										<td align="right" class="td">邮寄单号：</td>
										<td class="td">${cont.material.sendNumber }</td>
									</tr>
									<tr>
										<td align="right" class="td">邮寄时间：</td>
										<td class="td">${cont.material.sendDate }</td>
									</tr>
									<tr>
										<td align="right" class="td">材料返回时间：</td>
										<td class="td">${cont.material.receiveDate }</td>
									</tr>
									<tr>
										<td align="right" class="td">备注：</td>
										<td class="td">${cont.material.remark }</td>
									</tr>
									<tr>
										<td align="right" class="td">记录人员：</td>
										<td class="td">${cont.material.users.UName }</td>
									</tr>
									<tr>
										<td align="right" class="td">记录时间：</td>
										<td class="td">${cont.material.savetime }</td>
									</tr>
									<tr>
										<td align="right" width="25%" class="td">附件：</td>
										<td class="td"><a
											href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.material.attach }">
											${cont.material.attach }</a></td>
									</tr>
									<tr>
										<td class="td" align="right"><b>可执行操作</b>：</td>
										<td class="td"><a href="selectMaterial.action?casecodeself=${cont.material.casecodeself}"
											target="_blank">查看更多</a></td>
									</tr>
									<tr>
										<td class="td" align="right">
											<a href="/lawyer/user/lawCase/insertmaterial.jsp?Casecodeself=${cont.csCasecodeself }">继续添加</a>
										</td>
									</tr>
								</table>
							</td>
						</s:if>
						<s:else>
							<td class="padding_td" valign="top" colspan="3">
								<table cellpadding="0" cellspacing="0" width="100%" border="0"
									class="step_table">
									<tr>
										<td class="td" align="left">
											<a href="/lawyer/user/lawCase/insertmaterial.jsp?Casecodeself=${cont.csCasecodeself }">点击添加</a>
										</td>
									</tr>
								</table>
							</td>
						</s:else>
					</tr>
						<tr class="title">
							<td colspan="6">&nbsp;&nbsp;<img
								src="/lawyer/images/flag2_16x16.gif" />&nbsp;维护客户</td>
						</tr>
						<s:if test="cont.customer!=null">
							<tr>
								<td class="padding_td" valign="top" colspan="6">
									<table cellpadding="0" cellspacing="0" width="100%" border="0"
										class="step_table">
										<tr>
											<td align="right" class="td" width="30%">对方联系人：</td>
											<td class="td">${cont.customer.contacts}</td>
										</tr>
										<tr>
											<td align="right" class="td" width="30%">对方联系电话：</td>
											<td class="td">${cont.customer.contactPhone}</td>
										</tr>
										<tr>
											<td align="right" class="td" width="30%">联系日期：</td>
											<td class="td">${cont.customer.contactDate}</td>
										</tr>
										<tr>
											<td align="right" class="td" width="30%">服务人员：</td>
											<td class="td">${cont.customer.serviceUser}</td>
										</tr>
										<tr>
											<td align="right" class="td" width="30%">服务人电话：</td>
											<td class="td">${cont.customer.servicePhone}</td>
										</tr>
										<tr>
											<td align="right" class="td" width="30%">联系内容：</td>
											<td class="td">${cont.customer.content}</td>
										</tr>
										<tr>
											<td align="right" class="td">记录人员：</td>
											<td class="td">${cont.customer.users.UName }</td>
										</tr>
										<tr>
											<td align="right" class="td">记录时间：</td>
											<td class="td">${cont.customer.savetime }</td>
										</tr>
										<tr>
											<td class="td" align="right"><b>可执行操作</b>：</td>
											<td class="td"><a
												href="selectcustomer.action?casecodeself=${cont.customer.casecodeself}"
												target="_blank">查看更多</a></td>
										</tr>
										<tr>
											<td class="td" align="right">
												<a href="showcustomer.action?casecodeself=${cont.csCasecodeself }">继续添加</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							</s:if>
							<s:else>
							<tr>
								<td class="padding_td" valign="top" colspan="3">
									<table cellpadding="0" cellspacing="0" width="100%" border="0"
										class="step_table">
										<tr>
											<td class="td" align="left">
												<a href="/lawyer/user/lawCase/insertcustomer.jsp?Casecodeself=${cont.csCasecodeself }">点击添加</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</s:else>
					<tr class="title">
						<td colspan="6">&nbsp;&nbsp;<img
							src="/lawyer/images/flag2_16x16.gif" />&nbsp;清算阶段</td>
					</tr>
					<tr class="title">
						<td colspan="3" align="center">清算立案</td>
						<td colspan="3" align="center">清算结束</td>
					</tr>

					<!--一层if  -->
					<s:if test="cont.clearrecord!=null&&cont.clearclear!=null">
						<tr>
							<td class="padding_td" valign="top" colspan="3">

								<table cellpadding="0" cellspacing="0" width="100%" border="0"
									class="step_table">
									<tr>
										<td align="right" class="td" width="40%">材料递交时间：</td>
										<td class="td">${cont.clearrecord.crdate }</td>
									</tr>
									<tr>
										<td align="right" class="td">立案案号：</td>
										<td class="td">${cont.clearrecord.crnumber }</td>
									</tr>

									<tr>
										<td align="right" class="td">联系法官：</td>
										<td class="td">${cont.clearrecord.crcontactjudge }</td>
									</tr>
									<tr>
										<td align="right" class="td">法官电话：</td>
										<td class="td">${cont.clearrecord.crcontacttel}</td>
									</tr>
									<tr>
										<td align="right" class="td">承办律师：</td>
										<td class="td">${cont.clearrecord.crlawname}</td>
									</tr>
									<tr>
										<td align="right" class="td">律师电话：</td>
										<td class="td">${cont.clearrecord.crlawtel}</td>
									</tr>
									<tr>
										<td align="right" class="td">律师电话：</td>
										<td class="td">${cont.clearrecord.crlawtel}</td>
									</tr>
									<tr>
										<td align="right" class="td">协办人员：</td>
										<td class="td">${cont.clearrecord.assistingName}</td>
									</tr>
									<tr>
										<td align="right" class="td">协办联系方式：</td>
										<td class="td">${cont.clearrecord.assistingTel}</td>
									</tr>
									<tr>
										<td align="right" class="td">管辖法院：</td>
										<td class="td">${cont.clearrecord.competentCourt}</td>
									</tr>
									<tr>
										<td align="right" class="td">案件进展：</td>
										<td class="td">${cont.clearrecord.crfollowupresult }</td>
									</tr>
									<tr>
										<td align="right" class="td">备注：</td>
										<td class="td">${cont.clearrecord.crremark }</td>
									</tr>
									<tr>
										<td align="right" class="td">附件：</td>
										<td class="td"><a
											href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.clearrecord.crattach}">
											${cont.clearrecord.crattach}</a></td>
									</tr>
									<tr>
										<td align="right" class="td">记录人员：</td>
										<td class="td">${cont.clearrecord.users.UName }</td>
									</tr>
									<tr>
										<td align="right" class="td">记录时间：</td>
										<td class="td">${cont.clearrecord.crSaveTime }</td>
									</tr>
									<tr>
										<td class="td" align="right"><b>可执行操作</b>：</td>
										<td class="td"><a href="javascript:void(0);"
											onclick="showdiv('${cont.clearrecord.crlawname}','${cont.clearrecord.crlawtel}')">短信提醒</a>
											&nbsp;&nbsp;&nbsp;&nbsp; <a
											href="selectclearrecord.action?casecodeself=${cont.clearrecord.crcasecodeself}"
											target="_blank">查看更多</a></td>
									</tr>
									<tr>
										<td class="td" align="right">
											<%-- <a href="/lawyer/user/lawCase/insertclearrecord.jsp?Casecodeself=${cont.csCasecodeself }">继续添加</a> --%>
											<a href="showclearrecord.action?casecodeself=${cont.csCasecodeself }">继续添加</a>
										</td>
									</tr>
								</table>
							</td>

							<td class="padding_td" valign="top" colspan="3" align="right">
								<table cellpadding="0" cellspacing="0" width="100%" border="0"
									class="step_table" align="right">
									<tr>
										<td align="right" class="td" width="30%">结束时间：</td>
										<td class="td">${cont.clearclear.ccTime}</td>
									</tr>
									<tr>
										<td align="right" class="td" width="30%">立案案号：</td>
										<td class="td">${cont.clearclear.ccnumber}</td>
									</tr>
									<tr>
										<td align="right" class="td" width="30%">承办法官：</td>
										<td class="td">${cont.clearclear.ccjudge}</td>
									</tr>
									<tr>
										<td align="right" class="td">法官电话：</td>
										<td class="td">${cont.clearclear.ccjudgetel }</td>
									</tr>
									<tr>
										<td align="right" class="td">承办律师：</td>
										<td class="td">${cont.clearclear.cclawname}</td>
									</tr>
									<tr>
										<td align="right" class="td">律师电话：</td>
										<td class="td">${cont.clearclear.cclawnametel }</td>
									</tr>
									<tr>
										<td align="right" class="td">协办人员：</td>
										<td class="td">${cont.clearclear.assistingName}</td>
									</tr>
									<tr>
										<td align="right" class="td">协办联系方式：</td>
										<td class="td">${cont.clearclear.assistingTel}</td>
									</tr>
									<tr>
										<td align="right" class="td">管辖法院：</td>
										<td class="td">${cont.clearclear.competentCourt}</td>
									</tr>
									<tr>
										<td align="right" class="td">案件进展：</td>
										<td class="td">${cont.clearclear.ccfollowupresult }</td>
									</tr>
									<tr>
										<td align="right" class="td">备注：</td>
										<td class="td">${cont.clearclear.ccremark }</td>
									</tr>
									<tr>
										<td align="right" class="td">附件：</td>
										<td class="td"><a
											href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.clearclear.ccattach}">
											${cont.clearclear.ccattach}</a>
										</td>
									</tr>
									<tr>
										<td align="right" class="td">记录人员：</td>
										<td class="td">${cont.clearclear.users.UName }</td>
									</tr>
									<tr>
										<td align="right" class="td">记录时间：</td>
										<td class="td">${cont.clearclear.ccsaveTime }</td>
									</tr>
									<tr>
										<td class="td" align="right"><b>可执行操作</b>：</td>
										<td class="td"><a href="javascript:void(0);"
											onclick="showdiv('${cont.clearclear.cclawname}','${cont.clearclear.cclawnametel}')">短信提醒</a>
											&nbsp;&nbsp;&nbsp;&nbsp; <a
											href="selectclearclear.action?casecodeself=${cont.clearrecord.crcasecodeself}"
											target="_blank">查看更多</a></td>
									</tr>
									<tr>
										<td class="td" align="right">
											<%-- <a href="/lawyer/user/lawCase/insertclearclear.jsp?Casecodeself=${cont.csCasecodeself }">继续添加</a> --%>
											<a href="showclearclear.action?casecodeself=${cont.csCasecodeself }">继续添加</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr class="title">
							<td colspan="6">&nbsp;&nbsp;<img
								src="/lawyer/images/flag2_16x16.gif" />&nbsp;诉讼阶段</td>
						</tr>
						cont.litigation
						<!--二层if - -->
						<s:if test="cont.litigation!=null">
							<tr>
								<td class="padding_td" valign="top" colspan="6">
									<table cellpadding="0" cellspacing="0" width="100%" border="0"
										class="step_table">
										<tr>
											<td align="right" class="td" width="30%">立案案号：</td>
											<td class="td">${cont.litigation.linumber}</td>
										</tr>
										<tr>
											<td align="right" class="td" width="15%">诉讼时间：</td>
											<td class="td">${cont.litigation.lidate}</td>
										</tr>
										<tr>
											<td align="right" class="td">诉讼费用：</td>
											<td class="td">${cont.litigation.lifund }</td>
										</tr>

										<tr>
											<td align="right" class="td">承办法官：</td>
											<td class="td">${cont.litigation.lijudge }</td>
										</tr>
										<tr>
											<td align="right" class="td">法官联系电话：</td>
											<td class="td">${cont.litigation.lijudgetel }</td>
										</tr>
										<tr>
											<td align="right" class="td">承办律师：</td>
											<td class="td">${cont.litigation.lilawname }</td>
										</tr>
										<tr>
											<td align="right" class="td">律师联系电话：</td>
											<td class="td">${cont.litigation.lilawtel }</td>
										</tr>
										<tr>
											<td align="right" class="td">协办人员：</td>
											<td class="td">${cont.litigation.assistingName}</td>
										</tr>
										<tr>
											<td align="right" class="td">协办联系方式：</td>
											<td class="td">${cont.litigation.assistingTel}</td>
										</tr>
										<tr>
											<td align="right" class="td">管辖法院：</td>
											<td class="td">${cont.litigation.competentCourt}</td>
										</tr>
										<tr>
											<td align="right" class="td">案件进展：</td>
											<td class="td">${cont.litigation.lifollowupresult }</td>
										</tr>
										<tr>
											<td align="right" class="td">备注：</td>
											<td class="td">${cont.litigation.liremark }</td>
										</tr>
										<tr>
											<td align="right" class="td">附件：</td>
											<td class="td"><a
												href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.litigation.liattach}">
												${cont.litigation.liattach}</a>
											</td>
										</tr>
										<tr>
											<td align="right" class="td">记录人员：</td>
											<td class="td">${cont.litigation.users.UName }</td>
										</tr>
										<tr>
											<td align="right" class="td">记录时间：</td>
											<td class="td">${cont.litigation.lisaveTime }</td>
										</tr>
										<tr>
											<td class="td" align="right"><b>可执行操作</b>：</td>
											<td class="td"><a href="javascript:void(0);"
												onclick="showdiv('${cont.litigation.lilawname}','${cont.litigation.lilawtel}')">短信提醒</a>
												&nbsp;&nbsp;&nbsp;&nbsp; <a
												href="selectlitigation.action?casecodeself=${cont.clearrecord.crcasecodeself}"
												target="_blank">查看更多</a></td>
										</tr>
										<tr>
											<td class="td" align="right">
												<a href="showlitigation.action?casecodeself=${cont.csCasecodeself }">继续添加</a>
											<%-- <a href="/lawyer/user/lawCase/insertlitigation.jsp?Casecodeself=${cont.csCasecodeself }">继续添加</a> --%>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="title">
								<td colspan="6">&nbsp;&nbsp;<img
									src="/lawyer/images/flag2_16x16.gif" />&nbsp;执行阶段</td>
							</tr>
							<!--三层if - -->
							<s:if test="cont.execute!=null">
								<tr>
									<td class="padding_td" valign="top" colspan="6">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" class="td" width="15%">立案案号：</td>
												<td class="td">${cont.execute.exnumber}</td>
											</tr>
											<tr>
												<td align="right" class="td" width="15%">执行时间：</td>
												<td class="td">${cont.execute.exdate}</td>
											</tr>
											<tr>
												<td align="right" class="td">承办法官：</td>
												<td class="td">${cont.execute.exjudge}</td>
											</tr>
											<tr>
												<td align="right" class="td">法官联系电话</td>
												<td class="td">${cont.execute.exjudgetel}</td>
											</tr>
											<tr>
												<td align="right" class="td">承办律师：</td>
												<td class="td">${cont.execute.exlawname }</td>
											</tr>
											<tr>
												<td align="right" class="td">律师联系电话：</td>
												<td class="td">${cont.execute.exlawtel }</td>
											</tr>
											<tr>
												<td align="right" class="td">协办人员：</td>
												<td class="td">${cont.execute.assistingName}</td>
											</tr>
											<tr>
												<td align="right" class="td">协办联系方式：</td>
												<td class="td">${cont.execute.assistingTel}</td>
											</tr>
											<tr>
												<td align="right" class="td">管辖法院：</td>
												<td class="td">${cont.execute.competentCourt}</td>
											</tr>
											<tr>
												<td align="right" class="td">执行标的额：</td>
												<td class="td">${cont.execute.execMoney}</td>
											</tr>
											<tr>
												<td align="right" class="td">案件进展：</td>
												<td class="td">${cont.execute.exfollowupresult }</td>
											</tr>
											<tr>
												<td align="right" class="td">备注：</td>
												<td class="td">${cont.execute.exremark }</td>
											</tr>
											<tr>
												<td align="right" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.execute.exattach}">
													${cont.execute.exattach}</a>
												</td>
											</tr>
											<tr>
												<td align="right" class="td">记录人员：</td>
												<td class="td">${cont.execute.users.UName }</td>
											</tr>
											<tr>
												<td align="right" class="td">记录时间：</td>
												<td class="td">${cont.execute.exsavetime }</td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td"><a href="javascript:void(0);"
													onclick="showdiv('${cont.execute.exlawname}','${cont.execute.exlawtel}')">短信提醒</a>
													&nbsp;&nbsp;&nbsp;&nbsp; <a
													href="selectexecute.action?casecodeself=${cont.clearrecord.crcasecodeself}"
													target="_blank">查看更多</a></td>
											</tr>
											<tr>
												<td class="td" align="right">
													<a href="showexecute.action?casecodeself=${cont.csCasecodeself }">继续添加</a>
													<%-- <a href="/lawyer/user/lawCase/insertexecute.jsp?Casecodeself=${cont.csCasecodeself }">继续添加</a> --%>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr class="title">
									<td colspan="6">&nbsp;&nbsp;<img
										src="/lawyer/images/flag2_16x16.gif" />&nbsp;结案阶段</td>
								</tr>
								<s:if test="cont.closerecord!=null">
									<tr class="title">
										<td class="padding_td" valign="top" colspan="6">
											<table cellpadding="0" cellspacing="0" width="100%"
												border="0" class="step_table">
												<tr>
													<td align="right" class="td" width="15%">结案时间：</td>
													<td class="td">${cont.closerecord.crtime }</td>
												</tr>
												<tr>
													<td align="right" class="td">结案人：</td>
													<td class="td">${cont.closerecord.crperson}</td>
												</tr>
												<tr>
													<td align="right" class="td">结案人电话：</td>
													<td class="td">${cont.closerecord.crpersontel}</td>
												</tr>

												<tr>
													<td align="right" class="td">备注：</td>
													<td class="td">${cont.closerecord.crremark }</td>
												</tr>
												<tr>
													<td align="right" class="td">附件：</td>
													<td class="td"><a
														href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.closerecord.crattach}">
														${cont.closerecord.crattach}</a>
													</td>
												</tr>
												<tr>
													<td align="right" class="td">记录人员：</td>
													<td class="td">${cont.closerecord.users.UName }</td>
												</tr>
												<tr>
													<td align="right" class="td">记录时间：</td>
													<td class="td">${cont.closerecord.crsavetime }</td>
												</tr>

												<tr>
													<td class="td" align="right"><b>可执行操作</b>：</td>
													<td class="td"><a
														href="javascript:alert('业务不支持修改操作');">修改</a>&nbsp;&nbsp; <a
														href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a>
													</td>
												</tr>
											</table>
										</td>
									</tr>

								</s:if>
								<s:else>
									<td colspan="6" width="35%"><a
										href="/lawyer/user/lawCase/insertclareclose.jsp?Casecodeself=${cont.csCasecodeself }">点击添加</a>
									</td>
								</s:else>

							</s:if>
							<s:else>
								<tr>
									<td colspan="6" width="35%"><a
										href="/lawyer/user/lawCase/insertexecute.jsp?Casecodeself=${cont.csCasecodeself }">点击添加</a>
									</td>
								</tr>
								<tr class="title">
									<td colspan="6">&nbsp;&nbsp;<img
										src="/lawyer/images/flag2_16x16.gif" />&nbsp;结案阶段</td>
								</tr>
								<tr align="left">
									<td colspan="6">不可操作</td>
								</tr>
							</s:else>

						</s:if>
						<!-- 二层if结束 -->
						<!-- 二层else -->
						<s:else>
							<tr>
								<td colspan="6" width="35%"><a
									href="/lawyer/user/lawCase/insertlitigation.jsp?Casecodeself=${cont.csCasecodeself }">点击添加</a>
								</td>

							</tr>
							<tr class="title">
								<td colspan="6">&nbsp;&nbsp;<img
									src="/lawyer/images/flag2_16x16.gif" />&nbsp;执行阶段</td>
							</tr>

							<tr align="left">
								<td colspan="6">不可操作</td>

							</tr>

							<tr align="left">
								<td colspan="6"><b>结案阶段</b></td>

							</tr>
							<tr>
								<td class="padding_td" valign="top" colspan="3">不可操作</td>
							</tr>

						</s:else>
					</s:if>
					<!--一层if结束 -->

					<s:else>
						<tr class="title">
							<s:if test="cont.clearrecord!=null">
								<td class="padding_td" valign="top" colspan="3">

									<table cellpadding="0" cellspacing="0" width="100%" border="0"
										class="step_table">
										<tr>
											<td align="right" class="td" width="40%">材料递交时间：</td>
											<td class="td">${cont.clearrecord.crdate }</td>
										</tr>
										<tr>
											<td align="right" class="td">立案案号：</td>
											<td class="td">${cont.clearrecord.crnumber }</td>
										</tr>

										<tr>
											<td align="right" class="td">联系法官：</td>
											<td class="td">${cont.clearrecord.crcontactjudge }</td>
										</tr>
										<tr>
											<td align="right" class="td">法官电话：</td>
											<td class="td">${cont.clearrecord.crcontacttel}</td>
										</tr>

										<tr>
											<td align="right" class="td">承办律师：</td>
											<td class="td">${cont.clearrecord.crlawname}</td>
										</tr>
										<tr>
											<td align="right" class="td">律师电话：</td>
											<td class="td">${cont.clearrecord.crlawtel}</td>
										</tr>
										<tr>
											<td align="right" class="td">协办人员：</td>
											<td class="td">${cont.clearrecord.assistingName}</td>
										</tr>
										<tr>
											<td align="right" class="td">协办联系方式：</td>
											<td class="td">${cont.clearrecord.assistingTel}</td>
										</tr>
										<tr>
											<td align="right" class="td">管辖法院：</td>
											<td class="td">${cont.clearrecord.competentCourt}</td>
										</tr>
										<tr>
											<td align="right" class="td">案件进展：</td>
											<td class="td">${cont.clearrecord.crfollowupresult }</td>
										</tr>
										<tr>
											<td align="right" class="td">备注：</td>
											<td class="td">${cont.clearrecord.crremark }</td>
										</tr>
										<tr>
											<td align="right" class="td">附件：</td>
											<td class="td"><a
												href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.clearrecord.crattach}">
												${cont.clearrecord.crattach}</a></td>
										</tr>
										<tr>
											<td align="right" class="td">记录人员：</td>
											<td class="td">${cont.clearrecord.users.UName }</td>
										</tr>
										<tr>
											<td align="right" class="td">记录时间：</td>
											<td class="td">${cont.clearrecord.crSaveTime }</td>
										</tr>
										<tr>
											<td class="td" align="right"><b>可执行操作</b>：</td>
											<td class="td"><a href="javascript:void(0);"
												onclick="showdiv('${cont.clearrecord.crlawname}','${cont.clearrecord.crlawtel}')">短信提醒</a>
												&nbsp;&nbsp;&nbsp;&nbsp; <a
												href="selectclearrecord.action?casecodeself=${cont.clearrecord.crcasecodeself}"
												target="_blank">查看更多</a></td>
										</tr>
										<tr>
											<td class="td" align="right">
												<a href="showclearrecord.action?casecodeself=${cont.csCasecodeself }">继续添加</a>
											<%-- <a href="/lawyer/user/lawCase/insertclearrecord.jsp?Casecodeself=${cont.csCasecodeself }">继续添加</a> --%>
											</td>
										</tr>
									</table>
								</td>
							</s:if>
							<s:else>
								<td colspan="3" width="50%" align="center"><a
									href="/lawyer/user/lawCase/insertclearrecord.jsp?Casecodeself=${cont.csCasecodeself }">点击添加</a>
								</td>
							</s:else>
							<s:if test="cont.clearclear!=null">
								<td class="padding_td" valign="top" colspan="3" align="right">
									<table cellpadding="0" cellspacing="0" width="100%" border="0"
										class="step_table" align="right">
										<tr>
											<td align="right" class="td" width="30%">立案案号：</td>
											<td class="td">${cont.clearclear.ccnumber}</td>
										</tr>
										<tr>
											<td align="right" class="td" width="30%">承办法官：</td>
											<td class="td">${cont.clearclear.ccjudge}</td>
										</tr>
										<tr>
											<td align="right" class="td">法官电话：</td>
											<td class="td">${cont.clearclear.ccjudgetel }</td>
										</tr>
										<tr>
											<td align="right" class="td" width="15%">承办律师：</td>
											<td class="td">${cont.clearclear.cclawname}</td>
										</tr>
										<tr>
											<td align="right" class="td">律师电话：</td>
											<td class="td">${cont.clearclear.cclawnametel }</td>
										</tr>
										<tr>
											<td align="right" class="td">协办人员：</td>
											<td class="td">${cont.clearclear.assistingName}</td>
										</tr>
										<tr>
											<td align="right" class="td">协办联系方式：</td>
											<td class="td">${cont.clearclear.assistingTel}</td>
										</tr>
										<tr>
											<td align="right" class="td">管辖法院：</td>
											<td class="td">${cont.clearclear.competentCourt}</td>
										</tr>
										<tr>
											<td align="right" class="td">案件进展：</td>
											<td class="td">${cont.clearclear.ccfollowupresult }</td>
										</tr>
										<tr>
											<td align="right" class="td">备注：</td>
											<td class="td">${cont.clearclear.ccremark }</td>
										</tr>
										<tr>
											<td align="right" class="td">附件：</td>
											<td class="td"><a
												href="downFile.action?filePath=/fileUploads/anjian/&filename=${cont.clearclear.ccattach}">
												${cont.clearclear.ccattach}</a>
											</td>
										</tr>
										<tr>
											<td align="right" class="td">记录人员：</td>
											<td class="td">${cont.clearclear.users.UName }</td>
										</tr>
										<tr>
											<td align="right" class="td">记录时间：</td>
											<td class="td">${cont.clearclear.ccsaveTime }</td>
										</tr>
										<tr>
											<td class="td" align="right"><b>可执行操作</b>：</td>
											<td class="td"><a href="javascript:void(0);"
												onclick="showdiv('${cont.clearclear.cclawname}','${cont.clearclear.cclawnametel}')">短信提醒</a>
												&nbsp;&nbsp;&nbsp;&nbsp; <a
												href="selectclearclear.action?casecodeself=${cont.clearrecord.crcasecodeself}"
												target="_blank">查看更多</a></td>
										</tr>
										<tr>
											<td class="td" align="right">
												<a href="showclearclear.action?casecodeself=${cont.csCasecodeself }">继续添加</a>
											<%-- <a href="/lawyer/user/lawCase/insertclearclear.jsp?Casecodeself=${cont.csCasecodeself }">继续添加</a> --%>
											</td>
										</tr>
									</table>
								</td>
							</s:if>
							<s:else>
								<td colspan="3" align="center"><a
									href="/lawyer/user/lawCase/insertclearclear.jsp?Casecodeself=${cont.csCasecodeself }">点击添加</a>
								</td>
							</s:else>
						</tr>
						<tr class="title">
							<td colspan="6">&nbsp;&nbsp;<img
								src="/lawyer/images/flag2_16x16.gif" />&nbsp;诉讼阶段</td>
						</tr>
						<tr align="left">
							<td colspan="6">不可操作</td>
						</tr>


						<tr class="title">
							<td colspan="6">&nbsp;&nbsp;<img
								src="/lawyer/images/flag2_16x16.gif" />&nbsp;执行阶段</td>
						</tr>
						<tr align="left">
							<td colspan="6">不可操作</td>
						</tr>
						<tr class="title">
							<td colspan="6">&nbsp;&nbsp;<img
								src="/lawyer/images/flag2_16x16.gif" />&nbsp;结案阶段</td>
						</tr>
						<tr align="left">
							<td colspan="6">不可操作</td>
						</tr>
					</s:else>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>