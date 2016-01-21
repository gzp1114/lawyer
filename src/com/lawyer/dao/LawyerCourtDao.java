package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.LawyerCourt;

/**
 * @date 2013-4-13 15:45:03
 * @author ������
 *	��Ժ�ĳ־û���
 */
public interface LawyerCourtDao {
	/**
	 * �������з�Ժ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<LawyerCourt> selectAll() throws Exception;
	/**
	 * ����һ���ķ�Ժ
	 */
	public List<LawyerCourt> selectFirst() throws Exception;
	/**
	 * ����һ�����Ҷ���
	 */
	public List<LawyerCourt> selectSecond(String fir_id) throws Exception;
	/**
	 * ���ݶ�����������
	 */
	public List<LawyerCourt> selectThird(String sec_id) throws Exception;
	/**
	 * ����id���ҷ�Ժ
	 */
	public LawyerCourt selectCourtByID(int courtid) throws Exception;
	
	/**
	 * ����number���ҷ�Ժ
	 */
	public LawyerCourt selectCourtByNumber(String courtnumber) throws Exception;
}
