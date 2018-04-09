package com.offcn.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;

public class gerenService  {


	public int Frongeren(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		String u_account = request.getParameter("u_account");
		String u_nickname = request.getParameter("u_nickname");
		String u_phonenum = request.getParameter("u_phonenum");
		String u_birthday = request.getParameter("u_birthday");
		String u_province = request.getParameter("u_province");
		String u_city = request.getParameter("u_city");
		String u_district = request.getParameter("u_district");
		String sql = "UPDATE u_idle_user SET u_nickname='"+u_nickname+"',u_phonenum='"+u_phonenum+"',u_birthday='"+u_birthday+"',u_province='"+u_province+"',u_city='"+u_city+"',u_district='"+u_district+"' WHERE u_account ='"+u_account+"'";
		int n = new BaseDao().executeUpdate(sql);
		return n;
		
		
	}
	
}
