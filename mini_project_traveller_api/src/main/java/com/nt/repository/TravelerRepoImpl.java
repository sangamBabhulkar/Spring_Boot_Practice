package com.nt.repository;

import com.nt.entity.TravellerEntity;
import com.nt.utility.HibernateUtil;

import jakarta.websocket.Session;

public class TravelerRepoImpl implements ITravellerRepo{
	
	public int saveTraveller(TravellerEntity entity) {
		
		Session session = null;
		Transaction tx = null;
		int idVal = 0;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beingTransaction();
			
			session.persist(entity);
			
			tx.commit();
			
			idVal = entity.getTid
		}
	}
}
