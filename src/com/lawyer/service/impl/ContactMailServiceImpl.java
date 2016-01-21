package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ContactMailDao;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactMailService;

public class ContactMailServiceImpl implements ContactMailService {

	private ContactMailDao contactMailDao;
	
	public ContactMailDao getContactMailDao() {
		return contactMailDao;
	}

	public void setContactMailDao(ContactMailDao contactMailDao) {
		this.contactMailDao = contactMailDao;
	}

	/**
	 * ������ִ������ϵ��Ϣ�������ʼ���
	 */
	public void insertContactMail(ContactMail contactMail) throws Exception {
		this.contactMailDao.insertContactMail(contactMail);
	}

	/**
	 * ����Ȩ�ޣ���ѯ���޶���������ִ������ϵ��Ϣ�������ʼ���
	 */
	public ContactMail selectContactMail(ContactMail contactMail, Users users)
			throws Exception {	
		ContactMail conMa = null;
		return conMa;
	}

	/**
	 * ��ѯ������ִ������ϵ��Ϣ�������ʼ���
	 */
	@SuppressWarnings("unchecked")
	public List selectContactMail(ContactMail contactMail) throws Exception {
		return this.contactMailDao.selectContactMail(contactMail);
	}

	/**
	 * �޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ���������ʼ���
	 */
	public void updateContactMail(ContactMail contactMail) throws Exception {
		
	}
	
	/**
	 * ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ���������ʼ���
	 */
	public void deleteContactMail(ContactMail contactMail) throws Exception {
		
	}

}
