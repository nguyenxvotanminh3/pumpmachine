package com.nguyenminh.api.service;

import java.util.List;

import com.nguyenminh.api.entity.Pump;

public interface PumpService {
	
	public List<Pump> findAll();
	
	public Pump findById(int theId);
	
	public void save(Pump thePump);
	
	public void deleteById(int theId);
}
