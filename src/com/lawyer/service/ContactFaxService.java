package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.Users;

public interface ContactFaxService {

	public void insertContactFax(ContactFax contactFax) throws Exception;//���   ������ִ������ϵ��Ϣ�����棩�����ξ�
	public ContactFax selectContactFax(ContactFax contactFax,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶���,������ִ������ϵ��Ϣ�����棩�����ξ�
	public List selectContactFax(ContactFax contactFax)throws Exception;//��ѯ������ִ������ϵ��Ϣ�����棩�����ξ�
	public void updateContactFax(ContactFax contactFax)throws Exception;//�޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ�������棩 �����ξ�
	public void deleteContactFax(ContactFax contactFax)throws Exception;//ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ�������棩 �����ξ�
}
