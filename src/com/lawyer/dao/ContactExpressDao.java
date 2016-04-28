package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Users;

public interface ContactExpressDao {

	public void insertContactExpress(ContactExpress contactExpress) throws Exception;//���   ������ִ������ϵ��Ϣ����ݣ������ξ�
	public ContactExpress selectContactExpress(ContactExpress contactExpress,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡��ξ�
	public List selectContactExpress(ContactExpress contactExpress)throws Exception;//��ѯ������ִ������ϵ��Ϣ����ݣ������ξ�
	public void updateContactExpress(ContactExpress contactExpress)throws Exception;//�޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ������ݣ� �����ξ�
	public void deleteContactExpress(ContactExpress contactExpress)throws Exception;//ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ������ݣ� �����ξ�

	/**
	 * ��ӿ����Ϣʱ��ʾ֮ǰ����Ϣ
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactExpress showConExpress(String casecodeself) throws Exception;
}
