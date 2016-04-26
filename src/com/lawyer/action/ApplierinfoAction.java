package com.lawyer.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.Addrecord;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.Users;
import com.lawyer.service.AddRecordService;
import com.lawyer.service.ApplierinfoService;
import com.lawyer.tools.ExcelTools;
import com.opensymphony.xwork2.ActionSupport;

public class ApplierinfoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Applierinfo applierinfo = null;
	private ApplierinfoService appinfoService = null;
	private AddRecordService ars;		//record�����service��
	private Addrecord record = new Addrecord();			//��װAddrecord����
	private List<Applierinfo> applierinfos;
	
	private File upd;// �ϴ����ļ��ڻ���
	private String updFileName;// �ļ���
	private String updContentType;// �ļ�����
	
	private String caseId;
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public List<Applierinfo> getApplierinfos() {
		return applierinfos;
	}
	public void setApplierinfos(List<Applierinfo> applierinfos) {
		this.applierinfos = applierinfos;
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
	public Applierinfo getApplierinfo() {
		return applierinfo;
	}
	public void setApplierinfo(Applierinfo applierinfo) {
		this.applierinfo = applierinfo;
	}
	public ApplierinfoService getAppinfoService() {
		return appinfoService;
	}
	public void setAppinfoService(ApplierinfoService appinfoService) {
		this.appinfoService = appinfoService;
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
	
	/*
	 * excel���������������Ϣ
	 */
	public String excelUpdateApplierinfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		Connection conn = null;
		try {
			if(updFileName != null){
				String path = basePath+"\\impExcel\\"+updFileName;
				FileUtils.copyFile(upd, new File(path));
				
				List<Applierinfo> dataList = new ArrayList<Applierinfo>();
				
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
				// ��Excel�ĵ��У���һ�Ź������ȱʡ������0
				HSSFSheet sheet = workbook.getSheetAt(0);
				// ��ȡ��Excel�ļ��е���������
				int rows = sheet.getPhysicalNumberOfRows();
				// ������
				for (int i = 1; i < rows; i++) {
					HSSFRow row = sheet.getRow(i);
					if (row != null) {
						// ��ȡ��Excel�ļ��е����е���
//						int cells = row.getPhysicalNumberOfCells();
						Applierinfo applierinfo = new Applierinfo();
						
						HSSFCell namecell = row.getCell(0);
						HSSFCell repnamecell = row.getCell(1);
		                HSSFCell statuscell = row.getCell(2);
		                if (namecell == null) {
		                    continue;
		                }
		                applierinfo.setAppName(ExcelTools.getValue(namecell));
		                if(repnamecell != null){
		                	applierinfo.setAppRepname(ExcelTools.getValue(repnamecell));
		                }else{
		                	applierinfo.setAppRepname("");
		                }
		                if(statuscell != null){
		                	applierinfo.setAppStatus(ExcelTools.getValue(statuscell));
		                }else{
		                	applierinfo.setAppStatus("");
		                }
						
						dataList .add(applierinfo);
					}
				}
				
				this.appinfoService.excelUpdateApplierinfo(dataList);
				request.setAttribute("message","excel������������Ϣ���³ɹ�");
				return SUCCESS;
			}else{
				request.setAttribute("message","excel������������Ϣ�ļ��ϴ�ʧ��");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.setAttribute("message","excel������������Ϣʧ��");
				return SUCCESS;
			} catch (Exception e1) {
				e1.printStackTrace();
				return SUCCESS;
			}
		}
	}
	
	/*
	 * excel������������Ϣ
	 */
	public String excelInsertApplierinfo(){
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
				List<Applierinfo> dataList = new ArrayList<Applierinfo>();
				while (rs.next()) {
					String pname = rs.getString("��ִ��������");
					String casecode = rs.getString("ִ�а���");
					String appName = rs.getString("����������");
					String appAddress = rs.getString("ס��");
					
					if(pname == null || pname.length() ==0){
						break;
					}
					
					Applierinfo applierinfo = new Applierinfo();
					applierinfo.setPname(pname);
					applierinfo.setCasecode(casecode);
					applierinfo.setAppName(appName);
					if(appAddress != null && !appAddress.equals("")){
						applierinfo.setAppAddress(appAddress);
					}
					
					dataList.add(applierinfo);
				}
				this.appinfoService.excelInsertApplierinfo(dataList);
				conn.close();
				request.setAttribute("message","excel�����������Ϣִ�гɹ�");
				return SUCCESS;
			}else{
				request.setAttribute("message","excel����������ļ��ϴ�ʧ��");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.close(); 
				request.setAttribute("message","excel���������ִ��ʧ��");
				return SUCCESS;
			} catch (Exception e1) {
				e1.printStackTrace();
				return SUCCESS;
			}
		}
	}
	
	/**
	 * ��Դ������--�������ִ������ҵ��Ϣ --ע����Ϣ
	 * ��־��
	 * @return
	 */
	public String insert(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Users admin=(Users) session.getAttribute("admin");
			applierinfo.setUsers(admin);
			applierinfo.setAppSavetime(sdf.format(new Date()));
			if(applierinfo != null){
				this.appinfoService.insertApp(applierinfo);	
				return SUCCESS;
			}else{
				return "filed";
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String markAppInfo(){
		try {
			if(applierinfo != null){
				this.appinfoService.updateApp(applierinfo);
				return SUCCESS;
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "filed";
	}
	
	public String insertApp(){
		try {
			System.out.println(applierinfo.getAppCCasecodeself() + "===========================");
			
			this.appinfoService.insertAppSoft(applierinfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String selAp(){
		try {
			applierinfos=this.appinfoService.selAp(applierinfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * ����������ִ������ҵ��Ϣ������־��
	 * @return
	 */
	public String insertMore(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		try {
			this.appinfoService.insertMoreApplierinfos(user);
			
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
}
