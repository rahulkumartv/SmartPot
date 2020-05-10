package com.smp.SmartPotCore.service.dao.impl;

import org.apache.log4j.Level;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.smp.SmartPotCore.datamodel.SmartUser;
import com.smp.SmartPotCore.service.dao.SmartUserDAO;
import com.smp.SmartPotCore.logger.LogManager;

public class SmartUserHibernateDao implements SmartUserDAO{
	
	@Autowired
	@Qualifier("beanBasedSessionFactory")
	private SessionFactory factory;
	/**
	 * @return the hibernate session factory object configured for the user
	 */
	public SessionFactory getFactory() {
		return factory;
	}

	/**
	 * set hibernate session factory object for user 
	 * @param factory -SessionFactory
	 */
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void addSmartUser(SmartUser user) {
		try
		{
			final Session session = factory.openSession();
			final Transaction trans = session.beginTransaction();
			session.saveOrUpdate(user);
			trans.commit();
			session.close();
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
		
	}

	public boolean verifyUserAuthentication(SmartUser userObj) {
		// TODO Auto-generated method stub
		return false;
	}

	public void updateSmartUser(SmartUser userObj) {
		// TODO Auto-generated method stub
		
	}

	public void deleteSmartUser(SmartUser userObj) {
		// TODO Auto-generated method stub
		
	}
	public SmartUser GetSmartUser(SmartUser userObj) {
		SmartUser smrtUserDetailsObj=new SmartUser();
		try
		{
				final Session session = factory.openSession();
				final Transaction trans = session.beginTransaction();
				smrtUserDetailsObj = (SmartUser) session.createCriteria(SmartUser.class).add(Restrictions.eq("userid",userObj.getUserid())).uniqueResult();
				trans.commit();
				session.close();
		}
		catch(Exception exp)
		{
			LogManager.log(exp.getMessage(), this.getClass(),Level.ERROR);
		}
		return smrtUserDetailsObj;
	}

}
