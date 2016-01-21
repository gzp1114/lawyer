package com.lawyer.action;

import java.util.List;

import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Log;
import com.lawyer.pojo.PageBean;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplyService;
import com.lawyer.service.LogService;
import com.lawyer.service.PageService;
import com.lawyer.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport{
	//:��װ��Apply����Service�ӿ�
	private ApplyService applyService;
	//:��װ��Apply����
	private Apply apply;
	
	//:��װ��Users�����ӿ�
	private UsersService usersService;
	//:��װ����ͨ�û���Users����
	private Users users;
	//:��װ�Ĺ���Ա��Users����
	private Users admin;
	//:��װ��Log�����ӿ�
	private LogService logService;
	//:��װ��Log����
	private Log log;
	
	//:��װ��List����
	private List list;
	/**
	 * ͨ�÷�ҳ�������÷�װ����
	 * ������
	 * */
	private PageService pageService;
	private PageBean pageBean;
	private int page;
	public ApplyService getApplyService() {
		return applyService;
	}
	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}
	public Apply getApply() {
		return apply;
	}
	public void setApply(Apply apply) {
		this.apply = apply;
	}
	public UsersService getUsersService() {
		return usersService;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Users getAdmin() {
		return admin;
	}
	public void setAdmin(Users admin) {
		this.admin = admin;
	}
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public PageService getPageService() {
		return pageService;
	}
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * ��ѯ�����û���־��¼����ҳ��ʾ
	 * ������
	 * */
	public String showUsersLog(){
		try {
			//:����Ա��ѯ�����û�������Ϣ��¼
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("��ѯ");
			log.setLogTarget("�����û�������Ϣ");
			logService.insert(log);
			
			pageBean=pageService.queryForPage(5,page,"Log","logId","where logUrole = '��ͨ�û�'");
			return "usersLog";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersLog";
		}
	}
	/**
	 * ͨ���û����Ժ���ѯ�û���־��¼
	 * ������
	 * */
	public String selectUsersName(){
		//:����Ա��ѯ�����û�������Ϣ��¼
		try {
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("ģ����ѯ");
			log.setLogTarget("�û�������Ϣ");
			logService.insert(log);
			
			list=logService.selectUsersName(users);
			return "usersName";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersName";
		}
	}
	/**
	 * ��ѯ���й���Ա��־��¼����ҳ��ʾ
	 * ������
	 * */
	public String showAdminLog(){
		//:����Ա��ѯ�����û�������Ϣ��¼
		try {
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("��ѯ");
			log.setLogTarget("���й���Ա������Ϣ");
			logService.insert(log);
			
			pageBean=pageService.queryForPage(5,page,"Log","logId","where logUrole = '����Ա'");
			return "adminLog";
		} catch (Exception e) {
			e.printStackTrace();
			return "adminLog";
		}
	}
	/**
	 * ͨ���û����Ժ���ѯ�û���־��¼
	 * ������
	 * */
	public String selectAdminName(){
		//:����Ա��ѯ�����û�������Ϣ��¼
		try {
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("ģ����ѯ");
			log.setLogTarget("����Ա������Ϣ");
			logService.insert(log);
			
			list=logService.selectUsersName2(users);
			return "adminName";
		} catch (Exception e) {
			e.printStackTrace();
			return "adminName";
		}
	}
	
}
