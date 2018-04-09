package com.offcn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.IdleService;
@WebServlet(urlPatterns="/MoHuSelect")
public class MoHuSelect extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IdleService idleservice=new IdleService();
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	List<Map<String,Object>> list=idleservice.MoHuSelect(request, response);
	request.setAttribute("map",list);
	request.getRequestDispatcher("module_kehu/table.jsp").forward(request, response);
}
}
