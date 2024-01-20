package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoService {

	public Alumno buscar(Integer id);

	public void agregar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void borrar(Integer id);

	public Alumno buscarPorNoMatricula(String noMatricula);

	public List<Alumno> buscarPorFechaMatricula(LocalDateTime fechaMatricula);
}
