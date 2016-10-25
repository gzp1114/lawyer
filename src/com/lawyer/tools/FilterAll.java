
package com.lawyer.tools;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FilterAll implements javax.servlet.Filter {

	private FilterConfig filterConfig;
	private String loginPage;

	public void destroy() {
		filterConfig = null;
		System.gc();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		if (((session.getAttribute("admin") != null || (req.getRequestURI().endsWith("login.jsp"))))//������ԴURL��Login.jsp   Login_Action��β��������
				|| (session.getAttribute("admin") != null || (req.getRequestURI().endsWith("usersLogin")))
				|| (session.getAttribute("admin") != null || (req.getRequestURI().endsWith(".jpg") || req.getRequestURI().endsWith(".gif")))
				|| (session.getAttribute("admin") != null || req.getRequestURI().endsWith("usersQuit"))
				||(session.getAttribute("admin") != null || req.getRequestURI().endsWith(".css"))
				||(session.getAttribute("admin") != null || req.getRequestURI().endsWith("Temp.jsp"))
		) {
			chain.doFilter(request, response);
			return;
		} else if (session.getAttribute("admin") == null) {    //'user'Ϊ��¼ʱ�󱣴��session������
			System.out.println("����������...");
			ServletContext ctx = filterConfig.getServletContext();
			setForwordURI(req);
			ctx.getRequestDispatcher(loginPage).forward(req, res); 

		}
	}

	public void init(FilterConfig config) throws ServletException {
		filterConfig = config;
		if (filterConfig.getInitParameter("loginPage") != null)
			loginPage = filterConfig.getInitParameter("loginPage");//'loginPa.xml�����õĲ��� �ò���ΪҪ��ת����ҳ��
	}

	private void setForwordURI(HttpServletRequest request) {
		StringBuffer requestURI = new StringBuffer(request.getRequestURI());
		String queryString = request.getQueryString();
		if (queryString != null) {
			requestURI.append("?").append(queryString);
		}
		request.setAttribute("orignURL", requestURI.toString());
	}

}

