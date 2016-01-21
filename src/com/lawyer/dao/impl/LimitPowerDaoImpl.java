package com.lawyer.dao.impl;

import java.util.Iterator;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.LimitPowerDao;
import com.lawyer.pojo.LimitPower;
/**
 * �û�Ȩ�޳־ò�ʵ����
 * @author ������
 * @date 2013-5-6 19:46:32
 *
 */
public class LimitPowerDaoImpl extends HibernateDaoSupport implements LimitPowerDao{
	/**
	 * ����û�Ȩ��
	 */
	@Override
	public void addLP(LimitPower limitPower) {
		this.getHibernateTemplate().save(limitPower);
	}
	/**
	 * �����û�����ѯ�û�Ȩ��
	 */
	@Override
	public LimitPower selectLPByUserName(String userName) {
		LimitPower lp = null;
		Iterator<?> it = this.getHibernateTemplate().find("from LimitPower as lp where lp.lp_user_name='"+userName+"'").iterator();
		while(it.hasNext()){
			lp = (LimitPower) it.next();
		}
		return lp;
	}
	/**
	 * �޸��û�Ȩ��
	 */
	@Override
	public void updLP(LimitPower limitPower) {
		this.getHibernateTemplate().update(limitPower);
	}
	/**
	 * ɾ���û�Ȩ��
	 */
	@Override
	public void delLP(LimitPower limitPower) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(limitPower);
	}

}
