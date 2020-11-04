package dev.lucasliet.generic_dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

@SuppressWarnings("serial")
public class GenericDAO<T> implements Serializable {

	private final Class<T> classType;
	private EntityManager em;

	public GenericDAO(EntityManager manager, Class<T> classType) {
		this.em = manager;
		this.classType = classType;
	}

	public void add(T t) {
		em.persist(t);
	}

	public void remove(T t) {
		em.remove(em.merge(t));
	}

	public void update(T t) {
		em.merge(t);
	}

	public List<T> findAll() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classType);
		query.select(query.from(classType));

		List<T> list = em.createQuery(query).getResultList();

		return list;
	}

	public T findById(Integer id) {
		T instance = em.find(classType, id);
		return instance;
	}

	public List<T> findAllInPages(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classType);
		query.select(query.from(classType));

		List<T> list = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return list;
	}

}
