package com.lawyer.service.impl;

import java.util.Date;
import java.util.List;

import com.lawyer.dao.LogDao;
import com.lawyer.pojo.Log;
import com.lawyer.pojo.Users;
import com.lawyer.service.LogService;

public class LogServiceImpl implements LogService{

	//:��װ��Log�����Dao�ӿ�
	private LogDao logDao;
	
	public LogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	/**
	 * ��õ�ǰϵͳʱ�䷽��
	 * ������
	 * */
	public String getDataTime() throws Exception {
		return logDao.getDataTime();
	}
	/**
	 * ���еĲ�������¼����־��������½���˳���
	 * ������
	 * */
	public void insert(Log log) throws Exception {
		logDao.insert(log);
	}
	/**
	 * ͨ���û����Ժ���ѯ�û���־��¼
	 * ������
	 * */
	public List selectUsersName(Users users) throws Exception {
		return logDao.selectUsersName(users);
	}
	/**
	 * ͨ���û����Ժ���ѯ����Ա��־��¼
	 * ������
	 * */
	public List selectUsersName2(Users users) throws Exception {
		return logDao.selectUsersName2(users);
	}
	
}
