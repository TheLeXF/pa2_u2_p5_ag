package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner{
	
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//1 Agregar
		Estudiante e1= new Estudiante();
		e1.setApellido("Guanoluisa");
		e1.setNombre("Alexis");
		e1.setCedula("1727450296");
		e1.setFechaNacimiento(LocalDateTime.of(1999, 01, 12,11, 25));
		
		Alumno a1 = new Alumno();
		a1.setNombre("Fernando");
		
		
		this.alumnoService.agregar(a1);
		
		//2 Buscar
		
		this.estudianteService.buscar(6);
		System.out.println(this.estudianteService.buscar(6));
		
		this.alumnoService.buscar(1);
		System.out.println(this.alumnoService.buscar(1));
		
		//3 Actualizar
		Estudiante e2 = this.estudianteService.buscar(5);
		e2.setApellido("Espin");
		this.estudianteService.actualizar(e2);
		
		Alumno a2 = this.alumnoService.buscar(1);
		a2.setNombre("Actualizado");
		this.alumnoService.actualizar(a2);
		
		//4 borrar
		
		this.estudianteService.borrar(6);
		this.alumnoService.borrar(1);
	}

}
