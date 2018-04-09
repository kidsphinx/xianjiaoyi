package com.offcn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.IdleService;
@WebServlet(urlPatterns="/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IdleService idleservice=new IdleService();
	
	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = idleservice.DeleteSerlet(request, response);
		if(n>0){
			
			request.getRequestDispatcher("Selectidle").forward(request, response);
			
		}
		else{
			System.out.println("É¾³ýÊ§°Ü");
		}
	}
}
