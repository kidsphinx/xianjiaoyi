package com.offcn;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
@WebServlet(urlPatterns="/UpdatePwd")
public class UpdatePwd extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pwd=request.getParameter("pwd");
	Map<String,Object> map=(Map<String, Object>) request.getSession().getAttribute("map");
	String id=map.get("id")+"";
	String sql="update u_sys_admin set password='"+pwd+"' WHERE id = '"+id+"'";
	int n = new BaseDao().executeUpdate(sql);
	if(n>0)
	{
		response.getWriter().write("ok");
	}
	else
	{
		response.getWriter().write("error");
	}
	
}
}
