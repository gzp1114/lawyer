package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ApplierinfoOnselfDao;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplierinfoOnselfService;

public class ApplierinfoOnselfServiceImpl implements ApplierinfoOnselfService {

	private ApplierinfoOnselfDao applierinfoOnselfDao;
	public ApplierinfoOnselfDao getApplierinfoOnselfDao() {
		return applierinfoOnselfDao;
	}
	public void setApplierinfoOnselfDao(ApplierinfoOnselfDao applierinfoOnselfDao) {
		this.applierinfoOnselfDao = applierinfoOnselfDao;
	}

	/**
	 * �������ִ������ҵ��Ϣ��������Ϣ��
	 * 
	 */
	public void insertAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		applierinfoOnselfDao.insertAppOnself(applierinfoOnself);
	}

	/**
	 * ��ѯ����ִ������ҵ��Ϣ��������Ϣ����������Ȩ�ޣ��ж�����Ȩ��
	 */
	public ApplierinfoOnself selectAppOnself(
			ApplierinfoOnself applierinfoOnself, Users users) throws Exception {
		return applierinfoOnselfDao.selectAppOnself(applierinfoOnself, users);
	}

	/**
	 * ��ѯ����ִ������ҵ��Ϣ��������Ϣ��
	 * 
	 */
	public List selectAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		return applierinfoOnselfDao.selectAppOnself(applierinfoOnself);
	}

	/**
	 * �޸�����ִ������ҵ��Ϣ��������Ϣ��
	 * 
	 */
	public void updateAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		applierinfoOnselfDao.updateAppOnself(applierinfoOnself);
	}

	/**
	 * ɾ������ִ������ҵ��Ϣ��������Ϣ��
	 * 
	 */
	public void deleteAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		applierinfoOnselfDao.deleteAppOnself(applierinfoOnself);
	}

	
}