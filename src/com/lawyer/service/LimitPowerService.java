package com.lawyer.service;

import com.lawyer.pojo.LimitPower;

public interface LimitPowerService {
	/**
	 * �����û�����ѯ�û�Ȩ��
	 * @param user_name
	 * @return
	 */
	public LimitPower findLPByUserName(String user_name);
	/**
	 * ����û�Ȩ��
	 * @param limitPower
	 */
	public void addLP(LimitPower limitPower);
	/**
	 * �޸��û�Ȩ��
	 * @param limitPower
	 */
	public void updLP(LimitPower limitPower);
	/**
	 * ɾ���û�Ȩ��
	 */
	public void removeLP(LimitPower limitPower);
}
