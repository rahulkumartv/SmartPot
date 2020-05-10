package com.smp.SmartPotCore;

import java.util.List;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import com.smp.SmartPotCore.datamodel.PotDetails;
import com.smp.SmartPotCore.datamodel.SmartUser;
import com.smp.SmartPotCore.datamodel.parameterLog;
import com.smp.SmartPotCore.datamodel.plantDetails;
import com.smp.SmartPotCore.service.dao.impl.PotHibernateDao;

//This is to tell Junit to run with spring
@RunWith(SpringJUnit4ClassRunner.class) 
//to tell spring to load the required context
@ContextConfiguration(locations={"file:src/test/resources/application-context.xml"})
public class potDetailsTest {
	@Autowired
	@Qualifier("PotHibernateDao")
	private PotHibernateDao dao;
	
	@Autowired
	@Qualifier("dataSourceBean")
	private DataSource datsource;
	
	@Autowired
    @Qualifier("beanBasedSessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Test Hibernate setup
	 * @return void 
	 * @throws Exception 
	 */
	@Test
	public void displayPotDetails() throws IllegalArgumentException, IllegalAccessException{
		SmartUser smrtUserObj = new SmartUser();
		List<PotDetails> potDetails =null;
		smrtUserObj.setUserid(1);
		potDetails =dao.GetPotListForUser(smrtUserObj);
		System.out.println(potDetails);
		Assert.notNull(potDetails);
	}
	@Test
	public void displayPlantDetails() throws IllegalArgumentException, IllegalAccessException{
		PotDetails potObj = new PotDetails();
		List<plantDetails> plantDetails =null;
		potObj.setPotid(1);
		plantDetails =dao.GetPlantDetailsForPot(potObj);
		System.out.println(plantDetails);
		Assert.notNull(plantDetails);
	}
	
}
