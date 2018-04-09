package com.offcn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.IdleService;
@WebServlet(urlPatterns="/SwitchServlet")
public class SwitchServlet extends HttpServlet {
	IdleService idleservice=new IdleService();
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int n=idleservice.SwitchServlet(request, response);
	if(n>0)
	{
		request.getRequestDispatcher("SelectYongHu").forward(request, response);
		
	}
	else{}
}
}
