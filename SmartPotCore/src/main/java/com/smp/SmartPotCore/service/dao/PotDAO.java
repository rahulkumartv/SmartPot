package com.smp.SmartPotCore.service.dao;

import java.util.List;
import com.smp.SmartPotCore.datamodel.PotDetails;
import com.smp.SmartPotCore.datamodel.SmartUser;
import com.smp.SmartPotCore.datamodel.plantDetails;

public interface PotDAO {
	public List<PotDetails> GetPotListForUser(SmartUser userObj);
	public List<plantDetails> GetPlantDetailsForPot(PotDetails potObj);
}
