package com.offcn.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/CheckOriPwd")
public class CheckOriPwd extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	
	String oripwd =request.getParameter("oripwd");
	
	Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("map");
	String password=map.get("password")+"";
	String msg="";
	if (oripwd.equals(password)) {
		msg = "ok";
		
	} else {
		msg = "errors";
	}
	response.getWriter().write(msg);
}
}
