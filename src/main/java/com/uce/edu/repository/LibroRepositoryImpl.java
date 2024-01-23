package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

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
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void insertar(Libro libro) {
		this.entityManager.persist(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Libro l1 = this.seleccionar(id);
		this.entityManager.remove(l1);
	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		// SQL select * FROM libro l Where l.libr_titulo = ?
		// JPQL SELECT l FROM Libro l WHERE l.titulo = :variable
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :variable");//SQL 1
		myQuery.setParameter("variable", nombre);
		// return (Libro) myQuery.getSingleResult();// Solo obtengo un unico resultado,
		// y si me da mas resultados da error
		return (Libro) myQuery.getResultList().get(0);// Para obtener el primer registro de la lista
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM libro l WHERE l.libr_fecha_publicacion >=?
		// JPQL SELECT l FROM Libro l WHERE l.fechaPublicacion >= : fecha
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= : fecha");
		myQuery.setParameter("fecha", fechaPublicacion);
		return (List<Libro>) myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo",
				Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager	
				.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= : fecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery=this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery=this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorEditorial(String editorial) {
		Query myQuery=this.entityManager.createNativeQuery("SELECT * FROM libro l WHERE l.libr_editorial = :editorial",Libro.class);
		myQuery.setParameter("editorial", editorial);
		return (Libro)myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorArea(String area) {
		TypedQuery<Libro> myQuery = this.entityManager	
				.createQuery("SELECT l FROM Libro l WHERE l.area = : area", Libro.class);
		myQuery.setParameter("area", area);
		return myQuery.getResultList();
	}

	@Override
	public List<Libro> seleccionarPorAreaOrEditorial(String area, String editorial, String titulo) {
		
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Libro> myCriteriaQuery = myCriteria.createQuery(Libro.class);
		Root<Libro> myFrom = myCriteriaQuery.from(Libro.class);
		Predicate condicionTotal = null;
		Predicate condicionArea = myCriteria.equal(myFrom.get("area"), area);
		Predicate condicionTitulo = myCriteria.equal(myFrom.get("titulo"), titulo);
		
		if (area.equals("Programacion")) {
			condicionTotal = myCriteria.or(condicionArea,condicionTitulo);
		} else if (area.equals("Literatura")) {
			condicionTotal = myCriteria.equal(myFrom.get("titulo"),titulo );
		} 
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		TypedQuery<Libro> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getResultList();
	}
}
