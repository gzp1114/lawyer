package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;

public interface ExecutebusinessService {
	
	public void insertStep2(Executebusiness executebus)throws Exception; //��ӵڶ���
	public void insertMoreExecutes(Users user) throws Exception;//��Դ�ڶ�����ִ������ҵ��Ϣ�����������������־��
	public List<Executebusiness> selExecutebusiness(Executebusiness executebus)throws Exception;
	public void insertEb(Executebusiness executebus) throws Exception;
    public void Executebusiness(List<com.lawyer.pojo.Executebusiness> list);
    
    
    /**
	 * excel���뱻ִ������ҵ��Ϣ
     * @throws Exception 
	 */
	public void excelInsertExecutebusiness(List<Executebusiness> dataList) throws Exception;
    
}
