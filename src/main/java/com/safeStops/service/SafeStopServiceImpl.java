package com.safeStops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeStops.dao.SafeStopDAO;
import com.safeStops.model.SafeStop;

@Service("safeStopService")
public class SafeStopServiceImpl implements SafeStopService {
	
	@Autowired private SafeStopDAO safeStopsDAO;
	
	@Override
	@Transactional
	public List<SafeStop> findAllSafeStops() {
		System.out.println("Session status: service ");
		return safeStopsDAO.findAllSafeStops();
	}
	
	@Override
	@Transactional
	public SafeStop findById(Long id) {
		return safeStopsDAO.findById(id);
	}
	
	@Override
	@Transactional
	public SafeStop findByName(String name) {
		return safeStopsDAO.findByName(name);
	}
	
	@Override
	@Transactional
	public void saveSafeStop(SafeStop safeStop) {
		safeStopsDAO.saveSafeStop(safeStop);
	}
	
	@Override
	@Transactional
	public void updateSafeStop(SafeStop safeStop) {
		safeStopsDAO.updateSafeStop(safeStop);
	}

	@Override
	public void deleteSafeStop(Long id) {
		safeStopsDAO.deleteSafeStop(id);
		
	}

}
