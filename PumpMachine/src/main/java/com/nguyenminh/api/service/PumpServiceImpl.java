package com.nguyenminh.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenminh.api.dao.PumpDao;
import com.nguyenminh.api.entity.Pump;

@Service
public class PumpServiceImpl implements PumpService {
	
	@Autowired
	private PumpDao pumpDao;
	public PumpServiceImpl (PumpDao thePumpDao) {
		pumpDao = thePumpDao;
	}
	
	
	@Override
	@Transactional
	public List<Pump> findAll() {
		return pumpDao.findAll();
	}

	@Override
	@Transactional
	public Pump findById(int theId) {
		// TODO Auto-generated method stub
		return pumpDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Pump thePump) {
		pumpDao.save(thePump);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		pumpDao.deleteById(theId);

	}

}
