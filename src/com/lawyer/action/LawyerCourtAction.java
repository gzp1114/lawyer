package com.lawyer.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.LawyerCourt;
import com.lawyer.service.LawyerCourtService;
import com.lawyer.tools.ObjAndList2Json;
import com.opensymphony.xwork2.ActionSupport;

public class LawyerCourtAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private LawyerCourtService lawyerCourtService;
	private List<LawyerCourt> lawyerCourts;
	
	@SuppressWarnings("unchecked")
	public String findAll() throws Exception{
		//�������еķ�Ժ
		lawyerCourts = (List<LawyerCourt>) lawyerCourtService.findAllLawyerCourt();
		//��װ��json �ַ���  ��Ӧ���ͻ���
		String jsonarr = ObjAndList2Json.list2jsonarr(lawyerCourts);
		System.out.println(jsonarr);
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonarr);
		out.flush();
		out.close();
		
		return null;
	}
	/**
	 * �������е�һ����Ժ
	 * @return
	 */
	public String findFirst() throws Exception{
		List<LawyerCourt> firstLawyerCourts = lawyerCourtService.findFirstLawyerCourt();
		//��װ��json �ַ���  ��Ӧ���ͻ���
		String jsonarr = ObjAndList2Json.list2jsonarr(firstLawyerCourts);
		System.out.println(jsonarr);
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonarr);
		out.flush();
		out.close();
		return null;
	}
	/**
	 * ����һ����Ժ���Ҷ�Ӧ�Ķ�����Ժ
	 * @return
	 */
	public String findSecondByFirst() throws Exception{
		String fir_id=null;
		HttpServletRequest request = ServletActionContext.getRequest();
		fir_id = request.getParameter("fir_id");
		
		System.out.println(fir_id);
		
		List<LawyerCourt> secondLawyerCourts = lawyerCourtService.findSecondLawyerCourt(fir_id);
		//��װ��json �ַ���  ��Ӧ���ͻ���
		String jsonarr = ObjAndList2Json.list2jsonarr(secondLawyerCourts);
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonarr);
		out.flush();
		out.close();
		
		return null;
	}
	/**
	 *	���ݶ�����Ժ���Ҷ�Ӧ��������Ժ
	 * @return
	 */
	public String findThirdBySecond() throws Exception{
		String sec_id = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		sec_id = request.getParameter("sec_id");
		
		System.out.println(sec_id);
		
		List<LawyerCourt> thirdLawyerCourts = lawyerCourtService.findThirdLawyerCourt(sec_id);
		String jsonarr = ObjAndList2Json.list2jsonarr(thirdLawyerCourts);
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonarr);
		out.flush();
		out.close();
		return null;
	}
	
	
	
	
	
	
	
	
	public List<LawyerCourt> getLawyerCourts() {
		return lawyerCourts;
	}
	public void setLawyerCourts(List<LawyerCourt> lawyerCourts) {
		this.lawyerCourts = lawyerCourts;
	}
	public void setLawyerCourtService(LawyerCourtService lawyerCourtService) {
		this.lawyerCourtService = lawyerCourtService;
	}

}
