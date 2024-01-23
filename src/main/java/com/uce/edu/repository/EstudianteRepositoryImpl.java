package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Estudiante;

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
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estu = this.seleccionar(id);
		this.entityManager.remove(estu);
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante a WHERE a.estu_cedula = :cedula",
				Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombre(String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre", Estudiante.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreAndCedula(String nombre, String apellido, String cedula) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myCriteriaQuery = myCriteria.createQuery(Estudiante.class);
		Root<Estudiante> myFrom = myCriteriaQuery.from(Estudiante.class);
		Predicate condicionTotal = null;
		Predicate condicionNombre = myCriteria.equal(myFrom.get("nombre"), nombre);
		Predicate condicionCedula = myCriteria.equal(myFrom.get("cedula"), cedula);

		if (apellido.startsWith("G")) {
			condicionTotal = myCriteria.and(condicionNombre, condicionCedula);
		} else {
			condicionTotal = myCriteria.equal(myFrom.get("apellido"), apellido);
		}
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

}
