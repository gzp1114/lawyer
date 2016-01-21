package com.lawyer.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.AddrecordDao;
import com.lawyer.pojo.Addrecord;

public class AddrecordDaoImpl extends HibernateDaoSupport implements AddrecordDao {

	/**
	 * //��� �û���Ӱ�����¼������־��
	 */
	public void insertRecord(Addrecord addrecord) throws Exception {
		this.getHibernateTemplate().save(addrecord);
	}

}
