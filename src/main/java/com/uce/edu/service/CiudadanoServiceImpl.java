package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService{
	
	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public Ciudadano buscar(Integer id) {
		return this.ciudadanoRepository.seleccionar(id);
	}
	
	@Override
	public void agregar(Ciudadano ciudadano) {
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		this.ciudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public void borrar(Integer id) {
		this.ciudadanoRepository.eliminar(id);
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public Ciudadano buscarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCedulaCiu(cedula);
	}
	

}
