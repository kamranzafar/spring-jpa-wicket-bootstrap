package org.kamranzafar.samples.openjee.dao;

import java.util.Collection;
import java.util.List;

/**
 * @author kamran
 * 
 * @param <E>
 * @param <K>
 */
public interface Dao<E, K> {
	public void persist(E entity);

	public void persist(List<E> entities);

	public void remove(E entity);

	public void remove(List<E> entities);

	public E findById(K id);

	public Collection<E> findAll();

	public Class getEntityClass();
}