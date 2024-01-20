package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
}
