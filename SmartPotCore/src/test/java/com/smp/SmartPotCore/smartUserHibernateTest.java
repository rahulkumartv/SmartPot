package com.smp.SmartPotCore;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import com.smp.SmartPotCore.datamodel.SmartUser;
import com.smp.SmartPotCore.service.dao.SmartUserDAO;
import com.smp.SmartPotCore.service.dao.impl.SmartUserHibernateDao;

//This is to tell Junit to run with spring
@RunWith(SpringJUnit4ClassRunner.class) 
//to tell spring to load the required context
@ContextConfiguration(locations={"file:src/test/resources/application-context.xml"})
public class smartUserHibernateTest {
	@Autowired
	@Qualifier("SmartUserHibernateDao")
	private SmartUserDAO dao;
	
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
	public void sessionFactoryUsage() throws Exception{
		final Session session = sessionFactory.openSession();
		final Transaction transt = session.beginTransaction();
		SmartUser smrtUserObj=new SmartUser();
		smrtUserObj.setAddress("paris");
		smrtUserObj.setFirstName("hann");
		smrtUserObj.setLastName("aj");
		smrtUserObj.setMobile("002188");
		smrtUserObj.setPassword("bbbb");
		smrtUserObj.setUserName("jesus");
		smrtUserObj.setZipCode("0658789");
		session.saveOrUpdate(smrtUserObj);
		transt.commit();
	}
	
	/**
	 * Test Hibernate DAo Write
	 * @return void 
	 * @throws Exception 
	 */
	@Test
	public void hibernateDaoWrite() throws Exception{
		SmartUser smrtUserObj=new SmartUser();
		smrtUserObj.setAddress("Immanuel Mansion");
		smrtUserObj.setFirstName("Jeeva");
		smrtUserObj.setLastName("Durairaj");
		smrtUserObj.setMobile("065498744");
		smrtUserObj.setPassword("Kitee");
		smrtUserObj.setUserName("Alice");
		smrtUserObj.setZipCode("96564");
		dao.addSmartUser(smrtUserObj);
		
	}
	@Test
	public void displaySmartUserDetails() throws IllegalArgumentException, IllegalAccessException{
		SmartUser smrtUserObj = new SmartUser();
		SmartUser searchResul = new SmartUser();
		smrtUserObj.setUserid(3);
		searchResul =dao.GetSmartUser(smrtUserObj);
		System.out.println(searchResul);
		Assert.notNull(searchResul);
	}
}
