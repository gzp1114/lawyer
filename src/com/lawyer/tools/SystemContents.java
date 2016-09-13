package com.lawyer.tools;

import java.util.List;
import java.util.Map;

import com.lawyer.utils.taglib.JspTagUtil;

public class SystemContents {
	
	public enum SYS_DISPOSE_RESULT_TYPE{
		DISPOSE_RESULT_A("A", "����̸��ǩԼ����"), 
		DISPOSE_RESULT_B("B", "�����һ��������ϵ"), 
		DISPOSE_RESULT_C("C", "����̸��δǩԼ"), 
		DISPOSE_RESULT_D("D", "������Űݷ�"),
		DISPOSE_RESULT_E("E", ""),
		DISPOSE_RESULT_F("F", ""),
		DISPOSE_RESULT_G("G", ""),
		DISPOSE_RESULT_H("H", "ծȨ�˱�ʾ���Ҳ��ƻ�Ҫ�˱�ծȨ��"),
		DISPOSE_RESULT_I("I", "�����Ҳ���������ծȨ��"),
		DISPOSE_RESULT_J("J", "�ѽ�ͬһծ������������"),
		DISPOSE_RESULT_K("K", "ծ���ˣ���ע���������꣩"),
		DISPOSE_RESULT_L("L", "ծ���ˣ��ѽ����Ʋ�����"),
		DISPOSE_RESULT_M("M", "ծȨ��(��ִ�����)"),
		DISPOSE_RESULT_N("N", "ծȨ�ˣ�������ʧ����������ʾ��ִ�кܶ�ծ��"),
		DISPOSE_RESULT_O("O", "ծȨ�ˣ��ѽ������������ע�����ѵ�����"),
		DISPOSE_RESULT_P("P", "ծȨ��Ϊ�����������У���������ί�ᣩ"),
		DISPOSE_RESULT_Q("Q", "ծȨ�˹ɶ���ծ���˹ɶ����غϡ�ծȨ����ծ���˵Ĺɶ�"),
		DISPOSE_RESULT_R("R", "ծȨ�ˣ�û�е�ַ����ϵ�绰�ĸ��˵ȣ�"),
		DISPOSE_RESULT_S("S", "��ǩԼ"),
		DISPOSE_RESULT_T("T", ""),
		DISPOSE_RESULT_U("U", ""),
		DISPOSE_RESULT_V("V", ""),
		DISPOSE_RESULT_W("W", ""),
		DISPOSE_RESULT_X("X", ""),
		DISPOSE_RESULT_Y("Y", ""),
		DISPOSE_RESULT_Z("Z", "") ;
		
		private String value;
		private String desc;

		SYS_DISPOSE_RESULT_TYPE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public String value() {
			return this.value;
		}

		public String desc() {
			return this.desc;
		}
	}
	
	/**
	 * ȡ�ֵ�������
	 * �û�״̬->����
	 * @param value
	 * @return
	 */
	public static String getsysUserSessionType(int value) {

		for (SYS_DISPOSE_RESULT_TYPE dic : SYS_DISPOSE_RESULT_TYPE.values()) {
			if (dic.value().equals(value)){
				return dic.desc();
			}
		}
		return "";

	}

	/**
	 * �������ͼ��ֵ��б�
	 */
	public static List<Map<String,String>> getSelectDic(String type){
		return JspTagUtil.getSelectTag(new SystemContents().getClass().getName()+"$"+type);
	}
	
	public static String getDicDesc(String type, String value) {
		return JspTagUtil.getDicDesc(new SystemContents().getClass().getName()+"$"+type, value);
	}
}
