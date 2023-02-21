package com.safeStops.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safeStops.model.SafeStop;

@Repository
public class SafeStopDAOImpl implements SafeStopDAO {
	
	@Autowired private SessionFactory sessionFactory;

	@Override
	public SafeStop findById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(SafeStop.class, id);
	}

	@Override
	public SafeStop findByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(SafeStop.class, name);
	}

	@Override
	public void saveSafeStop(SafeStop safeStop) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(safeStop);
		
	}

	@Override
	public void updateSafeStop(SafeStop safeStop) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(safeStop);
		
	}

	@Override
	public void deleteSafeStop(Long id) {		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from SafeStop where id= :id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<SafeStop> findAllSafeStops() {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = currentSession.getCriteriaBuilder();
		CriteriaQuery<SafeStop> cq = cb.createQuery(SafeStop.class);
		Root<SafeStop> root = cq.from(SafeStop.class);
		cq.select(root);
		Query query = currentSession.createQuery(cq);
		return query.getResultList();
	}


}
