package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Autor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Autor a1=this.seleccionar(id);
		this.entityManager.remove(a1);
	}

	@Override
	public Autor seleccionarPorNacionalidad(String nacionalidad) {
		Query myQuery=this.entityManager.createNativeQuery("SELECT * FROM autor c WHERE c.auto_nacionalidad = :nacionalidad",Autor.class);
		myQuery.setParameter("nacionalidad", nacionalidad);
		return (Autor)myQuery.getSingleResult();
	}

}
