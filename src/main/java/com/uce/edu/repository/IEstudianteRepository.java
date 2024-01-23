package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	// CRUD
	public Estudiante seleccionar(Integer id);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
	
	public Estudiante seleccionarPorCedula(String cedula);
	
	public Estudiante seleccionarPorNombre(String nombre);
	
	public Estudiante seleccionarPorNombreAndCedula(String nombre, String apellido, String cedula);

	
}
