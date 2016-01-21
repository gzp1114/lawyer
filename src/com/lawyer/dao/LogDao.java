package com.lawyer.dao;

import java.util.Date;
import java.util.List;

import com.lawyer.pojo.Log;
import com.lawyer.pojo.Users;

public interface LogDao {
	/**
	 * ��õ�ǰϵͳʱ�䷽��
	 * ������
	 * */
	public String getDataTime()throws Exception;
	/**
	 * ���еĲ�������¼����־��������½���˳���
	 * ������
	 * */
	public void insert(Log log)throws Exception;
	/**
	 * ͨ���û����Ժ���ѯ�û���־��¼
	 * ������
	 * */
	public List selectUsersName(Users users)throws Exception;
	/**
	 * ͨ���û����Ժ���ѯ����Ա��־��¼
	 * ������
	 * */
	public List selectUsersName2(Users users) throws Exception;
}
