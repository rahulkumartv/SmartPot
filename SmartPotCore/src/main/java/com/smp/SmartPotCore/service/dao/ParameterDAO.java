package com.smp.SmartPotCore.service.dao;

import java.util.List;

import com.smp.SmartPotCore.datamodel.PotDetails;
import com.smp.SmartPotCore.datamodel.parameterLog;

public interface ParameterDAO {
	void insertParameterLog( parameterLog parameterObj);
	public List<parameterLog> getParameterLog(PotDetails potObj);
}
