package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ContactSeeDao;
import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactSeeService;

public class ContactSeeServiceImpl implements ContactSeeService{
	
	private ContactSeeDao contactSeeDao;
	public ContactSeeDao getContactSeeDao() {
		return contactSeeDao;
	}
	public void setContactSeeDao(ContactSeeDao contactSeeDao) {
		this.contactSeeDao = contactSeeDao;
	}

	/**
	 * ���   ������ִ������ϵ��Ϣ�����Űݷã�
	 */
	public void insertContactSee(ContactSee contactSee) throws Exception {
		contactSeeDao.insertContactSee(contactSee);
	}

	/**
	 * ����Ȩ�ޣ���ѯ���޶���,������ִ������ϵ��Ϣ�����Űݷã�
	 */
	public ContactSee selectContactSee(ContactSee contactSee, Users users)
			throws Exception {
		return contactSeeDao.selectContactSee(contactSee, users);
	}

	/**
	 * ��ѯ������ִ������ϵ��Ϣ�����Űݷã�
	 */
	@SuppressWarnings("unchecked")
	public List selectContactSee(ContactSee contactSee) throws Exception {
		return contactSeeDao.selectContactSee(contactSee);
	}

	/**
	 * �޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ�������Űݷã�
	 */
	public void updateContactSee(ContactSee contactSee) throws Exception {
		contactSeeDao.updateContactSee(contactSee);
	}

	/**
	 * ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ�������Űݷã�
	 */
	public void deleteContactSee(ContactSee contactSee) throws Exception {
		contactSeeDao.deleteContactSee(contactSee);
	}
}
