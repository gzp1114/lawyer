package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Users;

public interface UsersService {
	
	/**
	 * ����Ա�û���½����
	 * ������
	 */
	public Users login(Users users) throws Exception ;
	/**
	 * ����Ա����û������������ɲ�ѯ�����û���Ϣ����ת��SHOWҳ�棬��ҳ��ʾ
	 * ������
	 * */
	public void insert(Users users)throws Exception ;
	/**
	 * ͨ��Id�õ��û���Ϣ
	 * ������
	 * */
	public Users SelectID(Users users)throws Exception ;
	/**
	 * ͨ��Id�޸��û���Ϣ
	 * ������
	 * */
	public void update(Users users)throws Exception ;
	/**
	 * ͨ��Name�õ��û���Ϣ
	 * ������
	 * */
	public List selectName(Users users)throws Exception ;
	/**
	 * ͨ��IDɾ���û���Ϣ
	 * ������
	 * */
	public void delete(Users users)throws Exception ;
	
	/**
	 * ��ȡ���е���ʦ
	 * @return
	 * @throws Exception
	 */
	public List<Users> selectLawyers()throws Exception ;
	
	
	/**
	 * ��ȡ���еİ칫��Ա
	 * @return
	 * @throws Exception
	 */
	public List<Users> selectPensons()throws Exception ;
	
	
}
