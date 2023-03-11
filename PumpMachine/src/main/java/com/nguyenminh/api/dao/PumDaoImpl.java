package com.nguyenminh.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenminh.api.entity.Pump;

import jakarta.persistence.EntityManager;

@Repository
public class PumDaoImpl implements PumpDao {
	
		private EntityManager entityManager;
		
		@Autowired
		public PumDaoImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		

	@Override

	public List<Pump> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Pump> theQuery = 
				currentSession.createQuery("from Pump", Pump.class);
		
		List<Pump> pumps = theQuery.getResultList();
		return pumps;
	}


	@Override
	public Pump findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Pump theMoisture = currentSession.get(Pump.class, theId);
		
		return theMoisture;
	}


	@Override
	public void save(Pump thePump) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(thePump);
	}


	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery =
					currentSession.createQuery(
								"delete from Moisture where id=: moistureId");
		theQuery.setParameter("moistureId", theId);
		theQuery.executeUpdate();
	}



}