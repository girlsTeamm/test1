package com.generic.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable, Id extends Serializable> extends Serializable {

	public T insert(T t);

	public List<T> insert(List<T> t);

	public boolean update(T t);

	public boolean update(List<T> t);

	public boolean delete(T t);

	public boolean delete(List<T> t);

	public boolean merge(T t);

	public T getById(Id id);

	public T getByUniqueField(String propertyName, Object propertyValue);

	public T load(Id id);

	public List<T> getPages(Integer start, Integer pageSize);

	public List<T> getAll();

	public List<T> getPagesByFilter(Integer start, Integer pageSize, String propertyName, Object propertyValue);

	public List<T> getAllByFilter(String propertyName, Object propertyValue);

}
