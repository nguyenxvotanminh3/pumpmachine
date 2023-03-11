package com.nguyenminh.api.dao;
import com.nguyenminh.api.entity.*;
import java.util.List;
public interface PumpDao {
	public Pump findById(int theId);
	public List<Pump> findAll();
	public void save(Pump theMoisture);
	public void deleteById(int Id);
}
