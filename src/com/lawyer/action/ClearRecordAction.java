package com.lawyer.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ClearClear;
import com.lawyer.pojo.ClearRecord;
import com.lawyer.pojo.CloseRecord;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Execute;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Litigation;
import com.lawyer.pojo.Material;
import com.lawyer.pojo.Users;
import com.lawyer.service.ClearRecordService;
import com.lawyer.service.FilesService;
import com.lawyer.tools.ExcelLoadAndPut;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClearRecordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ExcelLoadAndPut excelLoadandput;
	private ClearRecordService crs = null;
	private ClearRecord clearRecord;
	private ClearClear clearClear;
	private Litigation litigation;
	private Execute execute;
	private CloseRecord closeRecord;
	private Material material;
	
	private String pagesize;
	List<ContractSign> contractsign;
	private int page;
	ContractSign cont;
	private String startDate;
	private String endDate;

	private String contMinTime;
	private String contMaxTime;
	private String clearrecordMinTime;
	private String clearrecordMaxTime;
	private String litigationMinTime;
	private String litigationMaxTime;
	private String litigationMinMoney;
	private String litigationMaxMoney;
	private String executeMinTime;
	private String executeMaxTime;
	private String closerecordMinTime;
	private String closerecordMaxTime;
	private String flog = "";
	private String contractsignstr;

	private String[] adayin;
	private String[] bdayin;
	private String[] cdayin;
	private String[] ddayin;
	private String[] edayin;
	private String[] fdayin;
	
	
	List<ClearClear> clearclears;
	List<ClearRecord> clearrecords;
	List<Litigation> litigations;
	List<Execute> executes;
	List<Material> materials;
	
	private String casecodeself;
	
	public String showclearrecord(){
		try {
			clearRecord=this.crs.showclearrecord(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String showclearclear(){
		try {
			clearClear=this.crs.showclearclear(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String showlitigation(){
		try {
			litigation=this.crs.showlitigation(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String showexecute(){
		try {
			execute=this.crs.showexecute(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String selectClearRecord(){
		try {
			clearRecord = new ClearRecord();
			clearRecord.setCrcasecodeself(casecodeself);
			clearrecords=this.crs.selectClearRecord(clearRecord);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public String selectClearClear(){
		try {
			clearClear = new ClearClear();
			clearClear.setCccasecodeself(casecodeself);
			clearclears=this.crs.selectClearClear(clearClear);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public String selectLitigation(){
		try {
			litigation = new Litigation();
			litigation.setLicasecodeself(casecodeself);
			litigations=this.crs.selectLitigation(litigation);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public String selectExecute(){
		try {
			execute = new Execute();
			execute.setExcasecodeself(casecodeself);
			executes=this.crs.selectExecute(execute);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/*
	 * ���ڴ�ӡ
	 */

	public String daYinClearRecord() throws Exception {
		List<ContractSign> contractsignlist = new ArrayList<ContractSign>();
		List<Object[]> listdayin = new ArrayList<Object[]>();
		listdayin.add(new Object[] { "��ӡ�İ�����Ϣ" });
		// ����ҳ���ӡ
		Map<String, Object> request = ActionContext.getContext()
				.getContextMap();
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		InputStream in = new FileInputStream(basePath + "file\\dayin.xls");
		OutputStream out = new FileOutputStream(basePath + "file\\dayin3.xls");
		int temp;
		while ((temp = in.read()) != -1) {
			out.write(temp);
			out.flush();
		}
		in.close();
		out.close();
		String[] contractsigns = contractsignstr.split(",");
		if (contractsigns != null && contractsigns.length > 0
				&& !contractsigns[0].trim().equals("")) {
			for (int i = 0; i < contractsigns.length; i++) {
				ContractSign contractsign = crs
						.DaYinContractSign(contractsigns[i].trim());
				ContractSign sign = new ContractSign();
				sign.setCsCasecodeself("������ţ�"
						+ contractsign.getCsCasecodeself());
				listdayin.add(new Object[] { "�������:",
						contractsign.getCsCasecodeself() });

				int ob = 0;
				if (adayin != null && adayin.length > 0) {
					listdayin.add(new Object[] { "ǩԼ��Ϣ" });
					Object[] obja = new Object[10];
					for (int a = 0; a < adayin.length; a++) {
						if (adayin[a].equals("1")) {
							sign.setCsNo("ǩԼ�ţ�" + contractsign.getCsNo());
							obja[ob] = "ǩԼ�ţ�";
							ob++;
							obja[ob] = contractsign.getCsNo();
							if ("".equals(contractsign.getCsNo())) {
								obja[ob] = "δ��д";
							}
							ob++;

						}

						if (adayin[a].equals("2")) {
							sign.setCsAle("ǩԼ������" + contractsign.getCsAle());
							obja[ob] = "ǩԼ������";
							ob++;
							obja[ob] = contractsign.getCsAle();
							if ("".equals(contractsign.getCsAle())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}
						if (adayin[a].equals("3")) {
							sign.setCsName("�Է���ϵ�����ƣ�"
									+ contractsign.getCsName());
							obja[ob] = "�Է���ϵ�����ƣ�";
							ob++;
							obja[ob] = contractsign.getCsName();
							if ("".equals(contractsign.getCsName())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}
						if (adayin[a].equals("4")) {
							sign.setCsTel("�绰��" + contractsign.getCsTel());
							obja[ob] = "�绰��";
							ob++;
							obja[ob] = contractsign.getCsTel();
							if ("".equals(contractsign.getCsTel())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}
						if (adayin[a].equals("5")) {
							sign.setCsDate("ǩԼʱ�䣺" + contractsign.getCsDate());
							obja[ob] = "ǩԼʱ�䣺";
							ob++;
							obja[ob] = contractsign.getCsDate();
							if ("".equals(contractsign.getCsDate())) {
								obja[ob] = "δ��д";
							}
							ob++;
						}

					}
					for (; ob < 10; ob++) {
						obja[ob] = "";
					}
					listdayin.add(obja);
					ob = 0;
				}

				if (bdayin != null && bdayin.length > 0) {
					List<ClearRecord> clearcecords = crs
							.DaYinClearRecord(contractsigns[i].trim());
					List<ClearRecord> clares = new ArrayList<ClearRecord>();
					listdayin.add(new Object[] { "��������" });
					Object[] obja = null;
					ClearRecord clare = null;
					if (clearcecords.size() < 1) {
						obja = new Object[14];
						clare = new ClearRecord();
					}
					for (ClearRecord clearcecord : clearcecords) {
						clare = new ClearRecord();
						obja = new Object[14];
						for (int a = 0; a < bdayin.length; a++) {
							if (bdayin[a].equals("1")) {
								if (clearcecord.getCrnumber() != null) {
									clare.setCrnumber("�������ţ�"
											+ clearcecord.getCrnumber());
									obja[ob] = "�������ţ�";
									ob++;
									obja[ob] = clearcecord.getCrnumber();
									if ("".equals(clearcecord.getCrnumber())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clare.setCrnumber("�������ţ�δ��д");
									obja[ob] = "�������ţ�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}

							if (bdayin[a].equals("2")) {
								if (clearcecord.getCrcontactjudge() != null) {
									clare.setCrcontactjudge("��ϵ���٣�"
											+ clearcecord.getCrcontactjudge());
									obja[ob] = "��ϵ���٣�";
									ob++;
									obja[ob] = clearcecord.getCrcontactjudge();
									if ("".equals(clearcecord
											.getCrcontactjudge())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clare.setCrcontactjudge("��ϵ���٣�δ��д");
									obja[ob] = "��ϵ���٣�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}
							if (bdayin[a].equals("3")) {
								if (clearcecord.getCrcontacttel() != null) {
									clare.setCrcontacttel("���ٵ绰��"
											+ clearcecord.getCrcontacttel());
									obja[ob] = "���ٵ绰��";
									ob++;
									obja[ob] = clearcecord.getCrcontacttel();
									if ("".equals(clearcecord.getCrcontacttel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clare.setCrcontacttel("���ٵ绰��δ��д");
									obja[ob] = "���ٵ绰��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (bdayin[a].equals("4")) {
								if (clearcecord.getCrlawname() != null) {
									clare.setCrlawname("�а���ʦ��"
											+ clearcecord.getCrlawname());
									obja[ob] = "�а���ʦ��";
									ob++;
									obja[ob] = clearcecord.getCrlawname();
									if ("".equals(clearcecord.getCrlawname())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clare.setCrlawname("�а���ʦ��δ��д");
									obja[ob] = "�а���ʦ��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (bdayin[a].equals("5")) {

								if (clearcecord.getCrlawtel() != null) {
									clare.setCrlawname("��ʦ�绰��"
											+ clearcecord.getCrlawtel());
									obja[ob] = "��ʦ�绰��";
									ob++;
									obja[ob] = clearcecord.getCrlawtel();
									if ("".equals(clearcecord.getCrlawtel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clare.setCrlawname("��ʦ�绰��δ��д");
									obja[ob] = "��ʦ�绰��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

							if (bdayin[a].equals("6")) {

								if (clearcecord.getCrfollowupresult() != null) {
									clare.setCrfollowupresult("������չ��"
											+ clearcecord.getCrfollowupresult());
									obja[ob] = "������չ��";
									ob++;
									obja[ob] = clearcecord
											.getCrfollowupresult();
									if ("".equals(clearcecord
											.getCrfollowupresult())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clare.setCrfollowupresult("������չ��δ��д");
									obja[ob] = "������չ��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (bdayin[a].equals("7")) {
								if (clearcecord.getCrdate() != null) {
									clare.setCrdate(" ���ϵݽ�ʱ�䣺"
											+ clearcecord.getCrdate());
									obja[ob] = "���ϵݽ�ʱ�䣺";
									ob++;
									obja[ob] = clearcecord.getCrdate();
									if ("".equals(clearcecord.getCrdate())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clare.setCrdate(" ���ϵݽ�ʱ�䣺δ��д");
									obja[ob] = "���ϵݽ�ʱ�䣺";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}

						}

						for (; ob < 14; ob++) {
							obja[ob] = "";
						}
						 listdayin.add(obja);
						ob = 0;
						clares.add(clare);
					}
						
					if (clares.size()>0) {
						sign.setClearrecords(clares);
					}else{
						sign.setClearrecords(null);
					}
					
					
				}

				if (cdayin != null && cdayin.length > 0) {
					List<ClearClear> clearclares = crs
							.DaYinClearClear(contractsigns[i].trim());
					List<ClearClear> clears = new ArrayList<ClearClear>();
					ClearClear clear = null;
					listdayin.add(new Object[] { "�������" });
					Object[] obja = null;

					if (clearclares.size() < 1) {
						obja = new Object[12];
						clear = new ClearClear();
					}
					for (ClearClear clearclare : clearclares) {
						obja = new Object[12];
						clear = new ClearClear();
						for (int a = 0; a < cdayin.length; a++) {
							if (cdayin[a].equals("1")) {
								if (clearclare.getCcnumber() != null) {
									clear.setCcnumber("�������ţ�"
											+ clearclare.getCcnumber());
									obja[ob] = "�������ţ�";
									ob++;
									obja[ob] = clearclare.getCcnumber();
									if ("".equals(clearclare.getCcnumber())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clear.setCcnumber("�������ţ�δ��д");
									obja[ob] = "�������ţ�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}

							if (cdayin[a].equals("2")) {
								if (clearclare.getCcjudge() != null) {
									clear.setCcjudge("�а취�٣�"
											+ clearclare.getCcjudge());
									obja[ob] = "�а취�٣�";
									ob++;
									obja[ob] = clearclare.getCcjudge();
									if ("".equals(clearclare.getCcjudge())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clear.setCcjudge("�а취�٣�δ��д");
									obja[ob] = "�а취�٣�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}
							if (cdayin[a].equals("3")) {
								if (clearclare.getCcjudgetel() != null) {
									clear.setCcjudgetel("���ٵ绰��"
											+ clearclare.getCcjudgetel());
									obja[ob] = "���ٵ绰��";
									ob++;
									obja[ob] = clearclare.getCcjudgetel();
									if ("".equals(clearclare.getCcjudgetel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clear.setCcjudgetel("���ٵ绰��δ��д");
									obja[ob] = "���ٵ绰��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (cdayin[a].equals("4")) {
								if (clearclare.getCclawname() != null) {
									clear.setCclawname("�а���ʦ��"
											+ clearclare.getCclawname());
									obja[ob] = "�а���ʦ��";
									ob++;
									obja[ob] = clearclare.getCclawname();
									if ("".equals(clearclare.getCclawname())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clear.setCclawname("�а���ʦ��δ��д");
									obja[ob] = "�а���ʦ��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (cdayin[a].equals("5")) {

								if (clearclare.getCclawnametel() != null) {
									clear.setCclawnametel("��ʦ�绰��"
											+ clearclare.getCclawnametel());
									obja[ob] = "��ʦ�绰��";
									ob++;
									obja[ob] = clearclare.getCclawnametel();
									if ("".equals(clearclare.getCclawnametel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clear.setCclawnametel("��ʦ�绰��δ��д");
									obja[ob] = "��ʦ�绰��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

							if (cdayin[a].equals("6")) {

								if (clearclare.getCcfollowupresult() != null) {
									clear.setCcfollowupresult("������չ��"
											+ clearclare.getCcfollowupresult());
									obja[ob] = "������չ��";
									ob++;
									obja[ob] = clearclare.getCcfollowupresult();
									if ("".equals(clearclare
											.getCcfollowupresult())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									clear.setCcfollowupresult("������չ��δ��д");
									obja[ob] = "������չ��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

						
						}
						for (; ob < 12; ob++) {
							obja[ob] = "";
						}
						 listdayin.add(obja);
						ob = 0;
						clears.add(clear);

					}
					
					if (clears.size()>0) {
						sign.setClearclears(clears);
					}else {
						sign.setClearclears(null);
					}
					
				}

				if (ddayin != null && ddayin.length > 0) {
					List<Litigation> litigations = crs
							.DaYinLitigation(contractsigns[i].trim());
					Litigation liti = null;
					listdayin.add(new Object[] { "������Ϣ" });
					Object[] obja = null;
					List<Litigation> litis = new ArrayList<Litigation>();
					if (litigations.size() < 1) {
						obja = new Object[16];
						liti = new Litigation();
					}
					for (Litigation litigation : litigations) {
						obja = new Object[16];
						liti = new Litigation();
						for (int a = 0; a < ddayin.length; a++) {

							if (ddayin[a].equals("1")) {
								if (litigation.getLinumber() != null) {
									liti.setLinumber("�������ţ�"
											+ litigation.getLinumber());
									obja[ob] = "�������ţ�";
									ob++;
									obja[ob] = litigation.getLinumber();
									if ("".equals(litigation.getLinumber())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									liti.setLinumber("�������ţ�δ��д");
									obja[ob] = "�������ţ�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}

							if (ddayin[a].equals("2")) {
								if (litigation.getLijudge() != null) {
									liti.setLijudge("�а취�٣�"
											+ litigation.getLijudge());
									obja[ob] = "�а취�٣�";
									ob++;
									obja[ob] = litigation.getLijudge();
									if ("".equals(litigation.getLijudge())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									liti.setLijudge("�а취�٣�δ��д");
									obja[ob] = "�а취�٣�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}
							if (ddayin[a].equals("3")) {
								if (litigation.getLijudgetel() != null) {
									liti.setLijudgetel("���ٵ绰��"
											+ litigation.getLijudgetel());
									obja[ob] = "���ٵ绰��";
									ob++;
									obja[ob] = litigation.getLijudgetel();
									if ("".equals(litigation.getLijudgetel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									liti.setLijudgetel("���ٵ绰��δ��д");
									obja[ob] = "���ٵ绰��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (ddayin[a].equals("4")) {
								if (litigation.getLilawname() != null) {
									liti.setLilawname("�а���ʦ��"
											+ litigation.getLilawname());
									obja[ob] = "�а���ʦ��";
									ob++;
									obja[ob] = litigation.getLilawname();
									if ("".equals(litigation.getLilawname())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									liti.setLilawname("�а���ʦ��δ��д");
									obja[ob] = "�а���ʦ��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (ddayin[a].equals("5")) {

								if (litigation.getLilawtel() != null) {
									liti.setLilawtel("��ʦ�绰��"
											+ litigation.getLilawtel());
									obja[ob] = "��ʦ�绰��";
									ob++;
									obja[ob] = litigation.getLilawtel();
									if ("".equals(litigation.getLilawtel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									liti.setLilawtel("��ʦ�绰��δ��д");
									obja[ob] = "��ʦ�绰��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

							if (ddayin[a].equals("6")) {

								if (litigation.getLifollowupresult() != null) {
									liti.setLifollowupresult("������չ��"
											+ litigation.getLifollowupresult());
									obja[ob] = "������չ��";
									ob++;
									obja[ob] = litigation.getLifollowupresult();
									if ("".equals(litigation
											.getLifollowupresult())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									liti.setLifollowupresult("������չ��δ��д");
									obja[ob] = "������չ��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

							if (ddayin[a].equals("7")) {

								if (litigation.getLidate() != null) {
									liti.setLidate("����ʱ�䣺"
											+ litigation.getLidate());
									obja[ob] = "����ʱ�䣺";
									ob++;
									obja[ob] = litigation.getLidate();
									if ("".equals(litigation.getLidate())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									liti.setLidate("����ʱ�䣺δ��д");
									obja[ob] = "����ʱ�䣺";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

							if (ddayin[a].equals("8")) {

								if (litigation.getLifund() != null) {
									liti.setLiremark("�������ã�"
											+ litigation.getLifund());
									obja[ob] = "�������ã�";
									ob++;
									obja[ob] = litigation.getLifund();
									if ("".equals(litigation.getLifund())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									liti.setLiremark("�������ã�δ��д");
									obja[ob] = "�������ã�";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

						}
						for (; ob < 16; ob++) {
							obja[ob] = "";
						}
						 listdayin.add(obja);
						ob = 0;

						litis.add(liti);
					}
					
					if (litis.size()>0) {
						sign.setLitigations(litis);
					}
					else {
						sign.setLitigations(null);
					}
					
				}
				if (edayin != null && edayin.length > 0) {
					List<Execute> executes = crs.DaYinExecute(contractsigns[i]
							.trim());
					Execute exe = null;
					List<Execute> exes = new ArrayList<Execute>();
					listdayin.add(new Object[] { "ִ����Ϣ" });
					Object[] obja = null;
					;

					if (executes.size() < 1) {
						obja = new Object[14];
						exe = new Execute();
					}
					for (Execute execute : executes) {
						obja = new Object[14];
						exe = new Execute();
					for (int a = 0; a < edayin.length; a++) {

							if (edayin[a].equals("1")) {
								if (execute.getExnumber() != null) {
									exe.setExnumber("�������ţ�"
											+ execute.getExnumber());
									obja[ob] = "�������ţ�";
									ob++;
									obja[ob] = execute.getExnumber();
									if ("".equals(execute.getExnumber())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									exe.setExnumber("�������ţ�δ��д");
									obja[ob] = "�������ţ�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}

							if (edayin[a].equals("2")) {
								if (execute.getExjudge() != null) {
									exe.setExjudge("�а취�٣�"
											+ execute.getExjudge());
									obja[ob] = "�а취�٣�";
									ob++;
									obja[ob] = execute.getExjudge();
									if ("".equals(execute.getExjudge())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									exe.setExjudge("�а취�٣�δ��д");
									obja[ob] = "�а취�٣�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}
							if (edayin[a].equals("3")) {
								if (execute.getExjudgetel() != null) {
									exe.setExjudgetel("���ٵ绰��"
											+ execute.getExjudgetel());
									obja[ob] = "���ٵ绰��";
									ob++;
									obja[ob] = execute.getExjudgetel();
									if ("".equals(execute.getExjudgetel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									exe.setExjudgetel("���ٵ绰��δ��д");
									obja[ob] = "���ٵ绰��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (edayin[a].equals("4")) {
								if (execute.getExlawname() != null) {
									exe.setExlawname("�а���ʦ��"
											+ execute.getExlawname());
									obja[ob] = "�а���ʦ��";
									ob++;
									obja[ob] = execute.getExlawname();
									if ("".equals(execute.getExlawname())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									exe.setExlawname("�а���ʦ��δ��д");
									obja[ob] = "�а���ʦ��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
							if (edayin[a].equals("5")) {

								if (execute.getExlawtel() != null) {
									exe.setExlawtel("��ʦ�绰��"
											+ execute.getExlawtel());
									obja[ob] = "��ʦ�绰��";
									ob++;
									obja[ob] = execute.getExlawtel();
									if ("".equals(execute.getExlawtel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									exe.setExlawtel("��ʦ�绰��δ��д");
									obja[ob] = "��ʦ�绰��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

							if (edayin[a].equals("6")) {

								if (execute.getExfollowupresult() != null) {
									exe.setExfollowupresult("������չ��"
											+ execute.getExfollowupresult());
									obja[ob] = "������չ��";
									ob++;
									obja[ob] = execute.getExfollowupresult();
									if ("".equals(execute.getExfollowupresult())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									exe.setExfollowupresult("������չ��δ��д");
									obja[ob] = "������չ��";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

							if (edayin[a].equals("7")) {

								if (execute.getExdate() != null) {
									exe.setExdate("����ʱ�䣺" + execute.getExdate());
									obja[ob] = "����ʱ�䣺";
									ob++;
									obja[ob] = execute.getExdate();
									if ("".equals(execute.getExdate())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									exe.setExdate("����ʱ�䣺δ��д");
									obja[ob] = "����ʱ�䣺";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}
						
							
						}
					for (; ob < 14; ob++) {
						obja[ob] = "";
					}
					 listdayin.add(obja);
					ob = 0;
					exes.add(exe);

					}
					
					if (exes.size()>0) {
						sign.setExecutes(exes);
					}
					else {
						sign.setExecutes(null);
					}
					
				}
				if (fdayin != null && fdayin.length > 0) {
					CloseRecord closerecord = crs
							.DaYinCloseRecord(contractsigns[i].trim());
					CloseRecord close = new CloseRecord();
					listdayin.add(new Object[] { "�᰸��Ϣ" });
					Object[] obja = new Object[6];
					
					if (closerecord!=null) {
						for (int a = 0; a < fdayin.length; a++) {
							if (fdayin[a].equals("1")) {
								if (closerecord.getCrperson() != null) {
									close.setCrperson("�᰸�ˣ�"
											+ closerecord.getCrperson());
									obja[ob] = "�᰸�ˣ�";
									ob++;
									obja[ob] = closerecord.getCrperson();
									if ("".equals(closerecord.getCrperson())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									close.setCrperson("�᰸�ˣ�δ��д");
									obja[ob] = "�᰸�ˣ�";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}

							if (fdayin[a].equals("2")) {
								if (closerecord.getCrpersontel() != null) {
									close.setCrpersontel("�᰸�˵绰��"
											+ closerecord.getCrpersontel());
									obja[ob] = "�᰸�˵绰��";
									ob++;
									obja[ob] = closerecord.getCrpersontel();
									if ("".equals(closerecord.getCrpersontel())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									close.setCrpersontel("�᰸�˵绰��δ��д");
									obja[ob] = "�᰸�˵绰��";
									ob++;
									obja[ob] = "δ��д";
									ob++;
								}

							}
							if (fdayin[a].equals("3")) {
								if (closerecord.getCrtime() != null) {
									close.setCrtime("�᰸ʱ�䣺"
											+ closerecord.getCrtime());
									obja[ob] = "�᰸ʱ�䣺";
									ob++;
									obja[ob] = closerecord.getCrtime();
									if ("".equals(closerecord.getCrtime())) {
										obja[ob] = "δ��д";
									}
									ob++;
								} else {
									close.setCrtime("�᰸ʱ�䣺δ��д");
									obja[ob] = "�᰸ʱ�䣺";
									ob++;
									obja[ob] = "δ��д";

									ob++;
								}

							}

						}
						for (; ob < 6; ob++) {
							obja[ob] = "";
						}
						listdayin.add(obja);
						ob = 0;
						sign.setCloserecord(close);
					}else {
						sign.setCloserecord(null);
					}
					
					

				}

				contractsignlist.add(sign);

			}

		}


		request.put("adayin", adayin);
		request.put("bdayin", bdayin);
		request.put("cdayin", cdayin);
		request.put("ddayin", ddayin);
		request.put("edayin", edayin);
		request.put("fdayin", fdayin);
		request.put("contractsigns", contractsignlist);
		excelLoadandput.PutExcel(basePath + "file\\dayin3.xls", "", listdayin);
		return Action.SUCCESS;

	}

	@SuppressWarnings("unchecked")
	public String seniorSelect() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
//		String[] params = null;
//		if (flog.endsWith("0")) {
//			params = new String[] {
//					// 0-3
//					cont.getCsNo(),
//					cont.getCsAle(),
//					cont.getCsName(),
//					cont.getCsTel(),
//					// 4-9
//					cont.getClearrecord().getCrnumber(),
//					cont.getClearrecord().getCrcontactjudge(),
//					cont.getClearrecord().getCrcontacttel(),
//					cont.getClearrecord().getCrlawname(),
//					cont.getClearrecord().getCrlawtel(),
//					cont.getClearrecord().getCrfollowupresult(),
//					// 10-15
//					cont.getClearclear().getCcnumber(),
//					cont.getClearclear().getCcjudge(),
//					cont.getClearclear().getCcjudgetel(),
//					cont.getClearclear().getCclawname(),
//					cont.getClearclear().getCclawnametel(),
//					cont.getClearclear().getCcfollowupresult(),
//					// 16-21
//					cont.getLitigation().getLinumber(),
//					cont.getLitigation().getLijudge(),
//					cont.getLitigation().getLijudgetel(),
//					cont.getLitigation().getLilawname(),
//					cont.getLitigation().getLilawtel(),
//					cont.getLitigation().getLifollowupresult(),
//					// 22-27
//					cont.getExecute().getExnumber(),
//					cont.getExecute().getExjudge(),
//					cont.getExecute().getExjudgetel(),
//					cont.getExecute().getExlawname(),
//					cont.getExecute().getExlawtel(),
//					cont.getExecute().getExfollowupresult(),
//					// 28-29
//					cont.getCloserecord().getCrperson(),
//					cont.getCloserecord().getCrpersontel(),
//					// 30-31
//					contMinTime,
//					contMaxTime,
//					// 32-33
//					clearrecordMinTime,
//					clearrecordMaxTime,
//					// 34-37
//					litigationMinTime, litigationMaxTime, litigationMinMoney,
//					litigationMaxMoney,
//					// 38-41
//					executeMinTime, executeMaxTime, closerecordMinTime,
//					closerecordMaxTime };
//
//			flog = "1";
//			session.put("params", params);
//		} else {
//			params = (String[]) session.get("params");
//		}
		if (flog.endsWith("0")) {
			session.put("cont", cont);
		}else{
			cont = (ContractSign) session.get("cont");
		}
		
		if (page == 0) {
			page = 1;
		}
		pagesize = this.crs.seniorSelectPageSizeNew(100, cont) + "";
		if (page > Integer.parseInt(pagesize)) {
			page = Integer.parseInt(pagesize);
		}
		contractsign = (List<ContractSign>) crs.seniorSelectNew(page, 100, cont);

		return SUCCESS;
	}

	

	// �ϴ��ļ�
	private File attach;
	private String attachFileName;
	private String attachContentType;
	private FilesService filesService;
	private Files file = new Files();

	public FilesService getFilesService() {
		return filesService;
	}

	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}

	public Files getFile() {
		return file;
	}

	public void setFile(Files file) {
		this.file = file;
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

	public ContractSign getCont() {
		return cont;
	}

	public void setCont(ContractSign cont) {
		this.cont = cont;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ClearRecord getClearRecord() {
		return clearRecord;
	}

	public void setClearRecord(ClearRecord clearRecord) {
		this.clearRecord = clearRecord;
	}

	public ClearClear getClearClear() {
		return clearClear;
	}

	public void setClearClear(ClearClear clearClear) {
		this.clearClear = clearClear;
	}

	public Litigation getLitigation() {
		return litigation;
	}

	public void setLitigation(Litigation litigation) {
		this.litigation = litigation;
	}

	public Execute getExecute() {
		return execute;
	}

	public void setExecute(Execute execute) {
		this.execute = execute;
	}

	public CloseRecord getCloseRecord() {
		return closeRecord;
	}

	public void setCloseRecord(CloseRecord closeRecord) {
		this.closeRecord = closeRecord;
	}

	public ClearRecordService getCrs() {
		return crs;
	}

	public void setCrs(ClearRecordService crs) {
		this.crs = crs;
	}

	public String selectCourts() {
		if(cont != null){
			System.out.println(cont.getCsId()+"===" + cont.getCsNo()+"==="+cont.getCsName()+"==="+startDate+"==="+endDate);
		}
		if (page == 0) {
			page = 1;
		}
		try {
			pagesize = this.crs.selectClearsPageSize(cont,startDate,endDate);
			if (page > Integer.parseInt(pagesize)) {
				page = Integer.parseInt(pagesize);
			}
			contractsign = this.crs.selectCourts(page,cont,startDate,endDate);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "filed";
		}
	}
	
	public String searchCourtsByname() {
		if(cont.getLawyerName() == null){
			return null;
		}
		if (page == 0) {
			page = 1;
		}
		try {
			pagesize = this.crs.selectClearsPageSizeByname(cont.getLawyerName());
			if (page > Integer.parseInt(pagesize)) {
				page = Integer.parseInt(pagesize);
			}
			contractsign = (List<ContractSign>) this.crs.selectClearsByname(page,cont.getLawyerName());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "filed";
		}
	}

	public String selectDetal() {
		try {
			cont = this.crs.selectDetal(cont.getCsCasecodeself());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String addClearrecord() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy��MM��dd��");
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		try {
			clearRecord.setCrSaveTime(sdf.format(new Date()));
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Users user = (Users) session.getAttribute("admin");
			clearRecord.setUsers(user);
			if (attachFileName != null) {
				attachFileName = df1.format(new Date()) + "_" + attachFileName;
				clearRecord.setCrattach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath
						+ "\\uploads\\�����ļ���\\" + attachFileName));

				String ftitle = clearRecord.getCrcasecodeself() + "-"
						+ attachFileName;
				file.setFTitle(ftitle);
				file.setFType("�����ļ�");
				file.setFilelibrary(this.filesService.loadById(7));
				file.setFReldate(df2.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(user);
				this.filesService.filesUpload(file);
			}
			this.crs.addClearrecord(clearRecord);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String addClearclear() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd��");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddhhmmss");
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Users user = (Users) session.getAttribute("admin");
			clearClear.setCcsaveTime(sdf.format(new Date()));
			clearClear.setUsers(user);
			if (attachFileName != null) {
				attachFileName = df1.format(new Date()) + "_" + attachFileName;
				clearClear.setCcattach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath
						+ "\\uploads\\�����ļ���\\" + attachFileName));

				String ftitle = clearClear.getCccasecodeself() + "-"
						+ attachFileName;
				file.setFTitle(ftitle);
				file.setFType("�����ļ�");
				file.setFilelibrary(this.filesService.loadById(7));
				file.setFReldate(simpleDateFormat.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(user);
				this.filesService.filesUpload(file);
			}
			this.crs.addClearclear(clearClear);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String addLitigation() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy��MM��dd��");
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Users user = (Users) session.getAttribute("admin");
			litigation.setUsers(user);
			litigation.setLisaveTime(sdf.format(new Date()));
			if (attachFileName != null) {
				attachFileName = df1.format(new Date()) + "_" + attachFileName;
				litigation.setLiattach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath
						+ "\\uploads\\�����ļ���\\" + attachFileName));

				String ftitle = litigation.getLicasecodeself() + "-"
						+ attachFileName;
				file.setFTitle(ftitle);
				file.setFType("�����ļ�");
				file.setFilelibrary(this.filesService.loadById(7));
				file.setFReldate(df2.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(user);
				this.filesService.filesUpload(file);
			}
			this.crs.addLitigation(litigation);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String addExecute() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy��MM��dd��");
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Users user = (Users) session.getAttribute("admin");
			execute.setUsers(user);
			execute.setExsavetime(sdf.format(new Date()));
			if (attachFileName != null) {
				attachFileName = df1.format(new Date()) + "_" + attachFileName;
				execute.setExattach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath
						+ "\\uploads\\�����ļ���\\" + attachFileName));

				String ftitle = execute.getExcasecodeself() + "-"
						+ attachFileName;
				file.setFTitle(ftitle);
				file.setFType("�����ļ�");
				file.setFilelibrary(this.filesService.loadById(7));
				file.setFReldate(df2.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(user);
				this.filesService.filesUpload(file);
			}
			if(execute.getExecMoney().equals("")){
				execute.setExecMoney("0");
			}
			this.crs.addExecute(execute);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String addClearClose() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy��MM��dd��");
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Users user = (Users) session.getAttribute("admin");
			closeRecord.setUsers(user);
			closeRecord.setCrsavetime(sdf.format(new Date()));
			if (attachFileName != null) {
				attachFileName = df1.format(new Date()) + "_" + attachFileName;
				closeRecord.setCrattach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath
						+ "\\uploads\\�����ļ���\\" + attachFileName));

				String ftitle = closeRecord.getCrcasecodeself() + "-"
						+ attachFileName;
				file.setFTitle(ftitle);
				file.setFType("�����ļ�");
				file.setFilelibrary(this.filesService.loadById(7));
				file.setFReldate(df2.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(user);
				this.filesService.filesUpload(file);
			}
			this.crs.addClearClose(closeRecord);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String getContMinTime() {
		return contMinTime;
	}

	public void setContMinTime(String contMinTime) {
		this.contMinTime = contMinTime;
	}

	public String getContMaxTime() {
		return contMaxTime;
	}

	public void setContMaxTime(String contMaxTime) {
		this.contMaxTime = contMaxTime;
	}

	public String getClearrecordMinTime() {
		return clearrecordMinTime;
	}

	public void setClearrecordMinTime(String clearrecordMinTime) {
		this.clearrecordMinTime = clearrecordMinTime;
	}

	public String getClearrecordMaxTime() {
		return clearrecordMaxTime;
	}

	public void setClearrecordMaxTime(String clearrecordMaxTime) {
		this.clearrecordMaxTime = clearrecordMaxTime;
	}

	public String getLitigationMinTime() {
		return litigationMinTime;
	}

	public void setLitigationMinTime(String litigationMinTime) {
		this.litigationMinTime = litigationMinTime;
	}

	public String getLitigationMaxTime() {
		return litigationMaxTime;
	}

	public void setLitigationMaxTime(String litigationMaxTime) {
		this.litigationMaxTime = litigationMaxTime;
	}

	public String getLitigationMinMoney() {
		return litigationMinMoney;
	}

	public void setLitigationMinMoney(String litigationMinMoney) {
		this.litigationMinMoney = litigationMinMoney;
	}

	public String getLitigationMaxMoney() {
		return litigationMaxMoney;
	}

	public void setLitigationMaxMoney(String litigationMaxMoney) {
		this.litigationMaxMoney = litigationMaxMoney;
	}

	public String getExecuteMinTime() {
		return executeMinTime;
	}

	public void setExecuteMinTime(String executeMinTime) {
		this.executeMinTime = executeMinTime;
	}

	public String getExecuteMaxTime() {
		return executeMaxTime;
	}

	public void setExecuteMaxTime(String executeMaxTime) {
		this.executeMaxTime = executeMaxTime;
	}

	public String getCloserecordMinTime() {
		return closerecordMinTime;
	}

	public void setCloserecordMinTime(String closerecordMinTime) {
		this.closerecordMinTime = closerecordMinTime;
	}

	public String getCloserecordMaxTime() {
		return closerecordMaxTime;
	}

	public void setCloserecordMaxTime(String closerecordMaxTime) {
		this.closerecordMaxTime = closerecordMaxTime;
	}

	public List<ContractSign> getContractsign() {
		return contractsign;
	}

	public void setContractsign(List<ContractSign> contractsign) {
		this.contractsign = contractsign;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getFlog() {
		return flog;
	}

	public void setFlog(String flog) {
		this.flog = flog;
	}

	public ExcelLoadAndPut getExcelLoadandput() {
		return excelLoadandput;
	}

	public void setExcelLoadandput(ExcelLoadAndPut excelLoadandput) {
		this.excelLoadandput = excelLoadandput;
	}

	public String getContractsignstr() {
		return contractsignstr;
	}

	public void setContractsignstr(String contractsignstr) {
		this.contractsignstr = contractsignstr;
	}

	public String[] getAdayin() {
		return adayin;
	}

	public void setAdayin(String[] adayin) {
		this.adayin = adayin;
	}

	public String[] getBdayin() {
		return bdayin;
	}

	public void setBdayin(String[] bdayin) {
		this.bdayin = bdayin;
	}

	public String[] getCdayin() {
		return cdayin;
	}

	public void setCdayin(String[] cdayin) {
		this.cdayin = cdayin;
	}

	public String[] getDdayin() {
		return ddayin;
	}

	public void setDdayin(String[] ddayin) {
		this.ddayin = ddayin;
	}

	public String[] getEdayin() {
		return edayin;
	}

	public void setEdayin(String[] edayin) {
		this.edayin = edayin;
	}

	public String[] getFdayin() {
		return fdayin;
	}

	public void setFdayin(String[] fdayin) {
		this.fdayin = fdayin;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public List<ClearClear> getClearclears() {
		return clearclears;
	}

	public void setClearclears(List<ClearClear> clearclears) {
		this.clearclears = clearclears;
	}

	public List<ClearRecord> getClearrecords() {
		return clearrecords;
	}

	public void setClearrecords(List<ClearRecord> clearrecords) {
		this.clearrecords = clearrecords;
	}

	public List<Litigation> getLitigations() {
		return litigations;
	}

	public void setLitigations(List<Litigation> litigations) {
		this.litigations = litigations;
	}

	public List<Execute> getExecutes() {
		return executes;
	}

	public void setExecutes(List<Execute> executes) {
		this.executes = executes;
	}
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	public List<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}
	public String addMaterial() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			material.setSavetime(sdf.format(new Date()));
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Users user = (Users) session.getAttribute("admin");
			material.setUsers(user);
			
			this.crs.addMaterial(material);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String selectMaterial(){
		try {
			material = new Material();
			material.setCasecodeself(casecodeself);
			materials=this.crs.selectMaterial(material);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
}
