package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ApplierinfoNetworkDao;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplierinfoNetworkService;

public class ApplierinfoNetworkServiceImpl implements ApplierinfoNetworkService{

	private ApplierinfoNetworkDao applierinfoNetworkDao;
	
	public ApplierinfoNetworkDao getApplierinfoNetworkDao() {
		return applierinfoNetworkDao;
	}

	public void setApplierinfoNetworkDao(ApplierinfoNetworkDao applierinfoNetworkDao) {
		this.applierinfoNetworkDao = applierinfoNetworkDao;
	}
	
	/**
	 * �������ִ������ҵ��Ϣ��������Ϣ��
	 * @since 13.3.21
	 */
	public void insertAppnet(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		applierinfoNetworkDao.insertAppnet(applierinfoNetwork);
	}

	/**
	 * ����Ȩ�ޣ���ѯ���޶���
	 * @return ����
	 */
	public ApplierinfoNetwork selectAppnet(
			ApplierinfoNetwork applierinfoNetwork, Users users)
			throws Exception {
		return applierinfoNetworkDao.selectAppnet(applierinfoNetwork, users);
	}

	public List selectAppnet(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		return applierinfoNetworkDao.selectAppnet(applierinfoNetwork);
	}

	/**
	 * �޸İ�Դ��Ϣ������ִ������ҵ��Ϣ����������Ϣ��
	 */
	public void updateAppnet(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		this.applierinfoNetworkDao.updateAppnet(applierinfoNetwork);
	}

	/**
	 * ��Դ����������ִ������ҵ��Ϣ��������Ϣ��������־��
	 */
	public void insertAppNets(Users user) throws Exception {
		this.applierinfoNetworkDao.insertAppNets(user);
		
	}

	@Override
	public void insertAppnetOne(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		this.applierinfoNetworkDao.insertAppnetOne(applierinfoNetwork);
		
	}

	@Override
	public void deleteAppnet(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		this.applierinfoNetworkDao.deleteAppnet(applierinfoNetwork);
	}

}
