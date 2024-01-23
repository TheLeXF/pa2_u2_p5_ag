package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

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
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Ciudadano seleccionar(Integer id) {
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void insertar(Ciudadano ciudadano) {
		this.entityManager.persist(ciudadano);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		Ciudadano ciud = this.seleccionar(id);
		this.entityManager.remove(ciud);
	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		// 1)SELECT p FROM Padre p
		// 2)SELECT p FROM Padre p, Hijo h WHERE en esta segunda opcion consume mas
		// recursos Hibernate
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula =: cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula = :cedula",
				Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Empleado seleccionarPorNombre(String nombre) {
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.nombre =: nombre", Empleado.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		// 0 Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity
		// Manager
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		// 1 Determinamos el tipo de retorno que va ah tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteria.createQuery(Ciudadano.class);
		// 2 Construir el SQL
		// 2.1 Determinar el from mendiante una interfaz (Root)
		// Nota: no necesariamente el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre=: dato// en este
		// SQL no me va retornar una instancia de
		// empleado pero en este caso el from es ciudadano
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		// 2.2 Construir las condiciones (WHERE) del SQL
		// Nota en CRITERIA API QUERY las condiciones se las conoce como "Predicate"
		// se usa para construir esta condicion c.apellido =: variable
		Predicate condicionApellido = myCriteria.equal(myFrom.get("apellido"), apellido);
		// 3 Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		// 4 Ejecutamos la consulta con un TypedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteria.createQuery(Ciudadano.class);
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);

		// String digitosProvincia=cedula.startsWith("17");
		Predicate condicionGenerica = null;

		if (cedula.startsWith("17")) {
			condicionGenerica = myCriteria.equal(myFrom.get("nombre"), nombre);// El primero se pone el nombre del
																				// atributo, y el segundo el nombre mi
																				// variable
		} else if (cedula.startsWith("05")) {
			condicionGenerica = myCriteria.equal(myFrom.get("apellido"), apellido);

		} else {
			condicionGenerica = myCriteria.equal(myFrom.get("cedula"), cedula);
		}
		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}
	
	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteria.createQuery(Ciudadano.class);
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);

		// String digitosProvincia=cedula.startsWith("17");
		Predicate condicionTotal = null;
		//c.nombre=: nombre
		Predicate condicionNombre = myCriteria.equal(myFrom.get("nombre"), nombre);
		//c.apellido=: apellido
		Predicate condicionApellido = myCriteria.equal(myFrom.get("apellido"), apellido);
		
		if (cedula.startsWith("17")) {
			//c.nombre=: nombre or c.apellido=: apellido
			condicionTotal = myCriteria.or(condicionNombre,condicionApellido);
		} else if (cedula.startsWith("05")) {
			//c.nombre=: nombre and c.apellido=: apellido
			condicionTotal = myCriteria.and(condicionNombre,condicionApellido);
		} 
		myCriteriaQuery.select(myFrom).where(condicionTotal);

		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

}
