package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Users;

public interface ContractSignDao {

	public void insertContractSign(ContractSign contractSign) throws Exception;//������ִ������ϵ��Ϣ��ǩԼ����������ξ�
	public ContractSign selectContractSign(ContractSign contractSign,Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡��ξ�
	public List selectContractSign(ContractSign contractSign)throws Exception;//��ѯ������ִ������ϵ��Ϣ��ǩԼ����������ξ�
	public void updateContractSign(ContractSign contractSign)throws Exception;//�޸İ�Դ��Ϣ��������ִ������ϵ��Ϣ����ǩԼ����� �����ξ�
	public void deleteContractSign(ContractSign contractSign)throws Exception;//ɾ����Դ��Ϣ��������ִ������ϵ��Ϣ����ǩԼ����� �����ξ�
}
