package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContactMail;

public interface ContactMailDao {

	public void insertContactMail(ContactMail contactMail) throws Exception;//������ִ������ϵ��Ϣ�������ʼ��������ξ�
	@SuppressWarnings("rawtypes")
	public List selectContactMail(ContactMail contactMail)throws Exception;//��ѯ������ִ������ϵ��Ϣ�������ʼ��������ξ�
	public void updateContactMail(ContactMail contactMail)throws Exception;//�޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ���������ʼ��� �����ξ�
	public void deleteContactMail(ContactMail contactMail)throws Exception;//ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ���������ʼ��� �����ξ�

	/**
	 * ����ʼ���Ϣʱ��ʾ֮ǰ����Ϣ
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactMail showConMail(String casecodeself) throws Exception;
}
