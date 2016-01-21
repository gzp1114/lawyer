package com.lawyer.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lawyer.dao.LogDao;
import com.lawyer.pojo.Log;
import com.lawyer.pojo.Users;

public class LogDaoImpl extends HibernateDaoSupport implements LogDao{

	/**
	 * ��õ�ǰϵͳʱ�䷽��
	 * ����ֵΪ�ַ����� ��-��-��  ʱ���֣���
	 * ������
	 * */
	public String getDataTime() throws Exception {
		Date date=new Date();
		SimpleDateFormat  f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime=f.format(date);
		return dateTime;
	}
	/**
	 * ���еĲ�������¼����־��������½���˳���
	 * 
	 * */
	public void insert(Log log) throws Exception {
		this.getHibernateTemplate().save(log);
	}
	/**
	 * ͨ���û����Ժ���ѯ��ͨ�û���־��¼
	 * ������
	 * */
	@SuppressWarnings("unchecked")
	public List selectUsersName(Users users) throws Exception {
		return this.getHibernateTemplate().find("from Log where logUrole='��ͨ�û�' and logUname like '%"+users.getUName()+"%'");
	}
	/**
	 * ͨ���û����Ժ���ѯ����Ա��־��¼
	 * ������
	 * */
	@SuppressWarnings("unchecked")
	public List selectUsersName2(Users users) throws Exception {
		return this.getHibernateTemplate().find("from Log where logUrole='����Ա' and logUname like '%"+users.getUName()+"%'");
	}
}
