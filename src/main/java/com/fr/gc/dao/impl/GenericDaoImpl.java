package com.fr.gc.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.fr.gc.dao.GenericDao;

public class GenericDaoImpl<T,K> implements GenericDao<T, K> {

	@Override
	public void save(T entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findById(K id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByCriteria(Criterion Crit) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
