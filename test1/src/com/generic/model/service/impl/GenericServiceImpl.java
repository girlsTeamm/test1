package com.generic.model.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.generic.model.dao.GenericDao;
import com.generic.model.service.GenericService;

public class GenericServiceImpl<Entity extends Serializable,Dao extends Serializable, Id extends Serializable> implements GenericService<Entity, Id> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6182004085344210730L;
	
	protected Dao dao;
	
	

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Entity insert(Entity entity) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity, Id>)dao).insert(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Entity> insert(List<Entity> entities) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).insert(entities);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean update(Entity entity) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean update(List<Entity> entities) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).update(entities);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean delete(Entity entity) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean delete(List<Entity> entities) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).delete(entities);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean merge(Entity entity) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Entity getById(Id id) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Entity getByUniqueField(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).getByUniqueField(propertyName, propertyValue);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Entity load(Id id) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).load(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Entity> getPages(Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).getPages(start, pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Entity> getAll() {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).getAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Entity> getPagesByFilter(Integer start, Integer pageSize, String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).getPagesByFilter(start, pageSize, propertyName, propertyValue);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Entity> getAllByFilter(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		return ((GenericDao<Entity,Id>)dao).getAllByFilter(propertyName, propertyValue);
	}

}
