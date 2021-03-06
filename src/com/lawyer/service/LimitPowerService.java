package com.lawyer.service;

import com.lawyer.pojo.LimitPower;

public interface LimitPowerService {
	/**
	 * 根据用户名查询用户权限
	 * @param user_name
	 * @return
	 */
	public LimitPower findLPByUserName(String user_name);
	/**
	 * 添加用户权限
	 * @param limitPower
	 */
	public void addLP(LimitPower limitPower);
	/**
	 * 修改用户权限
	 * @param limitPower
	 */
	public void updLP(LimitPower limitPower);
	/**
	 * 删除用户权限
	 */
	public void removeLP(LimitPower limitPower);
}
