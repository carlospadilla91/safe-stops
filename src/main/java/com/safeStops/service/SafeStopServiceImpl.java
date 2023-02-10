package com.safeStops.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.safeStops.model.SafeStop;

@Service("safeStopService")
public class SafeStopServiceImpl implements SafeStopService {
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<SafeStop> safeStops;
	
	static {
		safeStops = populateDummySafeStops();
	}
	
	public List<SafeStop> findAllSafeStops() {
		return safeStops;
	}
	
	public SafeStop findById(long id) {
		for(SafeStop safeStop: safeStops) {
			if(safeStop.getId() == id) return safeStop;
		}
		return null;
	}
	
	public SafeStop findByName(String name) {
		for(SafeStop safeStop : safeStops) {
			if(safeStop.getName().equalsIgnoreCase(name)) return safeStop;
		}
		return null;
	}
	
	public void saveSafeStop(SafeStop safeStop) {
		safeStop.setId(counter.incrementAndGet());
		safeStops.add(safeStop);
	}
	
	public void updateSafeStop(SafeStop safeStop) {
		safeStops.set(safeStops.indexOf(safeStop), safeStop);
	}

	public boolean isSafeStopExist(SafeStop safeStop) {
		return findByName(safeStop.getName()) != null;
	}
	
	private static List<SafeStop> populateDummySafeStops(){
        List<SafeStop> safeStops = new ArrayList<SafeStop>();
//        safeStops.add(new SafeStop(counter.incrementAndGet(),"Buc-ees", "BEST OUT THERE!", 5L));
//        safeStops.add(new SafeStop(counter.incrementAndGet(),"7-eleven", "Nice and lit at night", 4L));
        return safeStops;
    }

}
