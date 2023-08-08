package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;
@WebServlet("/delete")
public class delete extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		String aadhar_id = req.getParameter("aadhar_id");
		String email=req.getParameter("email");
		AadharDetails ad = new AadharDetails();
		HibernateManager hbm = new HibernateManager();
		boolean b=hbm.delete(aadhar_id,email);
		if(b==true)
		{
			resp.sendRedirect("DeleteSuccessful.html");
		}
		else
		{
			resp.sendRedirect("DeleteFailed.html");
			
		}
	
	}
}
