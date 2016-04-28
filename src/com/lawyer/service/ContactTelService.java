package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Users;

public interface ContactTelService {

	public void insertContactTel(ContactTel contactTel) throws Exception;//������ִ������ϵ��Ϣ���绰��ϵ�������ξ�
	public ContactTel selectContactTel(ContactTel contactTel,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡��ξ�
	public List selectContactTel(ContactTel contactTel)throws Exception;//��ѯ������ִ������ϵ��Ϣ���绰��ϵ�������ξ�
	public void updateContactTel(ContactTel contactTel)throws Exception;//�޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ�����绰��ϵ�� �����ξ�
	public void deleteContactTel(ContactTel contactTel)throws Exception;//ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ�����绰��ϵ�� �����ξ�

	/**
	 * ��ӵ绰��ϵ��Ϣʱ��ʾ֮ǰ����Ϣ
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactTel showConTel(String casecodeself) throws Exception;
	
}
