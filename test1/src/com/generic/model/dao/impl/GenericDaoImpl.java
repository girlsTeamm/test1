package com.generic.model.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.generic.model.dao.GenericDao;

public class GenericDaoImpl<T extends Serializable, Id extends Serializable> implements GenericDao<T, Id> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7955429492191209773L;
	final protected static Log log = LogFactory.getLog(GenericDaoImpl.class);
	transient protected SessionFactory sessionFactory;
	protected Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public T insert(T t) {
		// TODO Auto-generated method stub
		Session session = null;
		Serializable id = null;
		try {
			log.info("Getting session for persisting " + persistentClass + " in DB");
			session = sessionFactory.getCurrentSession();
			log.info("Persisting " + persistentClass + " in DB");
			id = session.save(t);
			session.flush();
			session.clear();
			log.info(persistentClass + " persisted in DB with id = " + id);
		} catch (Exception e) {
			t=null;
			log.error(persistentClass + " can't be persisted in DB because of the following Exception ");
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<T> insert(List<T> t) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			log.info("Getting session for persisting a set of " + persistentClass + " in DB");
			session = sessionFactory.getCurrentSession();
			log.info("Persisting a set of " + persistentClass + " in DB");

			for (int i = 0; i < t.size(); i++) {
				session.save(t.get(i));
				if ((i + 1) % 20 == 0) {
					session.flush();
					session.clear();
				}
			}
			log.info("Set of " + persistentClass + " persisted in DB");
		} catch (Exception e) {
			t=null;
			log.error("Set of " + persistentClass + " can't be persisted in DB because of the following Exception ");
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			log.info("Getting session for updating " + persistentClass + " in DB");
			session = sessionFactory.getCurrentSession();
			log.info("Updating " + persistentClass + " in DB");
			session.update(t);
			session.flush();
			session.clear();
			log.info(persistentClass + " updated in DB");
			return true;
		} catch (Exception e) {
			log.error(persistentClass + " can't be updated in DB because of the following Exception ");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(List<T> t) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			log.info("Getting session for updating " + persistentClass + " in DB");
			session = sessionFactory.getCurrentSession();
			for (int i = 0; i < t.size(); i++) {

				log.info("Updating " + persistentClass + " in DB");
				session.update(t.get(i));
				if ((i + 1) % 20 == 0) {
					session.flush();
					session.clear();
				}
				log.info(persistentClass + " updated in DB");
			}
			return true;
		} catch (Exception e) {
			log.error(persistentClass + " can't be updated in DB because of the following Exception ");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			log.info("Getting session for deleting " + persistentClass + " from DB");
			session = sessionFactory.getCurrentSession();
			log.info("Deleting " + persistentClass + " from DB");
			session.delete(t);
			session.flush();
			session.clear();
			log.info(persistentClass + " deleted from DB");
			return true;
		} catch (Exception e) {
			log.error(persistentClass + " can't be deleted from DB because of the following Exception ");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(List<T> t) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			log.info("Getting session for deleting " + persistentClass + " from DB");

			session = sessionFactory.getCurrentSession();
			log.info("Deleting " + persistentClass + " from DB");
			for (int i = 0; i < t.size(); i++) {
				session.delete(t.get(i));
				if ((i + 1) % 20 == 0) {
					session.flush();
					session.clear();
				}
			}
			log.info(persistentClass + " deleted from DB");
			return true;
		} catch (Exception e) {
			log.error(persistentClass + " can't be deleted from DB because of the following Exception ");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean merge(T t) {
		Session session = null;
		try {
			log.info("Getting session for updating " + persistentClass + " in DB");
			session = sessionFactory.getCurrentSession();
			log.info("Updating " + persistentClass + " in DB");
			session.merge(t);
			session.flush();

			session.clear();
			log.info(persistentClass + " updated in DB");
			return true;
		} catch (Exception e) {
			log.error(persistentClass + " can't be updated in DB because of the following Exception ");
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPages(Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		Session session = null;
		List<T> result = null;
		Query query = null;
		String hql = "from " + persistentClass.getSimpleName();
		try {
			log.info(" getting " + persistentClass);
			session = sessionFactory.getCurrentSession();
			query = session.createQuery(hql);
			if (start != null && pageSize != null) {
				query.setFirstResult(start);
				query.setMaxResults(pageSize);
			}
			result = query.list();
			log.info(persistentClass);

		} catch (Exception e) {
			log.error(persistentClass + " can't be fetched from DB because of the following Exception ");
			e.printStackTrace();

		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Id id) {
		// TODO Auto-generated method stub
		Session session = null;
		T fetchedObj = null;
		try {
			session = sessionFactory.getCurrentSession();
			log.info("Getting " + persistentClass + " of id = " + id + " from DB");
			fetchedObj = (T) session.get(persistentClass, id);
		} catch (Exception e) {
			log.error(persistentClass + " can't be fetched from DB because of the following Exception ");
			e.printStackTrace();
		}
		return fetchedObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getByUniqueField(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		Session session = null;
		T fetchedObj = null;
		Criteria criteria = null;
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(persistentClass);
			if (propertyValue != null)
				criteria.add(Restrictions.eq(propertyName, propertyValue));
			log.info("Getting " + persistentClass + " from DB");
			fetchedObj = (T) criteria.uniqueResult();

		} catch (Exception e) {
			log.error(persistentClass + " can't be fetched from DB because of the following Exception ");
			e.printStackTrace();
		}
		return fetchedObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(Id id) {
		// TODO Auto-generated method stub
		Session session = null;
		T fetchedObj = null;
		try {
			session = sessionFactory.getCurrentSession();
			log.info("Getting " + persistentClass + " from DB");
			fetchedObj = (T) session.load(persistentClass, id);
		} catch (Exception e) {
			log.error(persistentClass + " can't be fetched from DB because of the following Exception ");
			e.printStackTrace();
		}
		return fetchedObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> getAll() {
		// TODO Auto-generated method stub
		Session session = null;
		List<T> result = null;
		Query query = null;
		String hql = "from " + persistentClass.getSimpleName();
		try {
			log.info(" getting all from  " + persistentClass);
			session = sessionFactory.getCurrentSession();
			query = session.createQuery(hql);
			result = query.list();
			log.info(persistentClass);

		} catch (Exception e) {
			log.error(persistentClass + " can't be fetched from DB because of the following Exception ");
			e.printStackTrace();

		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPagesByFilter(Integer start, Integer pageSize, String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		Session session = null;
		List<T> result = null;
		Query query = null;

		try {
			String hql = "from " + persistentClass.getSimpleName() + " where "
					+ persistentClass.getDeclaredField(propertyName).getName() + " = " + " :fieldValue";
			session = sessionFactory.getCurrentSession();
			log.info("Getting page " + start + "from" + persistentClass + "where "
					+ persistentClass.getDeclaredField(propertyName).getName() + " = " + propertyValue.toString());
			query = session.createQuery(hql);
			query.setParameter("fieldValue", propertyValue);
			if (start != null && pageSize != null) {
				query.setFirstResult(start);
				query.setMaxResults(pageSize);
			}
			result = query.list();

		} catch (Exception e) {
			log.error(persistentClass + " can't be fetched from DB because of the following Exception ");
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllByFilter(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		Session session = null;
		List<T> result = null;
		Query query = null;

		try {
			String hql = "from " + persistentClass.getSimpleName() + " where "
					+ persistentClass.getDeclaredField(propertyName).getName() + " = ?";
			session = sessionFactory.getCurrentSession();
			log.info("Getting all page " + "from" + persistentClass + " where "
					+ persistentClass.getDeclaredField(propertyName).getName() + " = " + propertyValue.toString());
			query = session.createQuery(hql);
			// query.setParameter("fieldValue", fieldValue);
			query.setString(0,propertyValue.toString());
			result = query.list();

		} catch (Exception e) {
			log.error(persistentClass + " can't be fetched from DB because of the following Exception ");
			e.printStackTrace();
		}
		return result;
	}

}
