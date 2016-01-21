package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.LawyerCourtDao;
import com.lawyer.pojo.LawyerCourt;
import com.lawyer.service.LawyerCourtService;

/**
 * @date 2013-4-13 15:57:01
 * @author ������
 *	��Ժ��ҵ���߼�
 */
public class LawyerCourtServiceImpl implements LawyerCourtService{
	private LawyerCourtDao lawyerCourtDao;
	public void setLawyerCourtDao(LawyerCourtDao lawyerCourtDao) {
		this.lawyerCourtDao = lawyerCourtDao;
	}
	/**
	 * �������з�Ժ��Ϣ
	 */
	@Override
	public List<?> findAllLawyerCourt() throws Exception {
		return lawyerCourtDao.selectAll();
	}
	/**
	 * �������е�һ����Ժ
	 */
	@Override
	public List<LawyerCourt> findFirstLawyerCourt() throws Exception {
		// TODO Auto-generated method stub
		return lawyerCourtDao.selectFirst();
	}
	/**
	 * ����һ����Ժ���Ҷ�Ӧ�Ķ�����Ժ
	 */
	@Override
	public List<LawyerCourt> findSecondLawyerCourt(String firId)
			throws Exception {
		// TODO Auto-generated method stub
		return lawyerCourtDao.selectSecond(firId);
	}
	/**
	 * ���ݶ�����Ժ���Ҷ�Ӧ��������Ժ
	 */
	@Override
	public List<LawyerCourt> findThirdLawyerCourt(String secId)
			throws Exception {
		// TODO Auto-generated method stub
		return lawyerCourtDao.selectThird(secId);
	}
	/**
	 * ����id���ҷ�Ժ
	 */
	public LawyerCourt selectCourtByID(int courtid) throws Exception {
		// TODO Auto-generated method stub
		return lawyerCourtDao.selectCourtByID(courtid);
	}
	@Override
	public LawyerCourt selectCourtByNumber(String courtnumber) throws Exception {
		return lawyerCourtDao.selectCourtByNumber(courtnumber);
	}

	
	
}
