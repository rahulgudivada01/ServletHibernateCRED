package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;

@WebServlet("/viewSpecific")

public class viewSpecific extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aadhar_id = req.getParameter("aadhar_id");
		AadharDetails ad = new AadharDetails();
		HibernateManager hbm = new HibernateManager();
		
		AadharDetails curAd = hbm.readSpecific(aadhar_id);
		if (curAd == null) {
			// empty - no user
			resp.sendRedirect("ViewDetailsFail.html");
			return;
		}
		// user exists
		HttpSession session = req.getSession();
		session.setAttribute("curUser", curAd);
		resp.sendRedirect("ViewEnrollerDetails.jsp");
		return;
		
//		boolean isUserExists = hbm.readSpecific(aadhar_id);
//		if (isUserExists) {
//			HttpSession session = req.getSession();
//			session.setAttribute("curUser", ad);
//			resp.sendRedirect("ViewEnrollerDetails.jsp");
//			return;
//		} else {
//			resp.sendRedirect("ViewDetailsFail.html");
//			return;
//		}

	}

}
