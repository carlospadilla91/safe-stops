package com.safeStops.service;

import java.util.List;


import com.safeStops.model.SafeStop;

public interface SafeStopService {
	
	SafeStop findById(Long id);
	
	SafeStop findByName(String name);
	
	void saveSafeStop(SafeStop safeStop);
	
	void updateSafeStop(SafeStop safeStop);
	
	void deleteSafeStop(Long id);
	
	List<SafeStop> findAllSafeStops();

}
