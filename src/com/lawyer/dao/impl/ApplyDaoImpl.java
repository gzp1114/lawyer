package com.lawyer.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ApplyDao;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Users;

public class ApplyDaoImpl extends HibernateDaoSupport implements ApplyDao{
	/**
	 *ͨ���û���ģ����ѯ������Ϣ
	 *������
	 * */
	public List selectName(Users users) throws Exception {
		return this.getHibernateTemplate().find("select a from Apply a left join a.users u where u.UName like '%"+users.getUName()+"%' and a.appSta ='������'");
	}
	/**
	 * ͨ���û�ID��׼��Ȩ
	 * ������
	 * */
	public void authorize(Apply apply) throws Exception {
		this.getHibernateTemplate().update(apply);
	}
	/**
	 * ͨ���û�ID�õ���Ȩ��¼
	 * ������
	 * */
	public Apply selectID(Apply apply) throws Exception {
		return (Apply) this.getHibernateTemplate().get(Apply.class, apply.getAppId());
	}
	/**
	 * ͨ���û�ID�ܾ���Ȩ
	 * ������
	 * */
	public void decline(Apply apply) throws Exception {
		this.getHibernateTemplate().delete(apply);
	}
	/**
	 *ͨ���û���ģ����ѯ������Ϣ2
	 *������
	 * */
	public List selectName2(Users users) throws Exception {
		return this.getHibernateTemplate().find("from Apply a left join fetch a.users u where u.UName like '%"+users.getUName()+"%' and a.appSta ='����׼'");
	}
}
