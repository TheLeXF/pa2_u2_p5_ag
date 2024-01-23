package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;

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
		Autor a1 = this.seleccionar(id);
		this.entityManager.remove(a1);
	}

	@Override
	public Autor seleccionarPorNacionalidad(String nacionalidad) {
		Query myQuery = this.entityManager
				.createNativeQuery("SELECT * FROM autor c WHERE c.auto_nacionalidad = :nacionalidad", Autor.class);
		myQuery.setParameter("nacionalidad", nacionalidad);
		return (Autor) myQuery.getSingleResult();
	}

	@Override
	public Autor seleccionarPorNacionalidadNombre(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Autor> myCriteriaQuery = myCriteria.createQuery(Autor.class);
		Root<Autor> myFrom = myCriteriaQuery.from(Autor.class);

		Predicate predicadoInicial = null;
	
		if (nacionalidad.equals("Ecuatoriano")) {
			predicadoInicial = myCriteria.equal(myFrom.get("nombre"), nombre);
		}else if(nombre.equals("Daniel")) {
			predicadoInicial = myCriteria.equal(myFrom.get("nacionalidad"), nacionalidad);
		}
		myCriteriaQuery.select(myFrom).where(predicadoInicial);
		TypedQuery<Autor> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return typedQuery.getSingleResult();
	}

}
