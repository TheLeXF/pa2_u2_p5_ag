package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

@SpringBootApplication
public class Pa2U2P5AgApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IEmpleadoService empleadoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Ciudadano c1 = new Ciudadano();

		c1.setApellido("Guanoluisa");
		c1.setNombre("Santiago");
	
		Empleado e1 = new Empleado();

		e1.setFechIngreso(LocalDateTime.now());
		e1.setSalario(new BigDecimal(250.00));
		e1.setCiudadano(c1);
		this.ciudadanoService.agregar(c1);
		
		Empleado eTemp= this.empleadoService.buscar(1);
		
		System.out.println(eTemp);
		
		Empleado e2 = new Empleado();
		e2.setCiudadano(c1);
		this.empleadoService.actualizar(e2);
		
		this.empleadoService.borrar(11);
		
		this.ciudadanoService.borrar(3);
		
		

		
	}

}
