package com.lawyer.dao;



import java.util.List;

import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;

public interface ExecutebusinessDao {
	
	
	public void insertStep2(Executebusiness executebus)throws Exception;
	public void insertMoreExecutes(Users user) throws Exception;//��Դ�ڶ�����ִ������ҵ��Ϣ�����������������־��
	public List<Executebusiness> selExecutebusiness(Executebusiness executebus)throws Exception;
	public void insertEb(Executebusiness executebus) throws Exception;
	
	public void Executebusiness(List<com.lawyer.pojo.Executebusiness> list);
	
	//���±�ִ������ҵ��Ϣ
	public void updateExecutes(Executebusiness exbusiness) throws Exception;
	
    
}
