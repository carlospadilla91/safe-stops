package com.safeStops.service;

import java.util.List;


import com.safeStops.model.SafeStop;

public interface SafeStopService {
	
	SafeStop findById(long id);
	
	SafeStop findByName(String name);
	
	void saveSafeStop(SafeStop safeStop);
	
	void updateSafeStop(SafeStop safeStop);
	
	List<SafeStop> findAllSafeStops();
	
	public boolean isSafeStopExist(SafeStop safeStop);

}
