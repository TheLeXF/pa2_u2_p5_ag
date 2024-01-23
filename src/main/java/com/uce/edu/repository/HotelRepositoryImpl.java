package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hotTemp = this.seleccionar(id);
		this.entityManager.remove(hotTemp);
	}

	@Override
	public Hotel seleccionarPorDireccion(String direccion) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h WHERE h.direccion =: direccion", Hotel.class);
		myQuery.setParameter("direccion", direccion);
		return myQuery.getSingleResult();
	}

	@Override
	public Hotel seleccionarPorNombreDireccion(String nombre, String direccion) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Hotel> myCriteriaQuery = myCriteria.createQuery(Hotel.class);
		Root<Hotel> myFrom = myCriteriaQuery.from(Hotel.class);
		Predicate condicionNombre = myCriteria.equal(myFrom.get("nombre"), nombre);
		Predicate condicionDireccion = myCriteria.equal(myFrom.get("direccion"), direccion);
		Predicate condicionTotal = myCriteria.and(condicionNombre,condicionDireccion);
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

}
