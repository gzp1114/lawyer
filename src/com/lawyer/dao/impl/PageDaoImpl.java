package com.lawyer.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lawyer.dao.IPageDao;
import com.lawyer.pojo.PageBean;


public class PageDaoImpl extends HibernateDaoSupport implements IPageDao {

	/**
	 * ��ѯ���м�¼�� 
	 * @param hql ��ѯ������
	 * @return �ܼ�¼��
	 */
	public int getAllRowCount(String hql) throws Exception {
		List list=this.getHibernateTemplate().find(hql);
		return list.size();
	}

	/**
	 * ��ҳ��ѯ
     * @param hql ��ѯ������
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ������¼
     * @return list
	 */
	public List queryForPage(String hql, int offset, int length)
			throws Exception {
		Query q=this.getSession().createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List list=q.list();
		return list;
	}

	/**
	 * ������
	 * ͨ�÷�ҳ�������÷�ʽ
	 * ���һ���ַ��� where ��д��ѯҪ�õ�����
	 * */
	/**
	 * ��ҳ��ѯ
     * @param page ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	public PageBean queryForPage(int pageSize, int page, String object,
			String id,String where) throws Exception {
		String hql="from "+object+" "+where+" order by "+id+" desc";
		//������
		int allRow=getAllRowCount(hql);
		//��ҳ��
		int totalPage=PageBean.countTotalPage(pageSize, allRow);
		//��ǰҳ
		int currentPage=PageBean.countCurrentPage(page);
		//��ǰҳ��ʼ��¼
		int offset=PageBean.countOffset(pageSize, currentPage);
		List list=queryForPage(hql,offset,pageSize);
		//�Ѹ������Է�װ��PageBean
		PageBean pb=new PageBean();
		pb.setAllRow(allRow);
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage);
		pb.setList(list);
		pb.init();
		return pb;
	}

}
