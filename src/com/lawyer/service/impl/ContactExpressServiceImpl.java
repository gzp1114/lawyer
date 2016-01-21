package com.lawyer.service.impl;

import java.util.Iterator;
import java.util.List;

import com.lawyer.dao.ContactExpressDao;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactExpressService;

public class ContactExpressServiceImpl implements ContactExpressService {

	private ContactExpressDao contactExpressDao;
	public ContactExpressDao getContactExpressDao() {
		return contactExpressDao;
	}
	public void setContactExpressDao(ContactExpressDao contactExpressDao) {
		this.contactExpressDao = contactExpressDao;
	}

	/**
	 * ���   ������ִ������ϵ��Ϣ����ݣ�
	 */
	public void insertContactExpress(ContactExpress contactExpress)
			throws Exception {
		contactExpressDao.insertContactExpress(contactExpress);
	}

	/**
	 * ����Ȩ�ޣ���ѯ���޶���, ������ִ������ϵ��Ϣ����ݣ�
	 */
	public ContactExpress selectContactExpress(ContactExpress contactExpress,
			Users users) throws Exception {
		return contactExpressDao.selectContactExpress(contactExpress, users);
	}

	/**
	 * ��ѯ   ������ִ������ϵ��Ϣ����ݣ�
	 */
	public List selectContactExpress(ContactExpress contactExpress)
			throws Exception {
		return contactExpressDao.selectContactExpress(contactExpress);
	}

	/**
	 * �޸�   ������ִ������ϵ��Ϣ����ݣ�
	 */
	public void updateContactExpress(ContactExpress contactExpress)
			throws Exception {
		contactExpressDao.updateContactExpress(contactExpress);
	}

	/**
	 * ɾ��   ������ִ������ϵ��Ϣ����ݣ�
	 */
	public void deleteContactExpress(ContactExpress contactExpress)
			throws Exception {
		contactExpressDao.deleteContactExpress(contactExpress);
	}
}
