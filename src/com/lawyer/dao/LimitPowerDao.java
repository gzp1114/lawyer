package com.lawyer.dao;

import com.lawyer.pojo.LimitPower;

public interface LimitPowerDao {
	/**
	 * �����û�����ѯ�û�Ȩ��
	 * @param user_name
	 * @return
	 */
	public LimitPower selectLPByUserName(String user_name);
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
	public void delLP(LimitPower limitPower);
}
