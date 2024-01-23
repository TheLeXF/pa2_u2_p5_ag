package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion hab = this.seleccionar(id);
		this.entityManager.remove(hab);
	}

	@Override
	public Habitacion seleccionarPorNumero(String numero) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM habitacion c WHERE c.habi_numero = :numero",
				Habitacion.class);
		myQuery.setParameter("numero", numero);
		return (Habitacion) myQuery.getSingleResult();
	}

	@Override
	public Habitacion seleccionarPorCriteria(String clase, String numero) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Habitacion> myCriteriaQuery = myCriteria.createQuery(Habitacion.class);
		Root<Habitacion> myFrom = myCriteriaQuery.from(Habitacion.class);
		Predicate condicionTotal = null;
		if (clase.startsWith("A")) {
			condicionTotal = myCriteria.equal(myFrom.get("numero"), numero);
		} else {
			condicionTotal = myCriteria.equal(myFrom.get("clase"), clase);
		}
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		TypedQuery<Habitacion> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
		
	}

}
