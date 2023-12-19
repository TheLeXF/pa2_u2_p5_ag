package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner{
	
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Ciudadano c1= new Ciudadano();
		
		
		c1.setApellido("Guanoluisa");
		c1.setNombre("Alexis");
		
		Empleado e1 = new Empleado();
		
		e1.setFechIngreso(LocalDateTime.now());
		e1.setSalario(new BigDecimal(100.00));
		
		Ciudadano c2 = this.ciudadanoService.buscar(1);
		e1.setCiudadano(c2);
		//this.ciudadanoService.agregar(c1);
		this.empleadoService.agregar(e1);
		
	}

}
