package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.Users;

public interface ApplierinfoNetworkService {

	public void insertAppnet(ApplierinfoNetwork applierinfoNetwork) throws Exception;//�������ִ������ҵ��Ϣ��������Ϣ�������ξ�
	public ApplierinfoNetwork selectAppnet(ApplierinfoNetwork applierinfoNetwork,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡��ξ�
	public List selectAppnet(ApplierinfoNetwork applierinfoNetwork)throws Exception;//��ѯ����ִ������ҵ��Ϣ��������Ϣ�������ξ�
	public void updateAppnet(ApplierinfoNetwork applierinfoNetwork)throws Exception;//�޸İ�Դ��Ϣ������ִ������ҵ��Ϣ����������Ϣ�� �����ξ�
	public void insertAppNets(Users user) throws Exception;//��Դ����������ִ������ҵ��Ϣ��������Ϣ��������־��
	public void insertAppnetOne(ApplierinfoNetwork applierinfoNetwork )throws Exception;
	public void deleteAppnet(ApplierinfoNetwork applierinfoNetwork)throws Exception;
}
