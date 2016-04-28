package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ContactTelDao;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactTelService;

public class ContactTelServiceImpl implements ContactTelService {

	private ContactTelDao contactTelDao;
	public ContactTelDao getContactTelDao() {
		return contactTelDao;
	}
	public void setContactTelDao(ContactTelDao contactTelDao) {
		this.contactTelDao = contactTelDao;
	}

	/**
	 * ���   ������ִ������ϵ��Ϣ���绰��ϵ��
	 */
	public void insertContactTel(ContactTel contactTel) throws Exception {
		contactTelDao.insertContactTel(contactTel);
	}

	/**
	 * ����Ȩ�ޣ���ѯ���޶���, ������ִ������ϵ��Ϣ���绰��ϵ��
	 */
	public ContactTel selectContactTel(ContactTel contactTel, Users users)
			throws Exception {
		return contactTelDao.selectContactTel(contactTel, users);
	}

	/**
	 * ��ѯ   ������ִ������ϵ��Ϣ���绰��ϵ��
	 */
	public List selectContactTel(ContactTel contactTel) throws Exception {
		return contactTelDao.selectContactTel(contactTel);
	}

	/**
	 * �޸�   ������ִ������ϵ��Ϣ���绰��ϵ��
	 */
	public void updateContactTel(ContactTel contactTel) throws Exception {
		contactTelDao.updateContactTel(contactTel);
	}

	/**
	 * ɾ��   ������ִ������ϵ��Ϣ���绰��ϵ��
	 */
	public void deleteContactTel(ContactTel contactTel) throws Exception {
		contactTelDao.deleteContactTel(contactTel);
	}
	@Override
	public ContactTel showConTel(String casecodeself) throws Exception {
		return contactTelDao.showConTel(casecodeself);
	}
}
