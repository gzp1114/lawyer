package com.lawyer.tools;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class ObjAndList2Json {
	/**
	 * ���÷������  ���������  ��װ �� json����
	 * UserInfo u = new UserInfo("1001","zhangsan");
	 * {'user_id':'1001','user_name':'zhangsan'}
	 */
	public static String obj2json(Object obj){
		StringBuffer sbf = new StringBuffer("");
		sbf.append("{");
		//1.ȡ��obj��Ӧ��Class����
		Class<?> clz = obj.getClass();
		//2.ȡ�����з���
		Method[] methods = clz.getMethods();
		
		int i = 0;//ƴ��json�ַ����еġ�,���õı�ʶ
		for (Method method : methods) {//�������з���
			//ȡ�����е�public ���εķ���
			if(method.getModifiers() == Modifier.PUBLIC){
				//ȡ��get����
				if(method.getName().substring(0,3).equals("get")){
					//ƴ��json�ַ���
					if(i!=0){
						sbf.append(",");
					}
					
					sbf.append("'");
					//ȥ��get����תСд  �õ��ֶ���
					sbf.append(method.getName().substring(3).toLowerCase());
					sbf.append("'");
					sbf.append(":");
					sbf.append("'");
					try {
						//�������get����  ��ø��ֶε�ֵ
						sbf.append(method.invoke(obj));
					} catch (Exception e) {
						e.printStackTrace();
					} 
					sbf.append("'");
					i++;
				}
			}
		}
		String rs = sbf.append("}").toString();
		return rs;
	}
	
	/**
	 * ���÷������  ������List���� ��װ �� json����
	 * UserInfo u = new UserInfo("1001","zhangsan");
	 * [{},{},{}]
	 */
	public static String list2jsonarr(List<?> list){
		StringBuffer sbf = new StringBuffer("");
		sbf.append("[");
		int i = 0;
		for(Object obj : list){
			if(i != 0){
				sbf.append(",");
			}
			sbf.append(obj2json(obj));
			i++;
		}
		return sbf.append("]").toString();
	}
}
