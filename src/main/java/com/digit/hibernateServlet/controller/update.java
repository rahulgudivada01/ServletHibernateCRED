package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;
@WebServlet("/update")
public class update extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		String aadhar_id = req.getParameter("aadhar_id");
		String email=req.getParameter("email");
		AadharDetails ad = new AadharDetails();
		HibernateManager hbm = new HibernateManager();
		boolean b=hbm.update(aadhar_id,email);
		if(b==true)
		{
			resp.sendRedirect("UpdateSuccessful.html");
		}
		else
		{
			resp.sendRedirect("UpdateFailed.html");
			
		}
		
	}
	

}
