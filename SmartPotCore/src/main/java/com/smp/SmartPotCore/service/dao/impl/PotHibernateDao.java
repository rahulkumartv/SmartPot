package com.smp.SmartPotCore.service.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.apache.log4j.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.smp.SmartPotCore.datamodel.PotDetails;
import com.smp.SmartPotCore.datamodel.SmartUser;
import com.smp.SmartPotCore.datamodel.plantDetails;
import com.smp.SmartPotCore.logger.LogManager;
import com.smp.SmartPotCore.service.dao.PotDAO;

public class PotHibernateDao implements PotDAO{

	
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
	public List<PotDetails> GetPotListForUser(SmartUser userObj) {
		List<PotDetails> potList=null;
		try
		{
				final Session session = factory.openSession();
				final Transaction trans = session.beginTransaction();
				Query query = session.createQuery("from PotDetails where user_id = :user_id ");
				query.setParameter("user_id",userObj.getUserid());
				potList = query.list();
				trans.commit();
				session.close();
		}
		catch(Exception exp)
		{
			LogManager.log(exp.getMessage(), this.getClass(),Level.ERROR);
		}
		return potList;
	}
	@Override
	public List<plantDetails> GetPlantDetailsForPot(PotDetails potObj) {
		List<plantDetails> plantList=null;
		try
		{
				final Session session = factory.openSession();
				final Transaction trans = session.beginTransaction();
				plantList = session.createSQLQuery("select {p.*} from plant p"+
				" join plant_class pc on p.plant_id=pc.plant_id"+
						" where pc.pot_id=:pot_id")
						.addEntity("p",plantDetails.class)
						.setParameter("pot_id", potObj.getPotid()).list();
				trans.commit();
				session.close();
		}
		catch(Exception exp)
		{
			LogManager.log(exp.getMessage(), this.getClass(),Level.ERROR);
		}
		return plantList;
	}

}
