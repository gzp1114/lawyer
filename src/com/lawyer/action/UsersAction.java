package com.lawyer.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.LimitPower;
import com.lawyer.pojo.Log;
import com.lawyer.pojo.PageBean;
import com.lawyer.pojo.Users;
import com.lawyer.service.LimitPowerService;
import com.lawyer.service.LogService;
import com.lawyer.service.PageService;
import com.lawyer.service.UsersService;
import com.lawyer.tools.ObjAndList2Json;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	//��װ��limitpower�����ӿ�
	private LimitPowerService lpService;
	//:��װ��Users�����ӿ�
	private UsersService usersService;
	//:��װ����ͨ�û���Users����
	private Users users;
	//:��װ�Ĺ���Ա��Users����
	private Users admin;
	
	
	public LimitPowerService getLpService() {
		return lpService;
	}

	public void setLpService(LimitPowerService lpService) {
		this.lpService = lpService;
	}

	public Users getAdmin() {
		return admin;
	}

	public void setAdmin(Users admin) {
		this.admin = admin;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public UsersService getUsersService() {
		return usersService;
	}
	//�û���Ӧ��Ȩ�޶���
	private LimitPower lp;
	
	public LimitPower getLp() {
		return lp;
	}

	public void setLp(LimitPower lp) {
		this.lp = lp;
	}
	//�������
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * �����û�����ѯ�û���Ȩ��
	 */
	public String findlp(){
		lp = lpService.findLPByUserName(lp.getLp_user_name());
		return SUCCESS;
	}
	/**
	 * �޸��û�Ȩ��
	 * @return
	 */
	public String updlp(){
		lpService.updLP(lp);
		result="�û�Ȩ�ޱ���ɹ���";
		return SUCCESS;
	}
	/**
	 * ����Ա���û���½��֤����
	 * */
	public String login() {
		//:�õ�һ��Session����
		HttpSession session=ServletActionContext.getRequest().getSession();
		try {
			admin=usersService.login(admin);
			if(admin!=null){
		//		System.out.println(admin+"=============>"+admin.getURole());
				if(admin.getURole().equals("����Ա")){
					session.setAttribute("admin", admin);
					return "admin";
				}else {
					if(admin.getUSta().equals("����")){
						//��ѯ�û���Ȩ�޷���session�� 
						LimitPower userlp = lpService.findLPByUserName(admin.getUName());
						session.setAttribute("admin", admin);
						session.setAttribute("userlp", userlp);
						return "users";
					}else{
						return "fali";
					}
				}
			}else{
				return "fali";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fali";
		}
	}

	/**
	 * ����Ա���û��˳�����
	 * */
	public String quit(){
		try {
			ServletActionContext.getRequest().getSession().setAttribute("admin", null);
			ServletActionContext.getRequest().getSession().setAttribute("userlp", null);
			return "quit";
		} catch (Exception e) {
			e.printStackTrace();
			return "quit";
		}
	}
	
	/**
	 * ����Ա����û������������ɲ�ѯ�����û���Ϣ����ת��SHOWҳ�棬��ҳ��ʾ
	 * */
	public String insert(){
		try {
			//:����Ա����û���¼
			admin = usersService.SelectID(admin);
			usersService.insert(users);
			//Ϊ�û���Ӷ�Ӧ��Ȩ��
			lpService.addLP(new LimitPower(users.getUName(),"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"));
			
			/**
			 * �����ɺ󣬵������û���ʾҳ��
			 * */
			pageBean=pageService.queryForPage(5,page,"Users","UId","where UName <> 'admin'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}

	/**
	 * ��ҳ��ʾ�����û���Ϣ������
	 * */
	public String SelectShow(){
		try {
			//:����Ա��ѯ�û���¼
			admin = (Users) ServletActionContext.getRequest().getSession().getAttribute("admin");

			pageBean=pageService.queryForPage(10,page,"Users","UId","where UName <> 'admin'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}
	
	/**
	 * ͨ���û���ģ����ѯ
	 * */
	public String selectName(){
		try {
			//:����Ա��ѯ�û���¼
			list=usersService.selectName(users);
			return "usersShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersShow";
		}
	}
	/**
	 * ����Ա�޸��û���Ϣ(1),ͨ�����͵�Ҫ�޸��û�ID���õ��û�������Ϣ�����͵��޸�ҳ��
	 * */
	public String update1(){
		try {
			users=usersService.SelectID(users);
			return "update1";
		} catch (Exception e) {
			e.printStackTrace();
			return "update1";
		}
	} 
	/**
	 * ����Ա�޸��û���Ϣ(2),�޸��û���Ϣ����ɺ�ģ����ѯ�û���Ϣ����ת��SHOWҳ�棬��ҳ��ʾ
	 * */
	public String update2(){
		try {
			usersService.update(users);
			list=usersService.selectName(users);
			return "usersShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersShow";
		}
	}
	/**
	 * ͨ��IDɾ���û���Ϣ
	 * */
	public String delete(){
		
		try {
			users=usersService.SelectID(users);
			//ɾ���û�Ȩ��
			lpService.removeLP(lpService.findLPByUserName(users.getUName()));
			usersService.delete(users);
			pageBean=pageService.queryForPage(5,page,"Users","UId","where UName <> 'admin'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}
	/**
	 * ͨ��ID�޸��û��˺�״̬
	 * */
	public String updateUSta(){
		try {
			
			users=usersService.SelectID(users);
			if(users.getUSta().equals("����")){
				users.setUSta("����");
			}else{
				users.setUSta("����");
			}
			usersService.update(users);
			list=usersService.selectName(users);
			return "usersShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersShow";
		}
	}
	
	/**
	 * ��ҳ��ʾ�����û���Ϣ������
	 * @throws Exception 
	 * */
	public String selectLawyers() throws Exception{
		List<Users> lawuers = usersService.selectLawyers();
		
		String jsonarr = ObjAndList2Json.list2jsonarr(lawuers);
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonarr);
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * ��ҳ��ʾ�����û���Ϣ������
	 * @throws Exception 
	 * */
	public String selectPensons() throws Exception{
		List<Users> lawuers = usersService.selectPensons();
		
		String jsonarr = ObjAndList2Json.list2jsonarr(lawuers);
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonarr);
		out.flush();
		out.close();
		return null;
	}
}