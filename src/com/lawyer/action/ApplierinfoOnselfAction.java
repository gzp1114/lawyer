package com.lawyer.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.Addrecord;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Users;
import com.lawyer.service.AddRecordService;
import com.lawyer.service.ApplierinfoOnselfService;
import com.opensymphony.xwork2.ActionSupport;

public class ApplierinfoOnselfAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private ApplierinfoOnself applierinfoOnself = null;
	private ApplierinfoOnselfService applierinfoOnselfService = null;
	private AddRecordService ars;		//record�����service��
	private Addrecord record = new Addrecord();			//��װAddrecord����
	private String caseId;
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public AddRecordService getArs() {
		return ars;
	}
	public void setArs(AddRecordService ars) {
		this.ars = ars;
	}
	public Addrecord getRecord() {
		return record;
	}
	public void setRecord(Addrecord record) {
		this.record = record;
	}
	public ApplierinfoOnself getApplierinfoOnself() {
		return applierinfoOnself;
	}
	public void setApplierinfoOnself(ApplierinfoOnself applierinfoOnself) {
		this.applierinfoOnself = applierinfoOnself;
	}
	public ApplierinfoOnselfService getApplierinfoOnselfService() {
		return applierinfoOnselfService;
	}
	public void setApplierinfoOnselfService(
			ApplierinfoOnselfService applierinfoOnselfService) {
		this.applierinfoOnselfService = applierinfoOnselfService;
	}
	
	/**
	 * ��Դ������--�������ִ������ҵ��Ϣ --������Ϣ
	 * ��־��
	 * @return
	 */
	public String insertAppOnself(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			System.out.println("��ʼ�������ִ������ҵ��Ϣ--������Ϣ");
			Users admin=(Users) session.getAttribute("admin");
			System.out.println(admin.getUId());
			applierinfoOnself.setUsers(admin);
			applierinfoOnself.setAoSavetime(sdf.format(new Date()));
			if(applierinfoOnself!=null){
				this.applierinfoOnselfService.insertAppOnself(applierinfoOnself);
				return SUCCESS;
			}else{
				return "filed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
