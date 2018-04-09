package com.offcn.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.LoginService;

@WebServlet(urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	LoginService loginService = new LoginService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ǰ��¼�û�
		Map<String, Object> map = loginService.login(request, response);
		if(map!=null){
			//��map�����ݴ���session������
			request.getSession().setAttribute("map",map);
			//��¼�ɹ�,����ϵͳ��ҳ
			request.getRequestDispatcher("index/index.jsp").forward(request, response);
		}else{
			System.out.println("shibai");
			response.sendRedirect("login.jsp");
		}
		
	}
	
}
