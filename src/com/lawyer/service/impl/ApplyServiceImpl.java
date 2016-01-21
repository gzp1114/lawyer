package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ApplyDao;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplyService;

public class ApplyServiceImpl implements ApplyService{
	
	//:��װ��Apply��Dao�ӿ�
	private ApplyDao applyDao;

	public ApplyDao getApplyDao() {
		return applyDao;
	}

	public void setApplyDao(ApplyDao applyDao) {
		this.applyDao = applyDao;
	}
	/**
	 *ͨ���û���ģ����ѯ������Ϣ
	 *������
	 * */
	public List selectName(Users users) throws Exception {
		return applyDao.selectName(users);
	}
	/**
	 * ͨ���û�ID��׼��Ȩ
	 * ������
	 * */
	public void authorize(Apply apply) throws Exception {
		applyDao.authorize(apply);
	}
	/**
	 * ͨ���û�ID�õ���Ȩ��¼
	 * ������
	 * */
	public Apply selectID(Apply apply) throws Exception {
		return applyDao.selectID(apply);
	}
	/**
	 * ͨ���û�ID�ܾ���Ȩ
	 * ������
	 * */
	public void decline(Apply apply) throws Exception {
		applyDao.decline(apply);
	}
	/**
	 *ͨ���û���ģ����ѯ������Ϣ2
	 *������
	 * */
	public List selectName2(Users users) throws Exception {
		return applyDao.selectName2(users);
	}
	
}
