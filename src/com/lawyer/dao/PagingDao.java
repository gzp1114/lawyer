package com.lawyer.dao;

import java.util.List;

import com.lawyer.tools.PageBean;

public interface PagingDao {
	/** 
     * ��ҳ��ѯ
     * @param hql ��ѯ������
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ������¼
     * @return
     */
    public List queryForPage(final String hql,final int offset,final int length);
    
    /**
     * ��ѯ���м�¼��
     * @param hql ��ѯ������
     * @return �ܼ�¼��
     */
    public int getAllRowCount(String hql);
    
	/**
     * ��ҳ��ѯ
     * @param page ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryForPage(int pageSize,int page,Object obj,String i,String starttime,String endtime);
}
