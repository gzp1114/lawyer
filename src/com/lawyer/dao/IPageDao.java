package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.PageBean;



public interface IPageDao {
	
	/** 
     * ��ҳ��ѯ
     * @param hql ��ѯ������
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ������¼
     * @return list
     */
    public List queryForPage(final String hql,final int offset,final int length) throws Exception;
    
    /**
     * ��ѯ���м�¼��
     * @param hql ��ѯ������
     * @return �ܼ�¼��
     */
    public int getAllRowCount(String hql) throws Exception;
    
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
    public PageBean queryForPage(int pageSize,int page,String object,String id,String where) throws Exception;

}
