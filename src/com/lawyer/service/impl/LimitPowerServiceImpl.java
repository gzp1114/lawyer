package com.lawyer.service.impl;

import com.lawyer.dao.LimitPowerDao;
import com.lawyer.pojo.LimitPower;
import com.lawyer.service.LimitPowerService;

public class LimitPowerServiceImpl implements LimitPowerService{
	private LimitPowerDao lpdao;
	/**
	 * ����û�Ȩ��
	 */
	@Override
	public void addLP(LimitPower limitPower) {
		// TODO Auto-generated method stub
		lpdao.addLP(limitPower);
	}
	/**
	 * �����û�����ѯ�û�Ȩ��
	 */
	@Override
	public LimitPower findLPByUserName(String user_name) {
		// TODO Auto-generated method stub
		return lpdao.selectLPByUserName(user_name);
	}
	/**
	 * �޸��û�Ȩ��
	 */
	@Override
	public void updLP(LimitPower limitPower) {
		// TODO Auto-generated method stub
		lpdao.updLP(limitPower);
	}
	/**
	 * ɾ���û�Ȩ��
	 */
	@Override
	public void removeLP(LimitPower limitPower) {
		// TODO Auto-generated method stub
		lpdao.delLP(limitPower);
	}
	public LimitPowerDao getLpdao() {
		return lpdao;
	}
	public void setLpdao(LimitPowerDao lpdao) {
		this.lpdao = lpdao;
	}
	
}
