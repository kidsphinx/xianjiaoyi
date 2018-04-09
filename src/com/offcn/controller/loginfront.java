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
@WebServlet(urlPatterns="/loginfront")
public class loginfront extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String account = request.getParameter("account");
	String password = request.getParameter("password");
	String sql = "SELECT * FROM u_idle_user WHERE u_account='"+account+"' AND u_password='"+password+"'";
	List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
	if(list.size()>0&&list!=null)
	{
		Map<String,Object> map =list.get(0);
		request.getSession().setAttribute("map_front", map);
		request.getRequestDispatcher("from/index.jsp").forward(request,response);
		
	}
	else{
		response.sendRedirect("from/login.jsp");
	}
}
}
