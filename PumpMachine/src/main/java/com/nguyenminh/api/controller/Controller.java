package com.nguyenminh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenminh.api.entity.Pump;
import com.nguyenminh.api.service.PumpService;

@RestController
@RequestMapping("/api")
public class Controller {

private PumpService pumpService;
	@Autowired
	public Controller (PumpService thePumpService) {
		pumpService = thePumpService;
	}
	
	@GetMapping("/alldetail")
	public List<Pump> findAll(){
		return pumpService.findAll();
	} 
	
	// get/ moistureID
	
	@GetMapping("detail/{moistureId}")
	public Pump getPump(@PathVariable int PumpId) {
		Pump thePump = pumpService.findById(PumpId);
		if(thePump == null) {
			throw new RuntimeException("Moisture id did not found");
			

	}
		return thePump;
}
	// add new moisture 
	
	@PostMapping("/update")
	public Pump addPump(@RequestParam("humidlevel") int humidlevel, 
			@RequestParam("latitude") double latitude ,
			@RequestParam("longitude") double longitude,
			@RequestParam("aiwatering") String aiwatering ,
			@RequestParam("autowatering") String autowatering ,
			@RequestParam("manualwatering") String manualwatering 
			) 
	{
		Pump pump = new Pump();
		pump.setAiwatering(aiwatering);
		pump.setAutowatering(autowatering);
		pump.setHumidlevel(humidlevel);
		pump.setLatitude(latitude);
		pump.setLongitude(longitude);
		pump.setManualwatering(manualwatering);
		pump.setId(0);
		pump.setHumidlevel(humidlevel);
		
		pumpService.save(pump);
		
		return pump;
		
	}
	
	
	
	/*	@PostMapping("/updatedetail")
	public Pump addPump(@RequestBody Pump thePump) {
		// set id to 0 
		
		// force to save new item
		
		thePump.setId(0);
		pumpService.save(thePump);
		return thePump;
	}
	 */
	//update moisture
	@PutMapping("/updatedetail")
	public Pump updatePump(@RequestBody Pump thePump) {
		pumpService.save(thePump);
		return thePump;
	}
	
	// delete moisture
	@DeleteMapping("/updatedetail/{moistureId}")
	public String deleteMoisture(@PathVariable int moistureId) {
		Pump tempPump = pumpService.findById(moistureId);
		// throw exception
		if (tempPump == null) {
			throw new RuntimeException("no moisture");
			
		}
		pumpService.deleteById(moistureId);
		return "delete moisture id - " + moistureId;
	}
}
