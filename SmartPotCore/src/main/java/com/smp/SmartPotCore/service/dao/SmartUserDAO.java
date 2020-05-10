package com.smp.SmartPotCore.service.dao;

import java.sql.Connection;

import com.smp.SmartPotCore.datamodel.SmartUser;


public interface SmartUserDAO {
	void addSmartUser( SmartUser userObj);
	boolean verifyUserAuthentication(SmartUser userObj);
	void updateSmartUser(SmartUser userObj);
	void deleteSmartUser(SmartUser userObj);
	public SmartUser GetSmartUser(SmartUser userObj);
}
