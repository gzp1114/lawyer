package com.lawyer.tools;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg_webchinese {

public static void main(String[] args)throws Exception
{

HttpClient client = new HttpClient();
PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");//��ͷ�ļ�������ת��
NameValuePair[] data ={ new NameValuePair("Uid", "gzp1114"),new NameValuePair("Key", "eb990d33d62d6804936c"),new NameValuePair("smsMob","13691550522"),new NameValuePair("smsText","û�£��Ҳ��Է��Ͷ��ŵĶ���")};
post.setRequestBody(data);

client.executeMethod(post);
Header[] headers = post.getResponseHeaders();
int statusCode = post.getStatusCode();
System.out.println("statusCode:"+statusCode);
for(Header h : headers)
{
System.out.println(h.toString());
}
String result = new String(post.getResponseBodyAsString().getBytes("utf8")); 
System.out.println(result); //��ӡ������Ϣ״̬


post.releaseConnection();

}

}