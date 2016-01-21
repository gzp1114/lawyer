package com.lawyer.action;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.stronginfo.core.jdbc.DBConnection;
import cn.com.stronginfo.core.jdbc.DBConnectionHelper;

import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;
import com.lawyer.service.AddRecordService;
import com.lawyer.service.ExecutebusinessService;
import com.opensymphony.xwork2.ActionSupport;

public class ExecutebusinessAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Executebusiness  executebus;
	private ExecutebusinessService  executebusService;
	private AddRecordService ars;		//record�����service��
	private File upd;// �ϴ����ļ��ڻ���
	private String updFileName;// �ļ���
	private String updContentType;// �ļ�����
	List<Executebusiness> businlist;
	String caseId;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public List<Executebusiness> getBusinlist() {
		return businlist;
	}
	public void setBusinlist(List<Executebusiness> businlist) {
		this.businlist = businlist;
	}
	public File getUpd() {
		return upd;
	}
	public void setUpd(File upd) {
		this.upd = upd;
	}
	public String getUpdFileName() {
		return updFileName;
	}
	public void setUpdFileName(String updFileName) {
		this.updFileName = updFileName;
	}
	public String getUpdContentType() {
		return updContentType;
	}
	public void setUpdContentType(String updContentType) {
		this.updContentType = updContentType;
	}
	public AddRecordService getArs() {
		return ars;
	}
	public void setArs(AddRecordService ars) {
		this.ars = ars;
	}
	public ExecutebusinessService getExecutebusService() {
		return executebusService;
	}
	public void setExecutebusService(ExecutebusinessService executebusService) {
		this.executebusService = executebusService;
	}
	public Executebusiness getExecutebus() {
		return executebus;
	}
	public void setExecutebus(Executebusiness executebus) {
		this.executebus = executebus;
	}
	
	/*
	 * excel���뱻ִ������Ϣ
	 */
	public String excelInsertExecutebusiness(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		Connection conn = null;
		try {
			if(updFileName != null){
				String path = basePath+"\\impExcel\\"+updFileName;
				FileUtils.copyFile(upd, new File(path));
				
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String dburl = "driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ=" + path;
				String connectionString = "jdbc:odbc:" + dburl;
				conn = DriverManager.getConnection(connectionString);
				Statement stmt = conn.createStatement();
				ResultSet  rs = stmt.executeQuery("select * from [sheet1$]");
				// ��ȡ������cnName��
				// ��ȡ����
				List<Executebusiness> dataList = new ArrayList<Executebusiness>();
				while (rs.next()) {
					String pname = rs.getString("����");
					String address = rs.getString("ס��");
					String status = rs.getString("��ҵ״̬");
					String exception = rs.getString("��Ӫ�쳣��¼");
					
					Executebusiness executebusiness = new Executebusiness();
					executebusiness.setEName(pname);
					executebusiness.setEAddress(address);
					executebusiness.setException(exception);
					if(status != null && !status.equals("")){
						executebusiness.setEStatus(status);
					}
					
					dataList.add(executebusiness);
				}
				this.executebusService.excelInsertExecutebusiness(dataList);
				conn.close();
				request.setAttribute("message","excel����ڶ�����Ϣִ�гɹ�");
				return SUCCESS;
			}else{
				request.setAttribute("message","excel����ڶ����ļ��ϴ�ʧ��");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.close(); 
				request.setAttribute("message","excel����ڶ���ִ��ʧ��");
				return SUCCESS;
			} catch (Exception e1) {
				e1.printStackTrace();
				return SUCCESS;
			}
		}
	}
	
	public String excelUpStutas(){
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		Connection conn = null;
		try {
			if(updFileName != null){
				String path = basePath+"\\impExcel\\"+updFileName;
				FileUtils.copyFile(upd, new File(path));
				
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String dburl = "driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ=" + path;
				String connectionString = "jdbc:odbc:" + dburl;
				conn = DriverManager.getConnection(connectionString);
				Statement stmt = conn.createStatement();
				ResultSet  rs = stmt.executeQuery("select * from [sheet1$]");
			//	ResultSet  rs = stmt.executeQuery("select * from [abc$]");
				// ��ȡ������cnName��
				// ��ȡ����
				List<Executebusiness> dataList = new ArrayList<Executebusiness>();
				while (rs.next()) {
					String eName = rs.getString("��ҵ����");
					String eStatus = rs.getString("��ҵ״̬");
					Executebusiness exb = new Executebusiness();
					exb.setEName(eName);
					exb.setEStatus(eStatus);
					dataList.add(exb);
				}
				this.executebusService.Executebusiness(dataList);
				conn.close();
				message = "excel����ִ�гɹ�";
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.close(); 
			} catch (SQLException e1) {
				message = "excel����ִ�д���";
				e1.printStackTrace();
			}
			message = "excel����ִ�д���";
		}
		return SUCCESS;
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * 
	 * @return
	 */
	public static Connection getConn() {
		DBConnection dbcon = (DBConnection) DBConnectionHelper
				.getDBConnection();
		Connection con = dbcon.getConnection();
		return con;
	}
	
	
	/**
	 * ������ִ������ҵ��Ϣ������־��
	 * @return
	 */
	public String insertMore(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		try {
			this.executebusService.insertMoreExecutes(user);
			
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
	/*
	 * ��ӱ�ִ������ҵ��Ϣ	����
	 * 
	 */
	public String insertStep2(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Users admin=(Users) session.getAttribute("admin");	
			executebus.setUsers(admin);
			executebus.setESavetime(sdf.format(new Date()));
			if(executebus!=null){
				this.executebusService.insertStep2(executebus);
			return SUCCESS;
			}else{
				return "filed";
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String insertEb(){
		try {
			this.executebusService.insertEb(executebus);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String selExecutebusiness(){
		try {
			businlist=this.executebusService.selExecutebusiness(executebus);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
