package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.LawyerCourt;

public interface LawyerCourtService {
	/**
	 * �������з�Ժ
	 * @return
	 * @throws Exception
	 */
	public List<?> findAllLawyerCourt() throws Exception;
	/**
	 * �������е�һ����Ժ
	 * @return
	 */
	public List<LawyerCourt> findFirstLawyerCourt() throws Exception;
	/**
	 * ����һ����Ժ���Ҷ�Ӧ�Ķ�����Ժ
	 * @return
	 */
	public List<LawyerCourt> findSecondLawyerCourt(String fir_id) throws Exception;
	/**
	 *	���ݶ�����Ժ���Ҷ�Ӧ��������Ժ
	 * @return
	 */
	public List<LawyerCourt> findThirdLawyerCourt(String sec_id) throws Exception;
	/**
	 * ����id���ҷ�Ժ
	 */
	public LawyerCourt selectCourtByID(int courtid) throws Exception;
	
	public LawyerCourt selectCourtByNumber(String courtnumber) throws Exception;
}
