package com.offcn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
@WebServlet(urlPatterns="/FinalReg")
public class FinalReg extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("pwd");
		String phone = request.getSession().getAttribute("phone")+"";
	
		String sql = "INSERT INTO u_idle_user(u_phonenum,u_password) VALUES ('"+phone+"','"+password+"')";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			//ע��ɹ�����ת��ת����¼ҳ��
			request.getRequestDispatcher("from/login.jsp").forward(request, response);
		}
	}

}
