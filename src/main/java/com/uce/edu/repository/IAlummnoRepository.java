package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlummnoRepository {
	
	public Alumno seleccionar(Integer id);

	public void insertar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void eliminar(Integer id);
	
	public Alumno seleccionarPorNoMatricula(String noMatricula);
	
	public List<Alumno> seleccionarPorFechaMatricula(LocalDateTime fechaMatricula);
	
}
