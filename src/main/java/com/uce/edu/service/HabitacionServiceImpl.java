package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionRepository;
import com.uce.edu.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionRepository habitacionRepository;

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionar(id);
	}

	@Override
	public void guardar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.insertar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.actualizar(habitacion);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.habitacionRepository.eliminar(id);
	}

	@Override
	public Habitacion buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorNumero(numero);
	}

	@Override
	public Habitacion buscarPorCriteria(String clase, String numero) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorCriteria(clase, numero);
	}
}
