package com.lawyer.service.impl;

import java.util.Iterator;
import java.util.List;

import com.lawyer.dao.ContactFaxDao;
import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactFaxService;

public class ContactFaxServiceImpl implements ContactFaxService {

	private ContactFaxDao contactFaxDao;
	
	public ContactFaxDao getContactFaxDao() {
		return contactFaxDao;
	}

	public void setContactFaxDao(ContactFaxDao contactFaxDao) {
		this.contactFaxDao = contactFaxDao;
	}

	/**
	 * ���   ������ִ������ϵ��Ϣ�����棩
	 */
	public void insertContactFax(ContactFax contactFax) throws Exception {
		contactFaxDao.insertContactFax(contactFax);
	}

	/**
	 * ����Ȩ�ޣ���ѯ���޶���,������ִ������ϵ��Ϣ�����棩
	 */
	public ContactFax selectContactFax(ContactFax contactFax, Users users)
			throws Exception {
		return contactFaxDao.selectContactFax(contactFax, users);
	}

	/**
	 * ��ѯ   ������ִ������ϵ��Ϣ�����棩
	 */
	public List selectContactFax(ContactFax contactFax) throws Exception {
		return contactFaxDao.selectContactFax(contactFax);
	}

	/**
	 * �޸�   ������ִ������ϵ��Ϣ�����棩
	 */
	public void updateContactFax(ContactFax contactFax) throws Exception {
		contactFaxDao.updateContactFax(contactFax);
	}

	/**
	 * ɾ��   ������ִ������ϵ��Ϣ�����棩
	 */
	public void deleteContactFax(ContactFax contactFax) throws Exception {
		contactFaxDao.deleteContactFax(contactFax);
	}

	@Override
	public ContactFax showConFax(String casecodeself) throws Exception {
		return contactFaxDao.showConFax(casecodeself);
	}
}
