package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.UsersDao;
import com.lawyer.pojo.Users;
import com.lawyer.service.UsersService;

public class UsersServiceImpl implements UsersService {
	
	//:��װ��Users������ӿ�
	private UsersDao usersDao;
	public UsersDao getUsersDao() {
		return usersDao;
	}
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	/**
	 * ����Ա�û���½����
	 */
	public Users login(Users users)throws Exception  {
		return usersDao.login(users);
	}

	/**
	 * ����Ա����û������������ɲ�ѯ�����û���Ϣ����ת��SHOWҳ�棬��ҳ��ʾ
	 * */
	public void insert(Users users) throws Exception {
		usersDao.insert(users);
	}

	/**
	 * ͨ��Id�õ��û���Ϣ
	 * */
	public Users SelectID(Users users) throws Exception {
		return usersDao.SelectID(users);
	}

	/**
	 * ͨ��Id�޸��û���Ϣ
	 * */
	public void update(Users users) throws Exception {
		 usersDao.update(users);
	}

	/**
	 * ͨ��Name�õ��û���Ϣ
	 * */
	public List selectName(Users users) throws Exception {
		return usersDao.selectName(users);
	}
	/**
	 * ͨ��IDɾ���û���Ϣ
	 * */
	public void delete(Users users) throws Exception {
		usersDao.delete(users);
	}
	@Override
	public List<Users> selectLawyers() throws Exception {
		return usersDao.selectLawyers();
	}
	
	@Override
	public List<Users> selectPensons() throws Exception {
		return usersDao.selectPensons();
	}
}
