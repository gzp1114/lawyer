package com.lawyer.pojo;

import java.io.Serializable;

public class DishonestyCourt implements Serializable {
	
	private Integer id;
	private String caseId;
	private String iname;			//��ִ��������/����
	private String cardNum;			//���֤����/��֯��������
	private String courtName;		//ִ�з�Ժ
	private String gistId;			//ִ�������ĺţ���������ţ�
	private String regDate;			//����ʱ��
	private String caseCode;		//����
	private String performance;		//��ִ���˵��������������״̬��
	private String publishDate;		//����ʱ�䣨����ʱ�䣩
	private String  duty;			//��Ч��������ȷ�������񣨱�ע��
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public String getGistId() {
		return gistId;
	}
	public void setGistId(String gistId) {
		this.gistId = gistId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getCaseCode() {
		return caseCode;
	}
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	
	
}