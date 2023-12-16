package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAlummnoRepository;
import com.uce.edu.repository.modelo.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService{
	@Autowired
	private IAlummnoRepository alummnoRepository;

	@Override
	public Alumno buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.alummnoRepository.seleccionar(id);
	}

	@Override
	public void agregar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alummnoRepository.insertar(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alummnoRepository.actualizar(alumno);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.alummnoRepository.eliminar(id);
	}
	

}
