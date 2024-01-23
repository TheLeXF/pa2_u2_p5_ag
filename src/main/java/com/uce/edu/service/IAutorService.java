package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
	public Autor buscar(Integer id);

	public void guardar(Autor autor);

	public void actualizar(Autor autor);

	public void borrar(Integer id);

	public Autor buscarPorNacionalidad(String nacionalidad);

	public Autor buscarPorNacionalidadNombre(String nombre, String nacionalidad);

}
