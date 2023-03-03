package com.safeStops.dao;

import java.util.List;

import com.safeStops.model.SafeStop;

public interface SafeStopDAO {
	
	SafeStop findById(Long id);
	
	SafeStop findByName(String name);
	
	void saveSafeStop(SafeStop safeStop);
	
	void updateSafeStop(SafeStop safeStop);
	
	void deleteSafeStop(Long id);
	
	List<SafeStop> findAllSafeStops();

}
