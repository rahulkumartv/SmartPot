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
import com.smp.SmartPotCore.datamodel.parameterLog;
import com.smp.SmartPotCore.service.dao.impl.parameterHibernateDAO;

//This is to tell Junit to run with spring
@RunWith(SpringJUnit4ClassRunner.class) 
//to tell spring to load the required context
@ContextConfiguration(locations={"file:src/test/resources/application-context.xml"})
public class parameterLogTest {
	
	@Autowired
	@Qualifier("parameterHibernateDAO")
	private parameterHibernateDAO dao;
	
	@Autowired
	@Qualifier("dataSourceBean")
	private DataSource datsource;
	
	@Autowired
    @Qualifier("beanBasedSessionFactory")
	private SessionFactory sessionFactory;
	/**
	 * Test Hibernate DAo Write
	 * @return void 
	 * @throws Exception 
	 */
	@Test
	public void insertParameterLog() throws Exception{
		parameterLog parameterObj=new parameterLog();
		parameterObj.setName("temperature");
		parameterObj.setValue("45.12");
		java.util.Date dt = new java.util.Date();
		parameterObj.setLogged_at(new java.sql.Timestamp(dt.getTime()));
		dao.insertParameterLog(parameterObj);
	}
	@Test
	public void parameterLoggingDetails() throws IllegalArgumentException, IllegalAccessException{
		PotDetails potObj = new PotDetails();
		List<parameterLog> parameterLogger =null;
		potObj.setPotid(1);
		parameterLogger =dao.getParameterLog(potObj);
		System.out.println(parameterLogger);
		Assert.notNull(parameterLogger);
	}
}
