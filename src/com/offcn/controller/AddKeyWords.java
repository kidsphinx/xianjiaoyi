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

import net.sf.json.JSONArray;

@WebServlet(urlPatterns="/AddKeyWords")
public class AddKeyWords extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String keywords = request.getParameter("keywords");
	
		String sql = "INSERT INTO u_keywords(keywords,createtime) VALUES('"+keywords+"',NOW())";
		
		int n = new BaseDao().executeUpdate(sql);
		
		if(n>0){
			String sql_query = "SELECT * FROM u_keywords";
			List<Map<String, Object>> list = new BaseDao().executeQuery(sql_query);
			//��listת����json���ݣ���������jar����
			String str = JSONArray.fromObject(list).toString();
			response.getWriter().write(str);
		}
			
	}

}
