package com.offcn;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
@WebServlet(urlPatterns="/xiugaipsw")
public class xiugaipsw extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pwd=request.getParameter("pwd");
	Map<String,Object> map=(Map<String, Object>) request.getSession().getAttribute("map_front");
	String u_id=map.get("u_id")+"";
	String sql="update u_idle_user set u_password='"+pwd+"' WHERE u_id = '"+u_id+"'";
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
