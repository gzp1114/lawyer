package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Users;

public interface ApplyDao {
	/**
	 *ͨ���û���ģ����ѯ������Ϣ
	 *������
	 * */
	public List selectName(Users users)throws Exception;
	/**
	 * ͨ���û�ID��׼��Ȩ
	 * ������
	 * */
	public void authorize(Apply apply)throws Exception;
	/**
	 * ͨ���û�ID�õ���Ȩ��¼
	 * ������
	 * */
	public Apply selectID(Apply apply)throws Exception;
	/**
	 * ͨ���û�ID�ܾ���Ȩ
	 * ������
	 * */
	public void decline(Apply apply)throws Exception;
	/**
	 *ͨ���û���ģ����ѯ������Ϣ2
	 *������
	 * */
	public List selectName2(Users users)throws Exception;
}
