package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContactTalk;
import com.lawyer.pojo.Users;

public interface ContactTalkDao {

	public void insertContactTalk(ContactTalk contactTalk) throws Exception;//���   ������ִ������ϵ��Ϣ�����Űݷã������ξ�
	public ContactTalk selectContactTalk(ContactTalk contactTalk,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶���,������ִ������ϵ��Ϣ�����Űݷã������ξ�
	public List<ContactTalk> selectContactTalk(ContactTalk contactTalk)throws Exception;//��ѯ������ִ������ϵ��Ϣ�����Űݷã������ξ�
	public void updateContactTalk(ContactTalk contactTalk)throws Exception;//�޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ�������Űݷã� �����ξ�
	public void deleteContactTalk(ContactTalk contactTalk)throws Exception;//ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ�������Űݷã� �����ξ�

	/**
	 * ���Լ̸��Ϣʱ��ʾ֮ǰ����Ϣ
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactTalk showConTalk(String casecodeself) throws Exception;
}
