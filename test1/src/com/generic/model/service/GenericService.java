package com.generic.model.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<Entity extends Serializable, Id extends Serializable> extends Serializable {
	public Entity insert(Entity entity);

	public List<Entity> insert(List<Entity> entities);

	public boolean update(Entity entity);

	public boolean update(List<Entity> entities);

	public boolean delete(Entity entity);

	public boolean delete(List<Entity> entities);

	public boolean merge(Entity entity);

	public Entity getById(Id id);

	public Entity getByUniqueField(String propertyName, Object propertyValue);

	public Entity load(Id id);

	public List<Entity> getPages(Integer start, Integer pageSize);

	public List<Entity> getAll();

	public List<Entity> getPagesByFilter(Integer start, Integer pageSize, String propertyName, Object propertyValue);

	public List<Entity> getAllByFilter(String propertyName, Object propertyValue);

}
