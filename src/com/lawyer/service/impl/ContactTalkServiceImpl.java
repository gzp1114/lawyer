package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ContactTalkDao;
import com.lawyer.pojo.ContactTalk;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactTalkService;

public class ContactTalkServiceImpl implements ContactTalkService{
	
	private ContactTalkDao contactTalkDao;
	public ContactTalkDao getContactTalkDao() {
		return contactTalkDao;
	}
	public void setContactTalkDao(ContactTalkDao contactTalkDao) {
		this.contactTalkDao = contactTalkDao;
	}

	/**
	 * ���   ������ִ������ϵ��Ϣ�����Űݷã�
	 */
	public void insertContactTalk(ContactTalk contactSee) throws Exception {
		contactTalkDao.insertContactTalk(contactSee);
	}

	/**
	 * ����Ȩ�ޣ���ѯ���޶���,������ִ������ϵ��Ϣ�����Űݷã�
	 */
	public ContactTalk selectContactTalk(ContactTalk contactSee, Users users)
			throws Exception {
		return contactTalkDao.selectContactTalk(contactSee, users);
	}

	/**
	 * ��ѯ������ִ������ϵ��Ϣ�����Űݷã�
	 */
	public List<ContactTalk> selectContactTalk(ContactTalk contactSee) throws Exception {
		return contactTalkDao.selectContactTalk(contactSee);
	}

	/**
	 * �޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ�������Űݷã�
	 */
	public void updateContactTalk(ContactTalk contactSee) throws Exception {
		contactTalkDao.updateContactTalk(contactSee);
	}

	/**
	 * ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ�������Űݷã�
	 */
	public void deleteContactTalk(ContactTalk contactSee) throws Exception {
		contactTalkDao.deleteContactTalk(contactSee);
	}
	@Override
	public ContactTalk showConTalk(String casecodeself) throws Exception {
		return contactTalkDao.showConTalk(casecodeself);
	}
}
