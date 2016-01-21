package com.lawyer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lawyer.dao.PagingDao;
import com.lawyer.pojo.Filelibrary;
import com.lawyer.pojo.Files;
import com.lawyer.tools.PageBean;

public class PagingDaoImpl extends HibernateDaoSupport implements PagingDao{

	public int getAllRowCount(String hql) {
		List list=this.getHibernateTemplate().find(hql);
		return list.size();
	}

	/**
	 * �����ݱ��е����ݷ�ҳ����List
	 */
	public List queryForPage(String hql, int offset, int length) {
		//Hibernate��ҳ
		Query q=this.getSession().createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List list=q.list();
		return list;
	}

	/**
	 * �Ȱ����ݱ��е����ݷ�ҳ��List��Ȼ���List��ҳ���ҳ
	 */
	public PageBean queryForPage(int pageSize, int page,Object obj,String i,String starttime,String endtime) {
		// ҳ���ҳ
		String hql=null;
		
		if(i.equals("null")){
			hql="from "+obj;
		}else if(i.equals("filelibrary")){
			Filelibrary fl=(Filelibrary) obj;
			hql="from Filelibrary where fl_name like '%"+fl.getFlName()+"%' and fl_category like '%"+fl.getFlCategory()+"%'";
		}else if(i.equals("files")){
			Files f=(Files) obj;
			hql="from Files where filelibrary.flId="+f.getFilelibrary().getFlId();
		}else if(i.equals("files2")){
			Files f=(Files) obj;
			hql="from Files where filelibrary.flId = '"+f.getFilelibrary().getFlId()+"' and FTitle like '%"+f.getFTitle()+"%' and FReldate between '"+starttime+"' and '"+endtime+"' ";
		}
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
