package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;
@WebServlet("/Register")
public class Register extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		AadharDetails a=new AadharDetails();
		a.setAadhar_id(req.getParameter("aadhar_id"));
		a.setName(req.getParameter("name"));
		a.setEmail(req.getParameter("email"));
		a.setNumber(Long.parseLong(req.getParameter("number")));
		a.setAddress(req.getParameter("address"));
		a.setCity(req.getParameter("city"));
		a.setState(req.getParameter("state"));
		a.setPincode(Integer.parseInt(req.getParameter("pincode")));
		HibernateManager hbm=new HibernateManager();
		if(hbm.saveObj(a)==true)
		{
			resp.sendRedirect("RegisterSuccess.html");
		}
		else
		{
			resp.sendRedirect("RegisterFail.html");
		}
	}

}
