package com.lawyer.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
/**
 * ע��mysql��   ���ݿ���뼯     ��ı��뼯   �ֶεı��뼯
 * @author Administrator
 *
 */
public class MySQL {
	public MySQL() {
	}
	//�������ݿ�
	public static void backup() throws IOException {
		try {
			Runtime rt = Runtime.getRuntime();
			// ����mysql��cmd ���õ�������Ϊ utf8 ���������utf8
			Process child = rt
					.exec("mysqldump -uroot -proot lawyer --set-charset=utf8");
			// �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱�ע�ļ���
			// ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶��� �޷�����
			InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������
			// ���������������Ϊutf8
			InputStreamReader xx = new InputStreamReader(in, "utf8");
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			// ��Ͽ���̨�����Ϣ�ַ���
			BufferedReader br = new BufferedReader(xx);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			System.out.println(outStr + " ==");
			// Ҫ�����������õ�sqlĿ���ļ�
			FileOutputStream fout = new FileOutputStream("d:/test.sql");
			//��Ҫ�ı��뼯  ����д
			OutputStreamWriter writer = new OutputStreamWriter(fout,"utf8");
			writer.write(outStr);
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();
			// �����ǹر����������
			in.close();
			xx.close();
			br.close();
			writer.close();
			fout.close();
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ԭ���ݿ�
	public static  void load() {
		try {
			String fPath = "d:/test.sql";
			Runtime rt = Runtime.getRuntime();
			// ���� mysql �� cmd:
			Process child = rt.exec("mysql -uroot -proot lawyer");
			OutputStream out = child.getOutputStream();
			// ����̨��������Ϣ��Ϊ�����
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath), "utf8"));
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
			writer.write(outStr);
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();
			// �����ǹر����������
			out.close();
			br.close();
			writer.close();
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
//		 MySQL.backup();
//		 my.load();

	}
}
