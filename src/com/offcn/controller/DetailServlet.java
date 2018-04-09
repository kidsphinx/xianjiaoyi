package com.offcn.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
@WebServlet(urlPatterns="/DetailServlet")
public class DetailServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;Charset=utf-8");
	String id = request.getParameter("id");
	String sql = "SELECT * FROM u_idle_info WHERE id='"+id+"'";
	Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
	request.setAttribute("map",map);
	request.getRequestDispatcher("from/xiangqing.jsp").forward(request, response);
	
}
}
