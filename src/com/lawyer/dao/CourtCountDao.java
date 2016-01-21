package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Court;
import com.lawyer.pojo.Tongji;
import com.lawyer.pojo.Users;

public interface CourtCountDao {
	public int countCourtByTime(String sdate, String edate) throws Exception; //��ȡʱ����ڵİ�Դ����---��־��
	public long countCourt() throws Exception; //��ȡ�˹�¼��İ�Դ����---��־��
	public List<Tongji> countCourtUserOne() throws Exception; //��ȡ�˹�¼���һ����¼����---��־��
	public List<Tongji> countCourtUserTow() throws Exception; //��ȡ�˹�¼��ڶ�����¼����---��־��
	public List<Tongji> countCourtUserThree() throws Exception; //��ȡ�˹�¼���������¼����---��־��
	public List<Tongji> countCourtUserFour() throws Exception; //��ȡ�˹�¼����Ĳ���¼����---��־��
	public List<Tongji> countCourtUserOneByTime(String sdate, String edate) throws Exception; //��ȡʱ����ڵ��˹�¼���һ����¼����---��־��
	public List<Tongji> countCourtUserTowByTime(String sdate, String edate) throws Exception; //��ȡʱ����ڵ��˹�¼���һ����¼����---��־��
	public List<Tongji> countCourtUserThreeByTime(String sdate, String edate) throws Exception; //��ȡʱ����ڵ��˹�¼���һ����¼����---��־��
	public List<Tongji> countCourtUserFourByTime(String sdate, String edate) throws Exception; //��ȡʱ����ڵ��˹�¼���һ����¼����---��־��
	long countExeBussess() throws Exception;//��ȡ��ִ������ҵ��Ϣ����---��־��
	long countApp() throws Exception;//��ȡ����ִ������ҵ��Ϣ����---��־��
	long countAppNet() throws Exception;//��ȡ����ִ������ҵ������Ϣ����---��־��
	long countAppOnselt() throws Exception;//��ȡ����ִ������ҵ������Ϣ����---��־��
	long countMail() throws Exception;//��ȡ��ϵ��������Ϣ����---��־��
	long countTel() throws Exception;//��ȡ��ϵ�˵绰��Ϣ����---��־��
	long countFax() throws Exception;//��ȡ��ϵ�˴�����Ϣ����---��־��
	long countEx() throws Exception;//��ȡ��ϵ�˿����Ϣ����---��־��
	long countSee() throws Exception;//��ȡ��ϵ�˰ݷ���Ϣ����---��־��
	long countSign() throws Exception;//��ȡ��ϵ��ǩԼ��Ϣ����---��־��

 
}
