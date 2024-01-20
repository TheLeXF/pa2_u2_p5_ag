package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlumnoRepositoryImpl implements IAlummnoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Alumno seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void insertar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.persist(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.merge(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Alumno alu = this.seleccionar(id);
		this.entityManager.remove(alu);
	}

	@Override
	public Alumno seleccionarPorNoMatricula(String noMatricula) {
		Query myQuery=this.entityManager.createNativeQuery("SELECT * FROM alumno a WHERE a.alum_no_matricula = :noMatricula",Alumno.class);
		myQuery.setParameter("noMatricula", noMatricula);
		return (Alumno)myQuery.getSingleResult();
	}

	@Override
	public List<Alumno> seleccionarPorFechaMatricula(LocalDateTime fechaMatricula) {
		TypedQuery<Alumno> myQuery = this.entityManager	
				.createQuery("SELECT a FROM Alumno a WHERE a.fechaMatricula >= : fechaMatricula", Alumno.class);
		myQuery.setParameter("fechaMatricula", fechaMatricula);
		return myQuery.getResultList();
	}
	
}
