package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Users;

public interface ApplierinfoOnselfService {

	public void insertAppOnself(ApplierinfoOnself applierinfoOnself) throws Exception;//�������ִ������ҵ��Ϣ��������Ϣ�������ξ�
	public ApplierinfoOnself selectAppOnself(ApplierinfoOnself applierinfoOnself,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡��ξ�
	public List selectAppOnself(ApplierinfoOnself applierinfoOnself)throws Exception;//��ѯ����ִ������ҵ��Ϣ��������Ϣ�������ξ�
	public void updateAppOnself(ApplierinfoOnself applierinfoOnself)throws Exception;//�޸İ�Դ��Ϣ������ִ������ҵ��Ϣ����������Ϣ�� �����ξ�
	public void deleteAppOnself(ApplierinfoOnself applierinfoOnself)throws Exception;//ɾ����Դ��Ϣ������ִ������ҵ��Ϣ����������Ϣ�� �����ξ�
}
