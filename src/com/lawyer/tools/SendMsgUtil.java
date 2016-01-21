package com.lawyer.tools;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsgUtil {
	
	private static String smsuid = "wy1992";
	private static String smskey = "d4bbfebf3a223f182a5b";

	public static String send(String mobile,String name,String content,String remindTime){
		String smsText = name+"��ã�"+remindTime+content;
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=gbk");// ��ͷ�ļ�������ת��
		NameValuePair[] data = { new NameValuePair("Uid", smsuid),
				new NameValuePair("Key", smskey),
				new NameValuePair("smsMob", mobile),
				new NameValuePair("smsText", smsText)};
		post.setRequestBody(data);

		String result = null;
		try {
			client.executeMethod(post);
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:" + statusCode);
			for (Header h : headers) {
				System.out.println(h.toString());
			}
			result = new String(post.getResponseBodyAsString().getBytes(
					"gbk"));
			System.out.println("���ŷ���״̬��"+result); // ��ӡ������Ϣ״̬
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			post.releaseConnection();
		}
		
		return result;
		
	}
	
//	public static void main(String[] args) throws Exception {
//
//		HttpClient client = new HttpClient();
//		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
//		post.addRequestHeader("Content-Type",
//				"application/x-www-form-urlencoded;charset=utf8");// ��ͷ�ļ�������ת��
//		NameValuePair[] data = { new NameValuePair("Uid", "gzp1114"),
//				new NameValuePair("Key", "eb990d33d62d6804936c"),
//				new NameValuePair("smsMob", "13383712552"),
//				new NameValuePair("smsText", "û�£��Ҳ��Է��Ͷ��ŵĶ���") };
//		post.setRequestBody(data);
//
//		client.executeMethod(post);
//		Header[] headers = post.getResponseHeaders();
//		int statusCode = post.getStatusCode();
//		System.out.println("statusCode:" + statusCode);
//		for (Header h : headers) {
//			System.out.println(h.toString());
//		}
//		String result = new String(post.getResponseBodyAsString().getBytes(
//				"utf8"));
//		System.out.println(result); // ��ӡ������Ϣ״̬
//
//		post.releaseConnection();
//
//	}

}