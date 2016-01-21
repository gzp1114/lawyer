package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Tongji;
import com.lawyer.pojo.Users;

public interface CourtCountService {
	public int countCourtByTime(String sdate, String edate) throws Exception; //��ȡʱ����ڵİ�Դ����---��־��
	public long countCourt() throws Exception; //��ȡ�˹�¼��İ�Դ����---��־��
	public List<Tongji> countCourtUserOne() throws Exception; //��ȡ�˹�¼���һ����¼����---��־��
	public List<Tongji> countCourtUserTow() throws Exception; //��ȡ�˹�¼��ڶ�����¼����---��־��
	public List<Tongji> countCourtUserThree() throws Exception; //��ȡ�˹�¼���������¼����---��־��
	public List<Tongji> countCourtUserFour() throws Exception; //��ȡ�˹�¼����Ĳ���¼����---��־��
	public List<Tongji> countCourtUserOneByTime(String sdate, String edate) throws Exception; //��ȡʱ������˹�¼���һ����¼����---��־��
	public List<Tongji> countCourtUserTowByTime(String sdate, String edate) throws Exception; //��ȡʱ������˹�¼��ڶ�����¼����---��־��
	public List<Tongji> countCourtUserThreeByTime(String sdate, String edate) throws Exception; //��ȡʱ������˹�¼���������¼����---��־��
	public List<Tongji> countCourtUserFourByTime(String sdate, String edate) throws Exception; //��ȡʱ������˹�¼����Ĳ���¼����---��־��

}
