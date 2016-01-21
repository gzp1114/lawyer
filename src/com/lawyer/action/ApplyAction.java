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

public class ApplyAction extends ActionSupport{
	
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
	
	
	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
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

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public ApplyService getApplyService() {
		return applyService;
	}

	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}
	
	/**
	 * ��ҳ��ʾ�����û�������Ϣ
	 * ������
	 * */
	public String selectShow(){
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
			pageBean=pageService.queryForPage(5,page,"Apply","appId","where appSta = '������'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}
	/**
	 *ͨ���û���ģ����ѯ������Ϣ(***********************************************)
	 *������
	 * */
	public String selectName(){
		try {
			//:����Ա��ѯ�����û�������Ϣ��¼
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("ģ����ѯ");
			log.setLogTarget("�û�������Ϣ");
			logService.insert(log);
			
			list=applyService.selectName(users);
			return "applyShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "applyShow";
		}
	}
	/**
	 * ͨ���û�ID��׼��Ȩ
	 * ������
	 * */
	public String authorize(){
		//:����Ա��ѯ�����û�������Ϣ��¼
		try {
			admin= usersService.SelectID(admin);
			users=usersService.SelectID(users);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("��׼");
			log.setLogTarget("�û�"+users.getUName()+"������");
			logService.insert(log);
			
			apply=applyService.selectID(apply);
			apply.setAppSta("����׼");
			applyService.authorize(apply);
			list=applyService.selectName(users);
			return "authorize";
		} catch (Exception e) {
			e.printStackTrace();
			return "authorize";
		}
	}
	/**
	 * ͨ���û�ID�ܾ���Ȩ
	 * ������
	 * */
	public String decline(){
		//:����Ա��ѯ�����û�������Ϣ��¼
		try {
			admin= usersService.SelectID(admin);
			users=usersService.SelectID(users);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("�ܾ�");
			log.setLogTarget("�û�"+users.getUName()+"������");
			logService.insert(log);
			
			apply=applyService.selectID(apply);
			applyService.decline(apply);
			list=applyService.selectName(users);
			return "decline";
		} catch (Exception e) {
			e.printStackTrace();
			return "decline";
		}
	}
	/**
	 * ��ѯ�û�����Ȩ��
	 * ������
	 * */
	public String declineShow(){
		try {
			//:����Ա��ѯ�����û�������Ϣ��¼
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("��ѯ");
			log.setLogTarget("�����û�Ȩ����Ϣ");
			logService.insert(log);
			pageBean=pageService.queryForPage(5,page,"Apply","appId","where appSta = '����׼'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}
	/**
	 *ͨ���û���ģ����ѯ������Ϣ2(***********************************************)
	 *������
	 * */
	public String selectName2(){
		try {
			//:����Ա��ѯ�����û�������Ϣ��¼
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("ģ����ѯ");
			log.setLogTarget("�û�Ȩ����Ϣ");
			logService.insert(log);
			
			list=applyService.selectName2(users);
			System.out.println(list);
			return "applyShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "applyShow";
		}
	}
	/**
	 * ͨ���û�ID�ܾ���Ȩ
	 * ������
	 * */
	public String declineUsers(){
		//:����Ա��ѯ�����û�������Ϣ��¼
		try {
			admin= usersService.SelectID(admin);
			users=usersService.SelectID(users);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("�ջ�");
			log.setLogTarget("�û�"+users.getUName()+"��Ȩ��");
			logService.insert(log);
			
			apply=applyService.selectID(apply);
			applyService.decline(apply);
			pageBean=pageService.queryForPage(5,page,"Apply","appId","where appSta = '����׼'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}

}
