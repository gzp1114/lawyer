package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.Users;

public interface ApplierinfoService {
	public void insertApp(Applierinfo applierinfo) throws Exception;//�������ִ������ҵ��Ϣ��ע����Ϣ��������־��
//	public Applierinfo selectAppnet(Applierinfo applierinfo,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡���־��
	public List selectApp(Applierinfo applierinfo)throws Exception;//��ѯ����ִ������ҵ��Ϣ��ע����Ϣ��������־��
	public void updateApp(Applierinfo applierinfo)throws Exception;//�޸İ�Դ��Ϣ������ִ������ҵ��Ϣ����ע����Ϣ�� ������־��
	public void insertMoreApplierinfos(Users user) throws Exception;//��Դ����������ִ������ҵ��Ϣ�����������������־��
	public void insertAppSoft(Applierinfo applierinfo) throws Exception;
	public List<Applierinfo> selAp(Applierinfo applierinfo)throws Exception;
	
	
	/**
	 * excel������������Ϣ
     * @throws Exception 
	 */
	public void excelInsertApplierinfo(List<Applierinfo> dataList) throws Exception;
	
	/**
	 * excel���������������Ϣ
	 * @param dataList
	 * @throws Exception
	 */
	public void excelUpdateApplierinfo(List<Applierinfo> dataList)throws Exception;
}
