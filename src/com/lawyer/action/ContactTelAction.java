package com.lawyer.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactTelService;
import com.lawyer.service.FilesService;
import com.opensymphony.xwork2.ActionSupport;

public class ContactTelAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ContactTel contactTel = null;
	private ContactTelService cts = null;
	private File attach;
	private String attachFileName;
	private String attachContentType;
	private FilesService filesService;
	private Files file = new Files();
	private String caseId;
	private List<ContactTel> ctels;

	public List<ContactTel> getCtels() {
		return ctels;
	}

	public void setCtels(List<ContactTel> ctels) {
		this.ctels = ctels;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public Files getFile() {
		return file;
	}

	public void setFile(Files file) {
		this.file = file;
	}

	public FilesService getFilesService() {
		return filesService;
	}

	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}
	
	@SuppressWarnings("unchecked")
	public String selectConTel(){
		try {
			ctels = this.cts.selectContactTel(contactTel);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * ��������ִ������ϵ��Ϣ--�绰��ϵ ��־��
	 * 
	 * @return
	 */
	public String insert() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy��MM��dd��");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddhhmmss");
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		try {
			Users admin = (Users) session.getAttribute("admin");
			System.out.println(admin.getUName());
			contactTel.setUsers(admin);
			contactTel.setCtSavetime(sdf.format(new Date()));
			if (attachFileName != null) {
				attachFileName = df2.format(new Date()) + attachFileName;
				contactTel.setCtAttach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath
						+ "\\uploads\\��Դ�ļ���\\" + attachFileName));
				String ftitle = contactTel.getCtCasecodeself() + "-"
						+ attachFileName;
				file.setFTitle(ftitle);
				file.setFType("��Դ�ļ�");
				file.setFilelibrary(this.filesService.loadById(6));
				file.setFReldate(df1.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(admin);
				this.filesService.filesUpload(file);
			}

			if (contactTel != null) {
				this.cts.insertContactTel(contactTel);

				return SUCCESS;
			} else {
				return "filed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public ContactTel getContactTel() {
		return contactTel;
	}

	public void setContactTel(ContactTel contactTel) {
		this.contactTel = contactTel;
	}

	public ContactTelService getCts() {
		return cts;
	}

	public void setCts(ContactTelService cts) {
		this.cts = cts;
	}

	public File getAttach() {
		return attach;
	}

	public void setAttach(File attach) {
		this.attach = attach;
	}

	public String getAttachFileName() {
		return attachFileName;
	}

	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}

	public String getAttachContentType() {
		return attachContentType;
	}

	public void setAttachContentType(String attachContentType) {
		this.attachContentType = attachContentType;
	}

}