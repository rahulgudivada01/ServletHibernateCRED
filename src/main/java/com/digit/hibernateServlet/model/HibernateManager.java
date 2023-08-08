package com.digit.hibernateServlet.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import com.digit.hibernateServlet.bean.AadharDetails;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateManager {

	private Session session;

	public HibernateManager() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		session = sessionFactory.openSession();
		System.out.println("Connected to pf....");
	}

	public boolean saveObj(AadharDetails a) {
		Transaction trans = session.beginTransaction();
		session.save(a);
		trans.commit();
		System.out.println("Object Saved");
		return true;
	}

	public AadharDetails readSpecific(String newaadhar) {
		// session.beginTransaction();
		// Student s=(Student) session.get(Student.class, roll);
		// System.out.println(s.getName()+" "+s.getRoll());
//		select* from student where name='joy';
		session.beginTransaction();
//		Query query=session.createQuery("from Aadhar where aadhar_id=:aadhar_id");
//		query.setParameter("aadhar_id",newaadhar);
//		List list=query.list();

		AadharDetails ad = (AadharDetails) session.get(AadharDetails.class, newaadhar);
		return ad;

//		Iterator itr=list.iterator();
//		while(itr.hasNext()==true)
//		{
//			AadharDetails a=(AadharDetails)itr.next();
//			session.setAttribute("aadhar_id", a.getAadhar_id());
//			session.setAttribute("name",a.getName());
//			System.out.println("Roll: "+s.getRoll());
//			System.out.println("Name: "+s.getName());
//			System.out.println("--------------------");
//		}

	}
	public boolean delete(String aadhar_id,String email)
	{
		Transaction transaction=session.beginTransaction();
		AadharDetails s=(AadharDetails)session.get(AadharDetails.class,aadhar_id);
		s.setEmail(email);
		session.delete(s);
		System.out.println("Success");
		transaction.commit();
		return true;
	}
	
	public boolean update(String aadhar_id,long number)
	{
		Transaction transaction=session.beginTransaction();
		AadharDetails s=(AadharDetails)session.get(AadharDetails.class,aadhar_id);
		s.setNumber(number);
		session.update(s);
		System.out.println("Update Success");
		transaction.commit();
		return true;
	}

	
	public boolean update(String aadhar_id,String email)
	{
		Transaction transaction=session.beginTransaction();
		AadharDetails s=(AadharDetails)session.get(AadharDetails.class,aadhar_id);
		s.setEmail(email);
		session.update(s);
		System.out.println("Update Success");
		transaction.commit();
		return true;
	}
}
