package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.Users;

public interface ContactSeeService {

	public void insertContactSee(ContactSee contactSee) throws Exception;//���   ������ִ������ϵ��Ϣ�����Űݷã������ξ�
	public ContactSee selectContactSee(ContactSee contactSee,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶���,������ִ������ϵ��Ϣ�����Űݷã������ξ�
	public List selectContactSee(ContactSee contactSee)throws Exception;//��ѯ������ִ������ϵ��Ϣ�����Űݷã������ξ�
	public void updateContactSee(ContactSee contactSee)throws Exception;//�޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ�������Űݷã� �����ξ�
	public void deleteContactSee(ContactSee contactSee)throws Exception;//ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ�������Űݷã� �����ξ�
}
