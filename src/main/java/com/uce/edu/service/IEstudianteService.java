package com.uce.edu.service;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	public Estudiante buscar(Integer id);

	public void agregar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void borrar(Integer id);
	
	public Estudiante seleccionarPorCedula(String cedula);
	
	public Estudiante seleccionarPorNombre(String nombre);
	
	public Estudiante buscarPorNombreAndCedula(String nombre, String apellido, String cedula);
}
