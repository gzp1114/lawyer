package com.lawyer.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplierinfoNetworkService;
import com.opensymphony.xwork2.ActionSupport;

public class ApplierinfoNetworkAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ApplierinfoNetwork applierinfoNetwork;
	private List<ApplierinfoNetwork> appnets;
	private ApplierinfoNetworkService appNetService;
	private String caseId;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public List<ApplierinfoNetwork> getAppnets() {
		return appnets;
	}

	public void setAppnets(List<ApplierinfoNetwork> appnets) {
		this.appnets = appnets;
	}

	public ApplierinfoNetworkService getAppNetService() {
		return appNetService;
	}

	public void setAppNetService(ApplierinfoNetworkService appNetService) {
		this.appNetService = appNetService;
	}

	public ApplierinfoNetwork getApplierinfoNetwork() {
		return applierinfoNetwork;
	}

	public void setApplierinfoNetwork(ApplierinfoNetwork applierinfoNetwork) {
		this.applierinfoNetwork = applierinfoNetwork;
	}

	/**
	 * �޸� ������--���粿��
	 * 
	 */
	public String update() {
		try {
			this.appNetService.updateAppnet(applierinfoNetwork);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * ɾ�� ������--���粿��
	 * 
	 */
	public String delete() {
		try {
			this.appNetService.deleteAppnet(applierinfoNetwork);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * ��Դ������--�������ִ������ҵ��Ϣ --������Ϣ ��־��
	 * 
	 * @return
	 */
	public String insert() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			System.out.println("��ʼ�������ִ������ҵ��Ϣ--������Ϣ");
			Users admin = (Users) session.getAttribute("admin");
			applierinfoNetwork.setUsers(admin);
			applierinfoNetwork.setAnSavetime(sdf.format(new Date()));
			this.appNetService.insertAppnet(applierinfoNetwork);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String insertAppnetOne(){
		try {
			this.appNetService.insertAppnetOne(applierinfoNetwork);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * ����������ִ������ҵ��Ϣ��������Ϣ��������־��
	 * 
	 * @return
	 */
	public String insertMore() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users user = (Users) session.getAttribute("admin");
		try {
			this.appNetService.insertAppNets(user);

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("������������ɣ�");
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public String selectAllAppNet() {
		try {
			appnets = this.appNetService.selectAppnet(applierinfoNetwork);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
