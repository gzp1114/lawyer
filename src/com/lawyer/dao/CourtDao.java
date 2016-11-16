package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.PageBean;
import com.lawyer.pojo.Users;

public interface CourtDao {
	/**
	 * excel���뱻ִ������Ϣ
	 */
	public void excelInsertCourt(List<Court> dataList);
	public Object getCourtByCasecode(Court court) throws Exception;
	
	public List<Court> selectCourtsByName(String pname);
	public List<Court> selectCourtsByNameCasecode(String pname,String caseCode);
	
	/**
	 * �����ݿ������ҵ��������Ҫ������
	 */
	public void createUpdateData(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney);
	
	/**
	 * ��Ժ�������
	 */
	public void courtcodeUpdate(Users users)throws Exception;
	/**
	 * ��ҵ״̬����
	 */
	public void updateStutas(Users users)throws Exception;
	/**
	 * ծ���˹�����Ϣ��������
	 */
	public void insertNoteCourts(Users users)throws Exception;
	/**
	 * ծ����ʧ����Ϣ��������
	 */
	public void insertDishonestyCourts(Users users)throws Exception;
	/**
	 * ������ʱ�ų�
	 */
	public int presentExclude(Court court);
	/**
	 * ���������ų�
	 */
	public int perpetualExclude(Court court);
	/**
	 * ���ݻָ�
	 */
	public int dataRecover(Court court);
	/**
	 * �����ݿ�����ⲿ�������Ҫ������
	 */
	public void createDate(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney);
	/**
	 * �ı�һ����Դ��Ϣִ�в���
	 */
	public void changeOneStep(Court court,String courtStep);
	/**
	 * �ı䰸Դ����ִ�в���
	 */
	public void changeStep(Court court, String startDate, String endDate,String instartDate,String inendDate,String minMoney,String maxMoney,String courtStep);
	/**
	 *��������ҳ��ѯcourt��Ϣ 
	 */
	public List<Court> selectCourts(Court court,Executebusiness exb,int currentPage,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	/**
	 *��������ҳ��ѯ����ҳ�� 
	 */
	public int  selectTatolPage(Court court,Executebusiness exb,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	
	
	/**
	 *��������ҳ��ѯcourt��Ϣ 
	 */
	public List<Court> selectNoteCourts(Court court,int currentPage,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	/**
	 *��������ҳ��ѯ����ҳ�� 
	 */
	public int  selectNoteTatolPage(Court court,String startDate,String endDate,String instartDate,String inendDate,String minMoney,String maxMoney)throws Exception;
	
	
	public void insertCourt(Court court) throws Exception;//�½���Դ��Ϣ�������Ϻ�
	public Apply selectApply(Users users)throws Exception;//����Ȩ�ޣ���ѯ���޶��󡪡����Ϻ�
	public Apply selectCourt3(Apply apply,Users users) throws Exception;//�½���Դ��Ϣ�����ξ�
	@SuppressWarnings("rawtypes")
	public List selectCourtAll(Court court)throws Exception;//��ѯȫ����Դ��Ϣ�����ξ�
	public void updateCourt(Court court)throws Exception;//�޸İ�Դ��Ϣ����ִ����ִ����Ϣ�� �����ξ�
	public int countCourtByCC(String courtcode,String caseCreateTime) throws Exception; //���ݷ�Ժ��ź�ʱ���ȡ��������������־��
	
	public String insertMoreCourts(Users user) throws Exception;//��Դ�����������������־��
	
	
	/** 
     * ��ҳ��ѯ
     * @param hql ��ѯ������
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ������¼
     * @return
     */
	public List queryForPage(final String hql,final int offset,final int length);
    
    /**
     * ��ѯ���м�¼��
     * @param hql ��ѯ������
     * @return �ܼ�¼��
     */
    public int getAllRowCount(String hql);
    
	/**
     * ��ҳ��ѯ
     * @param page ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryForPage(int pageSize,int page);
    
    
    public Apply appSelectById(Apply apply,Users users)throws Exception;  //����   ��Դ����   �鿴��ϸ��Ϣ Ȩ��   --���Ϻ�
    public Court selectCourtById(Court court)throws Exception;    //��id  ��ѯ  ��Դ  ��ϸ��Ϣ   ---���Ϻ�
    
    
    
    public Court selCourtByCasecodeself(String casecodeself)throws Exception;
	public void toupdCourt1(Court court)throws Exception;
	public Executebusiness selExecutebusById(String id)throws Exception;
	public Executebusiness selExecutebusByCasecodeself(String ecCasecodeself)throws Exception;
	public void toupdExecutebus(Executebusiness eb)throws Exception;
	public Applierinfo selApplierinfoByCasecodeself(String appCCasecodeself)throws Exception;
	public void toupdApplierinfo(Applierinfo ap)throws Exception;
	public ApplierinfoNetwork selNetwork(String anCasecodeself)throws Exception;
	public void toupdNetwork(ApplierinfoNetwork an)throws Exception;
	public ApplierinfoOnself updApplierinfoOnself(String aoCasecodeself)throws Exception;
	public void toupdApplierinfoOnself(ApplierinfoOnself ao)throws Exception;
	
	public ContactMail updConMail(String cmCasecodeself)throws Exception;
	public void toupdConMail(ContactMail cm)throws Exception;
	
	public ContactTel updConTel(String ctCasecodeself)throws Exception;
	public void toupdConTel(ContactTel ct)throws Exception;
	
	public ContactExpress updConExpress(String ceCasecodeself)throws Exception;
	public void toupdConExpress(ContactExpress ce)throws Exception;
	
	public ContactFax updConFax(String cfCasecodeself)throws Exception;
	public void toupdConFax(ContactFax cf)throws Exception;
	
	public ContactSee updConSee(String csCasecodeself)throws Exception;
	public void toupdConSee(ContactSee csee)throws Exception;
}
