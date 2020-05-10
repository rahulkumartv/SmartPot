package com.smp.SmartPotCore.service.dao.impl;

import java.util.List;

import org.apache.log4j.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.smp.SmartPotCore.datamodel.PotDetails;
import com.smp.SmartPotCore.datamodel.parameterLog;
import com.smp.SmartPotCore.datamodel.plantDetails;
import com.smp.SmartPotCore.logger.LogManager;
import com.smp.SmartPotCore.service.dao.ParameterDAO;
import com.smp.SmartPotCore.service.dao.SmartUserDAO;

public class parameterHibernateDAO implements  ParameterDAO{

	
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
	@Override
	public void insertParameterLog(parameterLog parameterObj) {
		try
		{
			final Session session = factory.openSession();
			final Transaction trans = session.beginTransaction();
			session.saveOrUpdate(parameterObj);
			trans.commit();
			session.close();
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
	}

	@Override
	public List<parameterLog> getParameterLog(PotDetails potObj) {
		List<parameterLog> parameterList=null;
		try
		{
				final Session session = factory.openSession();
				final Transaction trans = session.beginTransaction();
				parameterList = session.createSQLQuery("select {p.*} from parameter p"+
				" join parameter_bind pb on p.parameter_id=pb.parameter_id"+
						" where pb.pot_id=:pot_id")
						.addEntity("p",parameterLog.class)
						.setParameter("pot_id", potObj.getPotid()).list();
				trans.commit();
				session.close();
		}
		catch(Exception exp)
		{
			LogManager.log(exp.getMessage(), this.getClass(),Level.ERROR);
		}
		return parameterList;
	}

}
