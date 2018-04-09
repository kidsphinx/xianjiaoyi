package com.offcn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
import com.offcn.service.gerenService;
@WebServlet(urlPatterns="/Frongeren")
public class Frongeren extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
gerenService gr=new gerenService();
@Override

protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	int n=gr.Frongeren(request, response);
	if(n>0)
	{
		String u_account = request.getParameter("u_account");
		String sql = "Select * from u_idle_user where u_account='"+u_account+"'";
		Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
		request.getSession().setAttribute("map_front", map);
		request.getRequestDispatcher("from/register.jsp").forward(request, response);
		
	}
	else
	{
		System.out.println("ÐÞ¸ÄÊ§°Ü");
	}
}
}
