package com.safeStops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.safeStops.model.SafeStop;
import com.safeStops.service.SafeStopService;

@Controller
public class SafeStopController {
	
	@Autowired
	SafeStopService safeStopService;

	
	@RequestMapping(value = "/safeStops/list", method = RequestMethod.GET)
	public ResponseEntity<List<SafeStop>> getSafeStopsList() {
		List<SafeStop> safeStops = safeStopService.findAllSafeStops();
		return new ResponseEntity<List<SafeStop>>(safeStops, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/safeStops/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SafeStop> getSafeStop(@PathVariable("id") long id, @RequestBody SafeStop safeStop) {
		SafeStop currentSafeStop = safeStopService.findById(id);
		if(currentSafeStop == null) {
			System.out.println("SafeStop with id " + id + " not found");
			return new ResponseEntity<SafeStop>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SafeStop>(safeStop, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/safeStops/{id}", method = RequestMethod.PUT)
	public ResponseEntity<SafeStop> udpateSafeStop(@PathVariable("id") long id, @RequestBody SafeStop safeStop) {
		System.out.println("Updating SafeStop with id: " + id);
		SafeStop currentSafeStop = safeStopService.findById(id);
		
		if(currentSafeStop == null) {
			System.out.println("SafeStop with id " + id + " not found");
			return new ResponseEntity<SafeStop>(HttpStatus.NOT_FOUND);
		}
		currentSafeStop.setName(safeStop.getName());
		currentSafeStop.setDescription(safeStop.getDescription());
		currentSafeStop.setRating(safeStop.getRating());
		safeStopService.updateSafeStop(currentSafeStop);
		return new ResponseEntity<SafeStop>(currentSafeStop, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/safeStops", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createSafeStop(@RequestBody SafeStop safeStop) {
//		if(safeStopService.isSafeStopExist(safeStop)) {
//			System.out.println("A SafeStop with name " + safeStop.getName() + " already exist");
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
		
		safeStopService.saveSafeStop(safeStop);
		System.out.println("New SafeStop added");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/safeStops/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<SafeStop> deleteSafeStop(@PathVariable("id") long id) {
		System.out.println("Getting safeStop with id of " + id + " to delete");
		
		SafeStop safeStopToDelete = safeStopService.findById(id);
		if (safeStopToDelete == null) {
			System.out.println("Safestop with id " + id + " not found");
			return new ResponseEntity<SafeStop>(HttpStatus.NOT_FOUND);
		}
		
		safeStopService.deleteSafeStop(id);
		System.out.println("Deleting SafeStop with id: " + id);
		return new ResponseEntity<SafeStop>(HttpStatus.NO_CONTENT);
	}

}
