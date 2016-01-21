package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Users;

public interface ContactMailService {
	
	public void insertContactMail(ContactMail contactMail) throws Exception;//������ִ������ϵ��Ϣ�������ʼ��������ξ�
	public ContactMail selectContactMail(ContactMail contactMail,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡��ξ�
	public List selectContactMail(ContactMail contactMail)throws Exception;//��ѯ������ִ������ϵ��Ϣ�������ʼ��������ξ�
	public void updateContactMail(ContactMail contactMail)throws Exception;//�޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ���������ʼ��� �����ξ�
	public void deleteContactMail(ContactMail contactMail)throws Exception;//ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ���������ʼ��� �����ξ�

}
