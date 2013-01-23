package org.kamranzafar.samples.openjee.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author kamran
 * 
 * @param <E>
 * @param <K>
 */
public abstract class BaseDao<E, K> implements Dao<E, K> {
	protected Class entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public BaseDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public void persist(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public void persist(List<E> entities) {
		for (E entity : entities) {
			entityManager.persist(entity);
		}
	}

	@Override
	public void remove(E entity) {
		entityManager.remove(entity);
	}

	@Override
	public void remove(List<E> entities) {
		for (E entity : entities) {
			entityManager.remove(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(K id) {
		return (E) entityManager.find(entityClass, id);
	}

	@Override
	public Class getEntityClass() {
		return entityClass;
	}

	@Override
	public Collection<E> findAll() {
		Query query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
		return query.getResultList();
	}
}