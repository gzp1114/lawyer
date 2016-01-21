package com.lawyer.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.LawyerCourtDao;
import com.lawyer.pojo.LawyerCourt;

public class LawyerCourtDaoImpl extends HibernateDaoSupport implements LawyerCourtDao {

	/**
	 * �������з�Ժ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LawyerCourt> selectAll() throws Exception {
		return this.getHibernateTemplate().find("from LawyerCourt");
	}
	/**
	 * ����һ���ķ�Ժ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LawyerCourt> selectFirst() throws Exception {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from LawyerCourt c where c.lawyerCourt_pid = 0");
	}
	/**
	 * ����һ�����Ҷ���
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LawyerCourt> selectSecond(String fir_id) throws Exception {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from LawyerCourt c where c.lawyerCourt_pid ="+fir_id);
	}
	/**
	 * ���ݶ�����������
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LawyerCourt> selectThird(String sec_id) throws Exception {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from LawyerCourt c where c.lawyerCourt_pid ="+sec_id);
	}
	/**
	 * ����id���ҷ�Ժ
	 */
	@SuppressWarnings("unchecked")
	public LawyerCourt selectCourtByID(int courtid) throws Exception {
		// TODO Auto-generated method stub
		return (LawyerCourt) this.getHibernateTemplate().get(LawyerCourt.class, courtid);
	}
	
	/**
	 * ����number���ҷ�Ժ
	 */
	public LawyerCourt selectCourtByNumber(String courtnumber) throws Exception {
		LawyerCourt lawyerCourt = new LawyerCourt();
		Iterator<LawyerCourt> lcs = this
		.getHibernateTemplate()
		.find("from LawyerCourt lc where lc.lawyerCourt_number='"
				+ courtnumber + "'")
		.iterator();
		while (lcs.hasNext()) {
			lawyerCourt = lcs.next();
		}
		return lawyerCourt;
	}

}
