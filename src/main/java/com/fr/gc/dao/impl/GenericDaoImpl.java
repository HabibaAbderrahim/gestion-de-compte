package com.fr.gc.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import com.fr.gc.dao.GenericDao;
import com.fr.gc.utils.HibernateUtil;

public class GenericDaoImpl<T, K extends Serializable> implements GenericDao<T, K> {

	// protected so service wont open session
	// only for dao

	protected Session hibernateSession;
	private Transaction tx;
	private Class<T> clazz ;// not personne not specific something generic clazz
	
	
	//selon type d'argument
	public GenericDaoImpl() {
		clazz= (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected void startOperation() {
		hibernateSession = HibernateUtil.getInstance().getSessionFactory().openSession();
		tx = hibernateSession.beginTransaction();
	}

	protected void endOperation() {
		tx.commit();
		hibernateSession.close();

	}

	@Override
	public void save(T entity) throws Exception {
		startOperation();
		hibernateSession.save(entity); // na7a el insert into balala
		endOperation();

	}

	@Override
	public void update(T entity) throws Exception {
		startOperation();
		hibernateSession.update(entity);
		endOperation();

	}

	@Override
	public void delete(T entity) throws Exception {
		startOperation();
		hibernateSession.delete(entity);
		endOperation();
	}

	@Override
	public T findById(K id) throws Exception {
		startOperation();
		//get null load exp
		T entity = (T) hibernateSession.get(clazz,id);//
		hibernateSession.close();
		
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
