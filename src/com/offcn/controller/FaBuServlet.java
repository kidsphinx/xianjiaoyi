package com.offcn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.IdleService;
@WebServlet(urlPatterns="/FaBuServlet")
@MultipartConfig
public class FaBuServlet extends HttpServlet {
	IdleService idleService=new IdleService();
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int n = idleService.addIdle(request,response);
	if(n>0){
		System.out.println("��ӳɹ�");
		request.getRequestDispatcher("from/publish_success.jsp").forward(request, response);
	}else{
		System.out.println("���ʧ��");
	}
}
}
